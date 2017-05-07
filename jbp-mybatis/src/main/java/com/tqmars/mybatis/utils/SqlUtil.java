package com.tqmars.mybatis.utils;

import com.tqmars.domain.entities.IEntity;

/**
 * Created by jjh on 5/6/17.
 */
public class SqlUtil {
    private final static String SELECT = "SELECT ";
    private final static String UPDATE = "UPDATE ";
    private final static String DELETE = "DELETE ";
    private final static String INSERT = "INSERT ";
    private final static String FROM = " FROM ";
    private final static String AND = " AND ";
    private final static String SET = " SET ";
    private final static String WHERE = " WHERE 0=0 "+AND;
    private String table = "";

    private final static SqlUtil INSTANCE = new SqlUtil();
    private StringBuilder sql = new StringBuilder();

    private SqlUtil(){}

    public static SqlUtil instance(String table){
        INSTANCE.table = table;
        return INSTANCE;
    }

    public String getSql() {
        return sql.toString();
    }

    public SqlUtil select(String properties){
        sql.append(SELECT+properties);
        return this;
    }

    public SqlUtil from(){
        sql.append(FROM+table);
        return this;
    }

    public <TEntity extends IEntity> SqlUtil update(TEntity entity){
        sql.append(UPDATE+table);
        return this;
    }

    public <TEntity extends IEntity> SqlUtil insert(TEntity entity){
        sql.append(INSERT);
        return this;
    }

    public SqlUtil delete(){
        sql.append(DELETE);
        return this;
    }

    public SqlUtil where(String where){
        sql.append(WHERE+where);
        return this;
    }

    public SqlUtil and(){
        sql.append(AND);
        return this;
    }

}
