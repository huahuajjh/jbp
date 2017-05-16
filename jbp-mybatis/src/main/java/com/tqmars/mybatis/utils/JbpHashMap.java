package com.tqmars.mybatis.utils;

import com.tqmars.domain.entities.IEntity;
import com.tqmars.domain.entities.IEntityOfTPrimaryKey;
import com.tqmars.domain.entities.annotations.Column;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jjh on 5/6/17.
 */
public class JbpHashMap extends HashMap<String,Object> {
    public <TEntity extends IEntityOfTPrimaryKey> TEntity toEntity(Class<TEntity> entityClass){
        TEntity entity = instance(entityClass);

        if(entrySet().isEmpty()){
            return null;
        }

        Field[] fields = entityClass.getDeclaredFields();

        for (Map.Entry<String,Object> entry : entrySet()) {
            for (Field field : fields) {
                //go on when field's annotation is Column.class
                if(field.isAnnotationPresent(Column.class)){
                    //set this field can access
                    field.setAccessible(true);

                    String colName = field.getAnnotation(Column.class).name();

                    if(colName.equals(entry.getKey())){
                        try {
                            field.set(entity,entry.getValue());
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        entity.setId(super.get("id"));

        return entity;
    }

    private <TEntity> TEntity instance(Class<TEntity> entityClass){
        try {
            TEntity entity = entityClass.newInstance();
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("new TEntity instance failed");
        }
    }
}
