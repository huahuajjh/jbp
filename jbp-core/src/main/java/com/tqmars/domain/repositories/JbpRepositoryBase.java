package com.tqmars.domain.repositories;

import com.tqmars.domain.entities.IEntityOfTPrimaryKey;

/**
 * Created by jjh on 17-5-4.
 */
public abstract class JbpRepositoryBase<TEntity extends IEntityOfTPrimaryKey<TPrimaryKey>,TPrimaryKey> implements IRepository<TEntity,TPrimaryKey>
{

}
