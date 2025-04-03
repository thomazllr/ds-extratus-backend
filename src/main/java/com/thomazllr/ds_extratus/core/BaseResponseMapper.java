package com.thomazllr.ds_extratus.core;

public interface BaseResponseMapper<T, Q> {

    Q toResponse(T entity);

    T fromResponse(Q response);
}
