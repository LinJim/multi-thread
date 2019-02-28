package com.leafyun.jim.createThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: Executor 可以创建三种类型的普通线程池：1. 固定大小的线程池(.newFixedThreadPool(n)) 2. 单线程池 3. 缓存线程池
 * @date: 2018-12-16
 * @time: 22:35
 */
public class ExecutorCreateThreadPool {
    public static void main(String[] args) {
        // 创建只有两个线程的线程池
        // ExecutorService ex = Executors.newFixedThreadPool(2);

        // 创建单线程池
        // ExecutorService ex=Executors.newSingleThreadExecutor();

        // 创建缓存线程池
        ExecutorService ex = Executors.newCachedThreadPool();

        // 创建定长线程池，支持定时和周期性任务执行
//        ExecutorService ex = Executors.newScheduledThreadPool(2);

        for (int i = 0; i < 5; i++) {
            //  提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        System.out.println("线程名字： " + Thread.currentThread().getName() + " ;执行值：" + j);
                    }
                }
            });
        }
        //  启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
        ex.shutdown();
    }
}
