package test.com.tqmars.domain.entities;

import com.tqmars.domain.entities.Entity;
import com.tqmars.domain.entities.EntityOfTPrimaryKey;
import com.tqmars.exception.JbpException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jjh on 17-3-19.
 */
public class TestIEntity {
    @Test
    public void testGetId() {
        MyEntity e = new MyEntity();
        e.setId(1);

        Assert.assertEquals(1 + "", e.getId().toString());
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "jjh");
        map.put("id", "111");

//        map.entrySet().forEach(entry->System.out.println(entry.getKey()+"="+entry.getValue()));
        System.out.println(map.get("id"));
    }

    @Test
    public void testGetTableName() {
        MyEntity e = new MyEntity();
        System.out.println(e.getTableName());
    }

    @Test
    public void testPK() {
        StringPKEntity e = new StringPKEntity();
        Assert.assertEquals("tb_admin", e.getTableName());
        System.out.println(e.getTableName());
    }

    @Test
    public void testProperties() throws NoSuchFieldException, IllegalAccessException {
        User u = new User();
        u.setName("nm");
        Field f = u.getClass().getDeclaredField("name");
        f.setAccessible(true);
        Column c = f.getAnnotation(Column.class);
    }

    @Test
    public void testEntityException() {
        try {
            ExceptionEntity e = new ExceptionEntity();
        } catch (JbpException ex) {
            System.out.println(ex);
        }
    }

    private class T {
        @Column("name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.FIELD})
    public  @interface Column {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Validator{
        String exp();

    }

    @Test
    public void testIn(){
        System.out.println(new Validator1().name);
    }

    private class MyEntity extends Entity {
        public MyEntity() {
            super("tb_user");
        }
    }

    private class StringPKEntity extends EntityOfTPrimaryKey<String> {
        public StringPKEntity() {
            super("tb_admin");
        }
    }

    private class ExceptionEntity extends Entity {
        public ExceptionEntity() {
            super("");
        }
    }

    private class User{
        @Column("tb_admin")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private abstract class IValidatable {
        String name = new String();
        abstract String validate(Object o);
    }

    private class Validator1 extends IValidatable {
        @Override
        public String validate(Object o) {
            name = "aa";
            return name;
        }
    }

    @FunctionalInterface
    private interface Func{
        int add(int num1,int num2);
    }

    @Test
    public void testFunc(){
        Func func = (a,b) -> a+b;
//        System.out.println(func.add(1,2));
    }

    private int add(int num1,int num2){
        return num1 + num2;
    }

}

