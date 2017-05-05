package test.com.tqmars.utils;

import org.junit.Test;

/**
 * Created by jjh on 17-3-23.
 */
public class TestThreadLocal implements Runnable{
    ThreadLocal<Integer> local = new ThreadLocal<>();

    @Test
    public void testThreadLocal() throws InterruptedException {

        local.set(1);

        Thread th1 = new Thread(this);
        th1.start();
        System.out.println(local.get());
        Thread.sleep(1000);
        local.set(2);
        Thread th2 = new Thread(this);
        th2.start();
    }

    @Override
    public void run() {
        System.out.println(local.get());
    }
}
