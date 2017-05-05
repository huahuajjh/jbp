package com.tqmars.domain.entities;

/**
 * Created by jjh on 17-3-19.
 */

/**
 * @author jjh
 * default abstract class which use integer as its primary key type
 */
public abstract class Entity extends EntityOfTPrimaryKey<Integer>{
    public Entity(String tableName) {
        super(tableName);
    }
}
