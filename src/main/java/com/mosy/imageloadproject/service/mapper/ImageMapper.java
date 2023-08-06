package com.mosy.imageloadproject.service.mapper;

public interface ImageMapper<I extends Entity, D extends Entity> {
    I toEntity(D dto);

    D toDto(I entity);
}
