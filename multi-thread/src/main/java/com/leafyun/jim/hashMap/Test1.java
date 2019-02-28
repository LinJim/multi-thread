package com.leafyun.jim.hashMap;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-18
 * @time: 18:36
 */
public class Test1 {
    private static final HashMap<String, String> map = new HashMap<String, String>(2);
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "moon" + i).start();
                }
            }
        }, "ftf");
        t.start();
        try {
            // 插队占用 main 线程
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
