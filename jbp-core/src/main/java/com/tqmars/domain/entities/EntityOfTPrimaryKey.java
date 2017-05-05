package com.tqmars.domain.entities;

import com.tqmars.domain.entities.exception.NotSpecifyTableNameException;

/**
 * Created by jjh on 17-3-19.
 */
public abstract class EntityOfTPrimaryKey<TPrimaryKey> implements IEntityOfTPrimaryKey<TPrimaryKey>{
    protected TPrimaryKey id;
    protected String tableName;

    public EntityOfTPrimaryKey(String tableName) {
        if(null == tableName || tableName.trim().equals(""))
        {
            throw new NotSpecifyTableNameException("table name cannot be null value or empty string value");
        }
        this.tableName = tableName;
    }

    @Override
    public TPrimaryKey getId() {
        return id;
    }

    @Override
    public void setId(TPrimaryKey id) {
        this.id = id;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
