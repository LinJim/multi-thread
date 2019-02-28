package com.leafyun.jim.lock;


/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 重入锁：同一线程外层函数获得锁之后，内层递归函数仍然有获取该锁的代码，但不受影响。
 * @date: 2019-02-14
 * @time: 9:59
 */
public class ReentrantLock implements Runnable{

    @Override
    public void run() {
        set();
    }

    // synchronized 是可以重入锁的，就是线程进入方法之后，锁由 set 方法传入 get()方法
    // 假如 synchronized 没有重入性，（他们都是 this 锁），可能发生死锁，线程 1 进入 set 获取一把锁，线程 2 进入 get 获取一把锁
    // 这时候线程 1 又想获取线程 2 的锁
    public synchronized void set(){
        System.out.println("set()方法");
        get();
    }

    public synchronized void get(){
        System.out.println("get()方法");
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(lock);
        t1.start();
    }
}
