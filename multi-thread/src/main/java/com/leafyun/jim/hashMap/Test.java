package com.leafyun.jim.hashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-18
 * @time: 20:10
 */
public class Test extends Thread {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2);
    static AtomicInteger at = new AtomicInteger();

    public void run() {
        while (at.get() < 10000000) {
            map.put(at.get(), at.get());
            at.incrementAndGet();
        }
    }

    public static void main(String[] args)
    {
        Test t0 = new Test();
        Test t1 = new Test();
        Test t2 = new Test();
        Test t3 = new Test();
        Test t4 = new Test();
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}