package com.capstone.realmen.util.mappers;

public interface RequestModelMapper<M, D> {
    D toDto(M model);
}
