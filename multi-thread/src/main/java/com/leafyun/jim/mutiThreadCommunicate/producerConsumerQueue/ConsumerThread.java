package com.leafyun.jim.mutiThreadCommunicate.producerConsumerQueue;

import com.leafyun.jim.mutiThreadCommunicate.Res;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 消费者线程
 * @date: 2019-01-31
 * @time: 18:12
 */
public class ConsumerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean flag = true;

    public ConsumerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("消费者线程已经启动");
        try {
            while (flag) {
                // 取出数据最多阻塞两秒
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null) {
                    System.out.println("消费者超过两秒时间，没有获取队列信息");
                    flag = false;
                    return;
                }
                System.out.println("消费者取出数据：" + data);

            }
        } catch (InterruptedException e) {

        } finally {
            System.out.println("消费者线程结束");
        }

    }
}
