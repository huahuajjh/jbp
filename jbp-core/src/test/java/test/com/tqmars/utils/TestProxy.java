package test.com.tqmars.utils;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by jjh on 17-3-23.
 */
public class TestProxy {
    @Test
    public void testProxy(){
//        ICalculator c = new Calculator();
//        c = new CalculatorProxy(c).getLoggingProxy();
//        int r = c.division(1,1);
//        c.add(2,3);
//        System.out.println(r);

        ICalculator i = new Calculator();
        CalcProxy p = new CalcProxy(i);
        p.getProxy().add(1,2);
    }

    @Test
    public void testInterfacesChain(){
        getInterfaces(D.class);
    }

    private void getInterfaces(Class c){
        Class[] tmp = c.getInterfaces();
        if(null == tmp || tmp.length == 0){
            return;
        }

        for (Class p : tmp) {
            System.out.println(p.getName());
            getInterfaces(p);
        }
    }

    private class Calculator implements ICalculator{
        @Override
        public int add(int num1,int num2){
            return num1 + num2;
        }

        @Override
        public int division(int num1, int num2) {
            return num1/num2;
        }
    }

    private interface ICalculator{
        int add(int num1,int num2);
        int division(int num1,int num2);
    }

    private class CalculatorProxy{
        private ICalculator target;

        public CalculatorProxy(ICalculator target) {
            this.target = target;
        }

        public ICalculator getLoggingProxy(){
            ICalculator proxy = null;
            ClassLoader loader = target.getClass().getClassLoader();
            Class[] interfaces = new Class[]{ICalculator.class};

            InvocationHandler h = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String methodName = method.getName();

                    System.out.println("[before method]: "+methodName+" with args: "+ Arrays.asList(args));

                    Object r = null;
                    try {
                        r = method.invoke(target,args);
                    }catch (Exception ex){
                        System.out.println("[exception]"+ ex.getLocalizedMessage());
                    }

                    System.out.println("[after method]:"+methodName+" with result:"+r);
                    return r;
                }
            };
            proxy = (ICalculator) Proxy.newProxyInstance(loader,interfaces,h);
            return proxy;
        }
    }

    private class CalcProxy implements InvocationHandler{
        private ICalculator target;

        public CalcProxy(ICalculator target) {
            this.target = target;
        }

        public ICalculator getProxy(){
            return (ICalculator) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(112);
            return method.invoke(target,args);
        }
    }

    private class D implements A,B{}

    private interface A extends B{}
    private interface B extends C{}
    private interface C{}
}
