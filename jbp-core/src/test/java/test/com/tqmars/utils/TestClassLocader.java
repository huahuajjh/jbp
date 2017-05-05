package test.com.tqmars.utils;

import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by jjh on 17-3-23.
 */
public class TestClassLocader {
    @Test
    public void testLoader() {
    }

    @Test
    public void testReflection() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<TestClassLocader> c = (Class<TestClassLocader>) Class.forName("test.com.tqmars.utils.TestClassLocader");
        TestClassLocader u = c.newInstance();
        System.out.println(u.s());
    }

    @Test
    public void testPkg(){
        getPkg(this.getClass().getClassLoader().getResource("com/tqmars/domain").getFile());

    }

    private void getPkg(String pkgName) {
//        String str = this.getClass().getClassLoader().getResource("com/tqmars/domain").getFile();
        File dir = new File(pkgName);
        File[] list = dir.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                getPkg(f.getAbsolutePath());
            }else {
                System.out.println(f.getName());
            }
        }

    }

    private String s() {
        return "sss";
    }

    private class User {
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

    private class MyClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            return super.findClass(name);
        }
    }
}
