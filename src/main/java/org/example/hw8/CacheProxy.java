package org.example.hw8;

public class CacheProxy {

    private ServiceImpl service;

    public Service cache(ServiceImpl service) {
        this.service = service;
        return this.service;
    }

    public Loader cache(LoaderImpl service) {
        return new LoaderImpl();
    }
}
