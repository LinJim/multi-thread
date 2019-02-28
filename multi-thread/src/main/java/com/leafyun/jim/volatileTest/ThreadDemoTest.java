package com.leafyun.jim.volatileTest;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-30
 * @time: 21:34
 */
public class ThreadDemoTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo demo= new ThreadDemo();
        demo.start();
        Thread.sleep(3000);
        demo.setRunning(false);
        System.out.println("flag 修改为 false");
        Thread.sleep(1000);
        System.out.println(demo.flag);
    }
}
