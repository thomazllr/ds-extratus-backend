package com.thomazllr.ds_extratus.core;

public interface BaseRequestMapper<T, R>{

    T fromRequest(R request);

    R toRequest(T entity);
}
