package org.example.hw8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.zip.GZIPOutputStream;

public class CachedInvocationHandler implements InvocationHandler {

    private final Map<Object, Object> cache = new HashMap<>();
    private final Object target;

    public CachedInvocationHandler(Object delegate) {
        this.target = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);

        if (cacheAnnotation != null) {
            String cacheKey = generateCacheKey(method, args);

            if (cache.containsKey(cacheKey)) {
                System.out.println("Cache hit for key: " + cacheKey);
                return cache.get(cacheKey);
            }

            Object result = method.invoke(target, args);

            cache.put(cacheKey, result);

            applyCacheSettings(cacheAnnotation, cacheKey, result);

            return result;
        } else {
            return method.invoke(target, args);
        }
    }


    private String generateCacheKey(Method method, Object[] args) {
        StringBuilder keyBuilder = new StringBuilder();

        keyBuilder.append(method.getName());

        for (Object arg : args) {
            keyBuilder.append("_").append(arg);
        }

        return keyBuilder.toString();
    }

    private void applyCacheSettings(Cache cacheAnnotation, String cacheKey, Object result) {
        if (cacheAnnotation.cacheType() == CacheType.FILE && cacheAnnotation.zip()) {
            saveToDiskWithCompression(cacheKey, result);
        }
    }

    private void saveToDiskWithCompression(String cacheKey, Object result) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new GZIPOutputStream(new FileOutputStream(cacheKey + ".gz")))) {
            oos.writeObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}