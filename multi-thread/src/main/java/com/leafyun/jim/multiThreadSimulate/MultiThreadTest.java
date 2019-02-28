package com.leafyun.jim.multiThreadSimulate;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-30
 * @time: 14:30
 */
public class MultiThreadTest {
    public static void main(String[] args) {
//        ThreadDemo demo = new ThreadDemo();
//        ThreadDemo demo2 = new ThreadDemo();
//        Thread t1 = new Thread(demo,"窗口1");
//        Thread t2 = new Thread(demo2,"窗口2");
//        t1.start();
//        t2.start();

        ThreadDemo demo = new ThreadDemo();
        Thread t1 = new Thread(demo, "窗口1");
        Thread t2 = new Thread(demo, "窗口2");
        t1.start();
        t2.start();
    }
}
