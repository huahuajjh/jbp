package test.com.tqmars.module;

import com.tqmars.module.JbpModule;
import org.junit.ClassRule;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by jjh on 17-3-24.
 */
public class TestModule extends JbpModule{
    @Test
    public void testIsJbpMddule(){
        System.out.println(JbpModule.isJbpModule(this.getClass()));
    }

    @Test
    public void testDepends(){
//        System.out.println(this.getClass().isAnnotationPresent(DependsOn.class));
//        JbpModule.findDependedModuleTypes(A.class).forEach(c -> System.out.println(c.getName()));
        JbpModule.findDependedModuleTypesRecursively(A.class).forEach(c ->
                {
                    try {
                        Class c1 = Class.forName(c.getName());
                        c1.getMethod("hi").invoke(c.newInstance());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

}
