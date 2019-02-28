package com.leafyun.jim.atomicAndCAS;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 两个线程同时操作共享变量，演示线程安全问题
 * @date: 2019-02-17
 * @time: 12:51
 */
public class Test1 extends Thread {
    // 共享变量
    private static int count = 1;

    @Override
    public void run() {
        while (true) {
            Integer count = getCount();
            if (count > 50) {
                break;
            }
            System.out.println(count);
        }
    }

    public Integer getCount() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count++;
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Test1 t2 = new Test1();
        t1.start();
        t2.start();
    }
}
