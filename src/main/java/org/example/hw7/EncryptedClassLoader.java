package org.example.hw7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncryptedClassLoader extends ClassLoader{
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent){
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try{
            bytes = Files.readAllBytes(dir.toPath());
            decode(bytes);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

    private void decode(byte[] encoded) {
        byte delta = (byte) key.length();

        for (var i = 0; i < encoded.length; ++i)
            encoded[i] += delta;
    }
}
