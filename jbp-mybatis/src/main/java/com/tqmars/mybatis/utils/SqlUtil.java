package com.tqmars.mybatis.utils;

import com.tqmars.domain.entities.IEntity;
import com.tqmars.domain.entities.IEntityOfTPrimaryKey;
import com.tqmars.domain.entities.annotations.Column;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Created by jjh on 5/6/17.
 */
public class SqlUtil {
    private final static String SELECT = "SELECT ";
    private final static String UPDATE = "UPDATE ";
    private final static String DELETE = "DELETE ";
    private final static String INSERT = "INSERT INTO ";
    private final static String FROM = " FROM ";
    private final static String AND = " AND ";
    private final static String SET = " SET ";
    private final static String WHERE = " WHERE 0=0"+AND;
    private final static String BETWEEN = " BETWEEN ";
    private final static String LIKE = " LIKE ";
    private final static String VALUES = " VALUES ";
    private final static String LIMIT = " LIMIT ";
    private final static String ORDER_BY = " ORDER BY ";
    private final static String COUNT = " COUNT(1) ";

    private StringBuilder sql = new StringBuilder();

    private SqlUtil(){}

    public static SqlUtil instance(){
        return new SqlUtil();
    }

    public SqlUtil select(String properties){
        sql.append(SELECT+properties);
        return this;
    }

    public SqlUtil from(String table){
        sql.append(FROM+table);
        return this;
    }

    public <TEntity extends IEntityOfTPrimaryKey> SqlUtil update(String table,Map<String, Object> entityPropertiesMap){
        sql.append(UPDATE)
                .append(table)
                .append(SET);

        StringBuffer sb = new StringBuffer();
        entityPropertiesMap.entrySet().forEach(entry->{
            sql.append(entry.getKey())
                    .append("=")
                    .append("'"+entry.getValue()+"'")
                    .append(",");
        });

        sql.deleteCharAt(sql.length()-1);
        return this;
    }

    public <TEntity extends IEntityOfTPrimaryKey> SqlUtil update(TEntity entity){
        sql.append(UPDATE)
                .append(entity.getTableName())
                .append(SET);

        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if(field.isAnnotationPresent(Column.class)){
                String colName = field.getAnnotation(Column.class).name();
                field.setAccessible(true);

                try {
                    sql.append(colName)
                            .append("=")
                            .append("'" + field.get(entity) + "'")
                            .append(",");
                }catch (IllegalAccessException  e){
                    e.printStackTrace();
                }
            }
        }

        sql.deleteCharAt(sql.length()-1);

        return this;
    }

    public <TEntity extends IEntityOfTPrimaryKey> SqlUtil insert(TEntity entity){
        StringBuilder c = new StringBuilder();
        StringBuilder v = new StringBuilder();

        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Column.class)){
                String colName = field.getAnnotation(Column.class).name();

                field.setAccessible(true);

                c.append(colName).append(",");
                try {
                    v.append("'").append(field.get(entity)).append("'").append(",");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }

        c.deleteCharAt(c.length()-1);
        v.deleteCharAt(v.length()-1);

        sql.append(INSERT)
                .append(entity.getTableName())
                .append("(")
                .append(c.toString())
                .append(")")
                .append(VALUES)
                .append("(")
                .append(v.toString())
                .append(")");

        return this;
    }

    public <TEntity extends IEntity> SqlUtil insert(List<TEntity> entityList){
        throw new NotImplementedException();
    }

    public SqlUtil delete(){
        sql.append(DELETE);
        return this;
    }

    public SqlUtil count(String table){
        sql.append(SELECT).append(COUNT).append(FROM).append(table);
        return this;
    }

    public SqlUtil where(String where){
        sql.append(WHERE+where);
        return this;
    }

    public SqlUtil where(){
        sql.append(WHERE);
        return this;
    }

    public SqlUtil and(){
        sql.append(AND);
        return this;
    }

    public SqlUtil gt(String property,Object value){
        compareStruct(property, value, ">");
        return this;
    }

    public SqlUtil lt(String property,Object value){
        compareStruct(property, value, "<");
        return this;
    }

    public SqlUtil eq(String property,Object value){
        compareStruct(property, value, "=");
        return this;
    }

    public SqlUtil gte(String property,Object value){
        compareStruct(property, value, ">=");
        return this;
    }

    public SqlUtil lte(String property,Object value){
        compareStruct(property, value, "<=");
        return this;
    }

    public SqlUtil between(String property,Object smallValue,Object greatValue){
        sql.append(property)
                .append(BETWEEN)
                .append("'")
                .append(smallValue)
                .append("'")
                .append(AND)
                .append("'")
                .append(greatValue)
                .append("'");
        return this;
    }

    public SqlUtil like(String property,String fuzzyValue){
        sql.append(property)
                .append(LIKE)
                .append("'%")
                .append(fuzzyValue)
                .append("%'");

        return this;
    }

    public SqlUtil limit(int begin,int end){
        sql.append(LIMIT).append(begin).append(",").append(end);
        return this;
    }

    public SqlUtil desc(String by){
        sql.append(ORDER_BY).append(by).append(" DESC");
        return this;
    }

    public SqlUtil asc(String by){
        sql.append(ORDER_BY).append(by).append(" ASC");
        return this;
    }

    public SqlUtil page(int pageIndex,int pageSize){
        sql.append(LIMIT).append((pageIndex - 1) * pageSize).append(",").append(pageSize);
        return this;
    }

    private void compareStruct(String property,Object value,String c){
        sql.append("'")
                .append(property)
                .append("'")
                .append(c)
                .append("'")
                .append(value)
                .append("'");
    }

    @Override
    public String toString() {
        return sql.toString().replace("WHERE 0=0 AND","WHERE");
    }
}
