package com.leafyun.jim.createThread;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-28
 * @time: 23:16
 */
public class Thread1Test {
    public static void main(String[] args) {
        System.out.println("主线程开始");
        Thread1 thread1 = new Thread1();
        thread1.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("main:i" + i);
        }
        System.out.println("主线程结束");
    }
}
