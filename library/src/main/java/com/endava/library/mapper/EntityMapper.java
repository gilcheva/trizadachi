package com.endava.library.mapper;

import java.util.Collection;

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    Collection<E> toEntity(Collection<D> dtoList);

    Collection<D> toDto(Collection<E> entityList);
}
