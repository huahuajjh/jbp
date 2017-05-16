package com.tqmars.jbpmybatis;

import com.tqmars.domain.entities.Entity;
import com.tqmars.domain.entities.annotations.Column;
import com.tqmars.domain.entities.annotations.Table;
import com.tqmars.mybatis.utils.JbpHashMap;
import com.tqmars.mybatis.utils.SqlUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by jjh on 5/7/17.
 */
public class TestSqlUtil {
    @Test
    public void testSqlUtil(){
//        System.out.println(SqlUtil.instance("tb_user").select("*").from().where("id=12").and().gt("age",12).and().eq("name","michael jackson").getSql());
//        System.out.println(SqlUtil.instance("tb_user").select("name").from().where().between("age",10,20).getSql());
//        System.out.println(SqlUtil.instance().select("*").from("tb_user").where().between("age",1,20));
        User u = new User();
        u.age = 11;
        u.name = "zs";
        u.setId(1);

        System.out.println(SqlUtil.instance().update(u).where().eq("id","1"));
    }

    @Test
    public void testJbpHashMap(){
        JbpHashMap map = new JbpHashMap();
        map.put("name","zs");
        map.put("age",21);
        map.put("id",11);

        System.out.println(map.toEntity(User.class));
    }

    @Test
    public void testUpdateSpecifyProperties(){
        Map<String,Object> map = new JbpHashMap();
        map.put("name","zs");
        map.put("age","1");
        System.out.println(SqlUtil.instance().select("name,age,gender").from("tb_user").where().gt("age",20).and().eq("name","zs"));
        System.out.println(SqlUtil.instance().update("tb_user",map).where().eq("id",1));
    }

    @Test
    public void testInsert(){
        User u = new User();
        u.age = 11;
        u.name = "zs";
        u.setId(1);

        System.out.println(SqlUtil.instance().insert(u));
    }

    @Test
    public void testWhere(){
//        System.out.println(SqlUtil.instance().gt("name","zs").and().eq("age",12));
        System.out.println(SqlUtil.instance().select("*").from("tb_user").where("a>1"));
    }

    @Test
    public void testVariableVa(){
        s(1,"a","1");
    }

    @Test
    public void testDesc(){
        System.out.println(SqlUtil.instance().select("name").from("tb_user").where().eq("name","zs").and().lt("age",30).and().between("date","2016-01-01","2016-02-02").desc("name"));
    }

    @Test
    public void testAsc(){
        System.out.println(SqlUtil.instance().asc("name"));
    }

    @Test
    public void testCount(){
        System.out.println(SqlUtil.instance().count("tb_user"));
    }

    @Test
    public void testLimit(){
        System.out.println(SqlUtil.instance().limit(1,20));
    }

    @Test
    public void testPage(){
        System.out.println(SqlUtil.instance().page(5,5));
    }

    private void s(int id ,String... str){
        System.out.println(Arrays.deepToString(str));
    }

    @Table(name = "tb_user")
    public static class User extends Entity{
        public User() {
            super("tb_user");
        }

        @Column(name = "name")
        private String name;

        @Column(name = "age")
        private int age;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }

}
