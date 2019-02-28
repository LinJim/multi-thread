package com.leafyun.jim.volatileTest;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-30
 * @time: 14:26
 */
public class ThreadDemo extends Thread {
    public volatile boolean flag = true;

    @Override
    public void run() {
        System.out.println("线程开始");
        while (flag) {

        }
        System.out.println("线程结束");
    }
    public void setRunning(boolean flag) {
        this.flag = flag;
    }

}
