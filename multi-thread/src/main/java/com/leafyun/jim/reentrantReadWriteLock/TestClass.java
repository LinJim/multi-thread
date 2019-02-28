package com.leafyun.jim.reentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 读写锁，jvm 内置缓存
 * @date: 2019-02-17
 * @time: 11:37
 */
public class TestClass {
    private Map<String, String> cache = new HashMap<>();
    // 创建读写锁
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    // 获取读锁
    private ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
    // 获取写锁
    private ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

    public synchronized void put(String key, String value) {
        System.out.println("put 方法：key " + key + " value " + value + "开始");
        try {
            writeLock.lock();
            Thread.sleep(50);
            cache.put(key, value);
            System.out.println("put 方法：key " + key + " value " + value + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public synchronized String get(String key) {
        try {
            readLock.lock();
            System.out.println("读取 key " + key + "开始");
            Thread.sleep(50);
            String value = cache.get(key);
            System.out.println("读取 key " + key + "结束");
            return value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        // 写线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    testClass.put(i + "", i + "");
                }
            }
        });
        // 读线程
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    testClass.get(i + "");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
