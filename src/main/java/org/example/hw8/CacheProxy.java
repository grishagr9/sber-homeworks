package org.example.hw8;

public class CacheProxy {
    public Service cache(ServiceImpl service) {
        return new ServiceImpl();
    }

    public Loader cache(LoaderImpl service) {
        return new LoaderImpl();
    }
}
