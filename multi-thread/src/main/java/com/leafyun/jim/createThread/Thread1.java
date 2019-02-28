package com.leafyun.jim.createThread;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 创建线程的四种方式一：继承 Thread 类，重写 run 方法，执行只要 new 出对象，调用对象 .start 方法即可
 * @description: Thread 本身继承 Runnable 接口，重写 Runnable 接口的 run 方法，其中 Thread 的重写 run 方法是通过自己的成员变量 private Runnable target; 调用 target.run()
 * @date: 2018-12-16
 * @time: 21:06
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 打印当前线程
            System.out.println(Thread.currentThread() + ":" + i);

        }
    }
}
