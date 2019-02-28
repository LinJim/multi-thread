package com.leafyun.jim.mutiThreadCommunicate;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 生产者线程
 * @date: 2019-01-31
 * @time: 18:11
 */
public class ProducerThread extends Thread {
    private Res res;

    public ProducerThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        // 不断生产不同对象
        int count = 0;
        while (true) {
            synchronized (res) {
                // wait 和 notify 一定要在 synchronized 里面写，因为用的是对象锁
                // 因为一开始是 false ，所以生产者可生产，这时候是消费者阻塞
                if (res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小明";
                    res.sex = "男";
                }
                count = (count + 1) % 2;
                // 生产完
                res.flag=true;
                res.notify();// 唤醒对象锁池中等待的消费者
            }
        }

    }
}
