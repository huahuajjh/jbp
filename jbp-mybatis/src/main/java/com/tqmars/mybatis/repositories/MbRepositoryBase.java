package com.tqmars.mybatis.repositories;

import com.tqmars.domain.entities.IEntityOfTPrimaryKey;
import com.tqmars.domain.entities.annotations.Table;
import com.tqmars.domain.repositories.JbpRepositoryBase;
import com.tqmars.exception.JbpException;
import com.tqmars.mybatis.ISessionProvider;
import com.tqmars.mybatis.utils.JbpArrayList;
import com.tqmars.mybatis.utils.JbpHashMap;
import com.tqmars.mybatis.utils.SqlUtil;
import org.apache.ibatis.session.SqlSession;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jjh on 17-5-4.
 */
public class MbRepositoryBase<TEntity extends IEntityOfTPrimaryKey<TPrimaryKey>,TPrimaryKey> extends JbpRepositoryBase<TEntity,TPrimaryKey>
{
    private Class<TEntity> entityClass;

    private final static String SQL = "sql";

    private SqlSession session;

    private ISessionProvider sessionProvider;

    public MbRepositoryBase(ISessionProvider _sessionProvider){
        sessionProvider = _sessionProvider;
        session = sessionProvider.getSession();
    }

    private String getTableName(){
        return entityClass.getAnnotation(Table.class).name();
    }

    @Override
    public TEntity get(TPrimaryKey id) {
        return get(id,"*");
    }

    @Override
    public TEntity get(TPrimaryKey id, String properties) {
        String sql = SqlUtil.instance().select(properties).from(getTableName()).where().eq("id",id).toString();
        JbpHashMap map = session.selectOne(SQL,sql);
        return map.toEntity(entityClass);
    }

    @Override
    public TEntity getOne(String where) {
        return getOne(where,"*");
    }

    @Override
    public TEntity getOne(String where, String properties) {
        String sql = SqlUtil.instance().select(properties).from(getTableName()).where(where).limit(0,1).toString();
        JbpHashMap map = session.selectOne(SQL,sql);
        return map.toEntity(entityClass);
    }

    @Override
    public List<TEntity> getAll() {
        String sql = SqlUtil.instance().select("*").from(getTableName()).toString();
        return null;
    }

    @Override
    public List<TEntity> getAll(String properties) {
        return getAllWithCondition("0=0");
    }

    @Override
    public List<TEntity> getAllWithCondition(String where) {
        return getAllWithCondition(where,"*");
    }

    @Override
    public List<TEntity> getAllWithCondition(String where,String properties) {
        return getAllWithConditionByPage(where,1,10000,properties);
    }

    @Override
    public List<TEntity> getAllWithConditionByPage(String where, int pageIndex, int pageSize) {
        return getAllWithConditionByPage(where,pageIndex, pageSize,"*");
    }

    @Override
    public List<TEntity> getAllWithConditionByPage(String where, int pageIndex, int pageSize, String properties) {
        String sql = SqlUtil.instance().select(properties).from(getTableName()).where(where).page(pageIndex, pageSize).toString();
        List<JbpHashMap> list = session.selectList(SQL,sql);
        JbpArrayList s = (JbpArrayList) list;
        return s.toEntityList(entityClass);
    }

    @Override
    public TEntity updateAndGetEntity(TEntity entity) {
        update(entity);
        return entity;
    }

    @Override
    public void update(TEntity entity) {
        String sql = SqlUtil.instance().update(entity).where().eq("id",entity.getId()).toString();
        session.update(SQL,sql);
    }

    @Override
    public void updateSpecifyProperties(TPrimaryKey id, Map<String, Object> entityPropertiesMap) {
        String sql = SqlUtil.instance().update(getTableName(),entityPropertiesMap).toString();
        session.update(SQL,sql);
    }

    @Override
    public void updateSpecifyProperties(TPrimaryKey id, String[] properties, Object[] values) {
        Map<String,Object> map = new HashMap<>();
        for (int i = 0; i < properties.length; i++) {
            map.put(properties[i],values[i]);
        }

        updateSpecifyProperties(id,map);
    }

    @Override
    public TEntity add(TEntity entity) {
        TPrimaryKey id = addAndGetId(entity);
        entity.setId(id);
        return entity;
    }

    @Override
    public TPrimaryKey addAndGetId(TEntity entity) {
        String sql = SqlUtil.instance().insert(entity).toString();
        Map<String,Object> map = new HashMap<>();
        map.put("id",0);
        map.put("value",sql);
        session.insert(SQL,map);
        return (TPrimaryKey) map.get("id");
    }

    @Override
    public void addList(List<TEntity> entityList) {
        throw new NotImplementedException();
    }

    @Override
    public void remove(TEntity entity) {
        remove(entity.getId());
    }

    @Override
    public void remove(TPrimaryKey id) {
        removeWithCondition(SqlUtil.instance().where().eq("id",id).toString());
    }

    @Override
    public void removeWithCondition(String where) {
        String sql = SqlUtil.instance().delete().from(getTableName()).where(where).toString();
        session.delete(SQL,sql);
    }

    @Override
    public int count() {
        return count("0=0");
    }

    @Override
    public int count(String where) {
        String sql = SqlUtil.instance().count(getTableName()).where(where).toString();
        int c = session.selectOne(SQL,sql);
        return c;
    }

    @Override
    public boolean exists(String where) {
        if(count(where) > 0){
            return true;
        }

        return false;
    }

    @Override
    public void setEntityClass(Class<TEntity> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public Class<TEntity> getEntityClass() {
        if(null == entityClass){
            throw new JbpException("not set entity class");
        }

        return entityClass;
    }
}
