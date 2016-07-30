package com.assignment.moviefinder.net.apis;

abstract class _AbstractAPIHelper<S> {
    protected S mService;

    public _AbstractAPIHelper(Class<S> serviceClass) {
        mService = RestAdapterFactory.getAdapter().create(serviceClass);
    }
}
