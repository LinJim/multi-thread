package com.leafyun.jim.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 线程创建测试
 * @date: 2018-12-16
 * @time: 21:32
 */
public class ThreadTest {
    public static void main(String[] args){
//        // Callable 返回结果并且可能抛出异常的任务。
//        Callable<Object> callable1 = new Thread3();
//        Callable<Object> callable2 = new Thread3();
//        // FutureTask 可取消的异步计算。利用开始和取消计算的方法、查询计算是否完成的方法和获取计算结果的方法，此类提供了对 Future 的基本实现。仅在计算完成时才能获取结果；如果计算尚未完成，则阻塞 get 方法。一旦计算完成，就不能再重新开始或取消计算。
//        FutureTask<Object> futureTask1 = new FutureTask<Object>(callable1);
//        FutureTask<Object> futureTask2 = new FutureTask<Object>(callable2);
//
//        Thread mThread = new Thread(futureTask1,"线程1");
//        Thread mThread2 = new Thread(futureTask2,"线程2");
//        mThread.start();
//        mThread2.start();
//        try {
//            System.out.println(futureTask1.get());
//            System.out.println(futureTask2.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        Thread1 thread1 =new Thread1();
////        Thread1 thread2 =new Thread1();
////        try {
////            thread2.join();
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        thread1.start();
////        thread2.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("xxx");
            }
        }).start();


    }
}
