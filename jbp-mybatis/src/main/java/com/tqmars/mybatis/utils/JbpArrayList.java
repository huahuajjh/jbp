package com.tqmars.mybatis.utils;

import com.tqmars.domain.entities.IEntity;
import com.tqmars.domain.entities.IEntityOfTPrimaryKey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjh on 5/6/17.
 */
public class JbpArrayList extends ArrayList<JbpHashMap> {
    public <TEntity extends IEntityOfTPrimaryKey> List<TEntity> toEntityList(Class<TEntity> entityClass){
        if(size() == 0){
            return null;
        }

        List<TEntity> list = new ArrayList<TEntity>();

        for (int i = 0; i < size(); i++) {
            JbpHashMap map = get(i);
            list.add(map.toEntity(entityClass));
        }

        return list;

    }
}
