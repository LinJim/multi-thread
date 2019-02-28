package com.leafyun.jim.multiThreadSimulate;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-30
 * @time: 14:26
 */
public class ThreadDemo implements Runnable {
    // 多个窗口共享票
    private int count = 10;

    private Object obj = new Object();

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sale();
        }

    }

    //    private synchronized void sale() {
////        synchronized(obj){
////            if (count > 0) {
////                System.out.println(Thread.currentThread().getName() + " 出售第" + (10 - count + 1) + "张票");
////                count--;
////            }
////        }
//
//        if (count > 0) {
//            System.out.println(Thread.currentThread().getName() + " 出售第" + (10 - count + 1) + "张票");
//            count--;
//        }
//    }
    private void sale() {
        synchronized (this) {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + " 出售第" + (10 - count + 1) + "张票");
                count--;
            }
        }

    }
}
