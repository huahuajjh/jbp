package com.tqmars.domain.repositories;

import com.tqmars.domain.entities.IEntityOfTPrimaryKey;

import java.util.List;
import java.util.Map;

/**
 * Created by jjh on 17-3-19.
 */
public interface IRepository<TEntity extends IEntityOfTPrimaryKey<TPrimaryKey>,TPrimaryKey> {
    //query
    TEntity get(TPrimaryKey id);
    TEntity get(TPrimaryKey id,String... properties);
    TEntity getOne(String where);
    TEntity getOne(String where,String... properties);
    List<TEntity> getAll();
    List<TEntity> getAll(String... properties);
    List<TEntity> getAllWithCondition(String where);
    List<TEntity> getAllWithCondition(String... properties);
    List<TEntity> getAllWithConditionByPage(String where,int pageIndex,int pageSize);
    List<TEntity> getAllWithConditionByPage(String where,int pageIndex,int pageSize,String... properties);

    //update
    TEntity updateAndGetEntity(TEntity entity);
    void update(TEntity entity);
    void updateSpecifyProperties(TPrimaryKey id,Map<String,Object> entityPropertiesMap);
    void updateSpecifyProperties(TPrimaryKey id,String[] properties, Object[] values);

    //insert
    TEntity add(TEntity entity);
    TPrimaryKey addAndGetId(TEntity entity);
    void addList(List<TEntity> entityList);

    //delete
    void remove(TEntity entity);
    void remove(TPrimaryKey id);
    void removeWithCondition(String where);

    //aggregates
    int count();
    int count(String where);
    boolean exists(String where);
}
