package com.tqmars.domain.entities;

/**
 * Created by jjh on 17-3-19.
 */

/**
 * entity interface, inherit this interface indicate that a object is a entity
 * @author jjh
 * @param <TPrimaryKey>    primary key type
 */
public interface IEntityOfTPrimaryKey<TPrimaryKey> {
    TPrimaryKey getId();
    void setId(TPrimaryKey id);

    String getTableName();
    void setTableName(String tableName);
}
