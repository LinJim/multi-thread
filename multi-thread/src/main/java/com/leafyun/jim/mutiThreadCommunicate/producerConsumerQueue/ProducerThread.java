package com.leafyun.jim.mutiThreadCommunicate.producerConsumerQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 生产者线程
 * @date: 2019-01-31
 * @time: 18:11
 */
public class ProducerThread implements Runnable {
    private BlockingQueue<String> blockingQueue;
    private volatile boolean flag = true;
    AtomicInteger integer = new AtomicInteger();

    public ProducerThread(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void stop() {
        this.flag = false;
    }

    @Override
    public void run() {
        System.out.println("生产者线程已经启动");
        try {
            while (flag) {
                String data = integer.incrementAndGet() + "";
                // 添加队列，最多阻塞两秒
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println("生产者存入队列成功：" + data);
                } else {
                    System.out.println("生产者存入队列失败：" + data);
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.println("生产者线程结束");
        }

    }
}
