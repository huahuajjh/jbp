package com.tqmars.domain.repositories;

import com.tqmars.domain.entities.IEntityOfTPrimaryKey;

/**
 * Created by jjh on 17-3-20.
 */
public interface IRepositoryOfTEntity<TEntity extends IEntityOfTPrimaryKey<Integer>> extends IRepository<TEntity,Integer> {
}
