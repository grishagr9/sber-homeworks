package org.example.hw8;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
public class CacheProxy {

    private ServiceImpl service;

    public Service cache(ServiceImpl service) {
        this.service = service;
        return this.service;
    }

    public Loader cache(LoaderImpl service) {
        return new LoaderImpl();
    }

    public <T> T cache(T service) {
        ClassLoader classLoader = service.getClass().getClassLoader();
        Class<?>[] interfaces = service.getClass().getInterfaces();

        InvocationHandler handler = new CachedInvocationHandler(service);

        return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
