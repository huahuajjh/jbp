package test.com.tqmars.module;

import com.tqmars.module.JbpModule;
import com.tqmars.module.annotation.DependsOn;

/**
 * Created by jjh on 17-3-24.
 */

@DependsOn(C.class)
public class B extends JbpModule{
    public void hi(){
        System.out.println("hello");
    }
}
