package com.capstone.realmen.util.mappers;

public interface InfoMapper<I, D> {
    D toDto(I info);
}
