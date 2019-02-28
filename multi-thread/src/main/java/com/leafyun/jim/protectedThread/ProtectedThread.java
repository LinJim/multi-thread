package com.leafyun.jim.protectedThread;

import com.leafyun.jim.createThread.Thread1;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 测试守护线程是不是和主线程一起销毁
 * @date: 2019-01-30
 * @time: 0:14
 */
public class ProtectedThread {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程:i" + i);
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main:i" + i);
        }
        System.out.println("主线程结束");
    }

}

