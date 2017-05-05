package test.com.tqmars.utils;

import org.junit.Test;

import java.util.*;

/**
 * Created by jjh on 17-3-20.
 */
public class TestStrings {
    @Test
    public void testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("a",12);
        map.put("a",122);
        map.put("b",122);
        map.put(null,"a");

//        map.entrySet().forEach(entry -> System.out.println(entry.getKey()+"="+entry.getValue()));
    }

    @Test
    public void testHashTable(){
        Map<String,Object> map = new Hashtable<>();
        map.put("a",123);
        map.put("a",1213);
//        map.put(null,"a");

        map.entrySet().forEach(a-> System.out.println(a.getKey()+"="+a.getValue()));

    }

    @Test
    public void testList(){
        List<User> list = new ArrayList<>();
        list.add(new User("a"));
        list.add(new User("b"));
        list.add(new User("c"));
        list.add(new User("d"));

        list.removeIf(a->a.getName().equals("a"));

        list.forEach(a-> System.out.println(a.getName()));
    }

    private class User{
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}