package com.leafyun.jim.createThread;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 创建线程的四种方式二：实现 Runnable() 接口，重写 run 方法，.覆写 Runnable 接口实现多线程可以避免单继承局限，而且 Thread2 子类可以实现业务，然后交给线程类来负责资源调度
 * @date: 2018-12-16
 * @time: 21:22
 */
public class Thread2 implements Runnable {
    public static int count = 20;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-当前剩余票数:" + count--);
        }
    }
}
