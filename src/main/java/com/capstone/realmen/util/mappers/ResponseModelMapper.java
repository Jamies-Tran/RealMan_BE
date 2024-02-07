package com.capstone.realmen.util.mappers;

public interface ResponseModelMapper<M, D> {
    M toModel(D dto);
}
