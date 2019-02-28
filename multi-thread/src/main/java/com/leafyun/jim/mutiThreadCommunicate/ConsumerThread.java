package com.leafyun.jim.mutiThreadCommunicate;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 消费者线程
 * @date: 2019-01-31
 * @time: 18:12
 */
public class ConsumerThread extends Thread {
    private Res res;

    public ConsumerThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                // 一开始消费者阻塞
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.name + "" + res.sex);
                // 打印完
                res.flag = false;
                res.notify();// 唤醒对象锁池中等待的生产者
            }
        }

    }
}
