package com.leafyun.jim.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-02
 * @time: 10:29
 */
public class TestThreadPool {
    public static void main(String[] args) {
//        ExecutorService pool = Executors.newCachedThreadPool();
//        for (int i = 0; i < 100; i++) {
//            final int temp = i;
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    // 内部类 i 是收不到值的，所以修饰成 final ,或者直接用临时变量 int temp = i;
//                    System.out.println("线程名字： " + Thread.currentThread().getName() + " ;执行值：" + temp);
//                }
//            });
//        }
//        pool.shutdown();

        // ExecutorService pool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int temp = i;
//            // execute 方法表示启动线程
//            pool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    // 内部类 i 是收不到值的，所以修饰成 final ,或者直接用临时变量 int temp = i;
//                    System.out.println("线程名字： " + Thread.currentThread().getName() + " ;执行值：" + temp);
//                }
//            });
//        }
//        pool.shutdown();

//        ExecutorService pool = Executors.newScheduledThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            final int temp = i;
//            ((ScheduledExecutorService) pool).schedule(new Runnable() {
//                @Override
//                public void run() {
//                    // 内部类 i 是收不到值的，所以修饰成 final ,或者直接用临时变量 int temp = i;
//                    System.out.println("线程名字： " + Thread.currentThread().getName() + " ;执行值：" + temp);
//                }
//            }, 3, TimeUnit.SECONDS);
//        }
//        pool.shutdown();


        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            // execute 方法表示启动线程
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    // 内部类 i 是收不到值的，所以修饰成 final ,或者直接用临时变量 int temp = i;
                    System.out.println("线程名字： " + Thread.currentThread().getName() + " ;执行值：" + temp);
                }
            });
        }
        pool.shutdown();
    }
}
