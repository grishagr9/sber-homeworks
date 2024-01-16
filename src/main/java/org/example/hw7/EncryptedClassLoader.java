package org.example.hw7;

import java.io.File;

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

        return super.findClass(name);
    }
}
