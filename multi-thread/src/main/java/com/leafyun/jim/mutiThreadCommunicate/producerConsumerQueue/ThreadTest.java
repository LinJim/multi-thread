package com.leafyun.jim.mutiThreadCommunicate.producerConsumerQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-31
 * @time: 18:12
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(10);
        ProducerThread producer = new ProducerThread(blockingQueue);
        ConsumerThread consumer = new ConsumerThread(blockingQueue);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();
        // 阻塞主线程，休眠 20 秒之后，运行 stop 方法
        Thread.sleep(1000 * 20);
        producer.stop();
    }
}
