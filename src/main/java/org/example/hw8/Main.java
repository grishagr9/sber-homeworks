package org.example.hw8;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy();
        Service service = cacheProxy.cache(new ServiceImpl());
        Loader loader = cacheProxy.cache(new LoaderImpl());

        service.run("item1", 5);

    }
}
