package org.example.hw7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class EncryptedClassLoaderTest {

    private final EncryptedClassLoader classLoader = new EncryptedClassLoader("a", new File("src/test/java"), getClass().getClassLoader());

    @Test
    void givenValidClassClassname_whenFindClass_thenOk() throws ClassNotFoundException {
        // given
        var encodedClassBinaryName = "hw7.Test";
        // when
        Class<?> loadedClass = classLoader.findClass(encodedClassBinaryName);

        // then
        Assertions.assertNotNull(loadedClass);
    }
}