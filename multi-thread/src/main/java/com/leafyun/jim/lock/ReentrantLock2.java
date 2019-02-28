package com.leafyun.jim.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 重入锁：同一线程外层函数获得锁之后，内层递归函数仍然有获取该锁的代码，但不受影响。
 * @date: 2019-02-14
 * @time: 9:59
 */
public class ReentrantLock2 implements Runnable {
    // 重入性特征：锁可以传递，好处就是避免死锁(因为不传递，可能锁不会释放)，节省获取锁时间
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    // 事实上，外面 set 方法加了锁之后，只能有一个线程执行，get 就不必再加锁，即便加了锁，也是重入锁
    public void set() {
        try {
            lock.lock();
            System.out.println("set()方法");
            get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println("get()方法");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock2 lock = new ReentrantLock2();
        Thread t1 = new Thread(lock);
        t1.start();
    }
}
