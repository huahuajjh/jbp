package com.tqmars.mybatis.repositories;

import com.tqmars.domain.entities.IEntityOfTPrimaryKey;
import com.tqmars.domain.repositories.JbpRepositoryBase;
import com.tqmars.mybatis.ISessionProvider;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * Created by jjh on 17-5-4.
 */
public class MbRepositoryBase<TEntity extends IEntityOfTPrimaryKey<TPrimaryKey>,TPrimaryKey> extends JbpRepositoryBase<TEntity,TPrimaryKey>
{
    public SqlSession session;

    private ISessionProvider sessionProvider;

    public MbRepositoryBase(ISessionProvider _sessionProvider){
        sessionProvider = _sessionProvider;
        session = sessionProvider.getSession();
    }

    @Override
    public TEntity get(TPrimaryKey id) {
        return null;
    }

    @Override
    public TEntity get(TPrimaryKey id, String... properties) {
        return null;
    }

    @Override
    public TEntity getOne(String where) {
        return null;
    }

    @Override
    public TEntity getOne(String where, String... properties) {
        return null;
    }

    @Override
    public List<TEntity> getAll() {
        return null;
    }

    @Override
    public List<TEntity> getAll(String... properties) {
        return null;
    }

    @Override
    public List<TEntity> getAllWithCondition(String where) {
        return null;
    }

    @Override
    public List<TEntity> getAllWithCondition(String... properties) {
        return null;
    }

    @Override
    public List<TEntity> getAllWithConditionByPage(String where, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public List<TEntity> getAllWithConditionByPage(String where, int pageIndex, int pageSize, String... properties) {
        return null;
    }

    @Override
    public TEntity updateAndGetEntity(TEntity entity) {
        return null;
    }

    @Override
    public void update(TEntity entity) {

    }

    @Override
    public void updateSpecifyProperties(TPrimaryKey id, Map<String, Object> entityPropertiesMap) {

    }

    @Override
    public void updateSpecifyProperties(TPrimaryKey id, String[] properties, Object[] values) {

    }

    @Override
    public TEntity add(TEntity entity) {
        return null;
    }

    @Override
    public TPrimaryKey addAndGetId(TEntity entity) {
        return null;
    }

    @Override
    public void addList(List<TEntity> entityList) {

    }

    @Override
    public void remove(TEntity entity) {

    }

    @Override
    public void remove(TPrimaryKey id) {

    }

    @Override
    public void removeWithCondition(String where) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int count(String where) {
        return 0;
    }

    @Override
    public boolean exists(String where) {
        return false;
    }
}
