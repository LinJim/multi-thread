package com.leafyun.jim.mutiThreadCommunicate;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-01-31
 * @time: 18:12
 */
public class ThreadTest {
    public static void main(String[] args) {
        // 如果要阻塞 main 线程，让生产者先开启，可以用 CountDownLatch 计数器同步辅助类，也可以用 join 或者 wait 都可以
        Res res= new Res();
        ProducerThread producer= new ProducerThread(res);
        ConsumerThread consumer = new ConsumerThread(res);
        producer.start();
        consumer.start();
    }
}
