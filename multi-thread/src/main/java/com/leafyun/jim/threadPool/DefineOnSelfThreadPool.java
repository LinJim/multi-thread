package com.leafyun.jim.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 自定义线程池
 * @date: 2019-02-03
 * @time: 17:58
 */
public class DefineOnSelfThreadPool {
    public static void main(String[] args) {
        // 核心线程数：1，表示实际运用的线程数，最大线程数：线程池最大可创建线程数目
        // keepAliveTime ：超出核心线程数的空闲线程的最大存活时间，目的节约内存，回收掉线程。公司一般配置 30 秒，大于核心线程数的时候触发。为 0 的话，表示一空闲就回收
        // BlockingQueue： 阻塞任务队列，存储待执行的任务，3 的容量
        // 拒绝策略：就是最大线程数 + 阻塞队列缓存的数目 2+3 = 5 ，拒绝就报错
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(3));
        // 任务一
        executor.execute(new TaskThread("任务一"));
        // 任务二
        executor.execute(new TaskThread("任务二"));
        // 任务三
        executor.execute(new TaskThread("任务三"));
        // 任务四
        executor.execute(new TaskThread("任务四"));
        // 任务五
        executor.execute(new TaskThread("任务五"));
        // 任务六
        //executor.execute(new TaskThread("任务六"));
    }
}

class TaskThread implements Runnable {
    private String threadName;

    public TaskThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +""+ threadName);
    }
}


