package com.leafyun.jim.atomicAndCAS;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 两个线程同时操作共享变量，演示线程安全问题
 * @date: 2019-02-17
 * @time: 12:51
 */
public class Test2 implements Runnable {
    // 线程安全原子类，内部 CAS 机制
    AtomicInteger integer = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            Integer count = getCount();
            if (count > 50) {
                break;
            }
            System.out.println(count);
        }
    }

    public Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 内部没有上锁，
        return integer.incrementAndGet();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        Thread t1=new Thread(test2);
        Thread t2=new Thread(test2);
        t1.start();
        t2.start();
    }
}
