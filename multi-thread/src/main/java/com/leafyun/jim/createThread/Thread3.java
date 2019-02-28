package com.leafyun.jim.createThread;

import java.util.concurrent.Callable;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:  创建线程的四种方式三：实现 Callable() 接口，重写 call 方法，方法有返回值。
 * @date: 2018-12-16
 * @time: 21:43
 */
public class Thread3 implements Callable<Object> {
    private int count = 20;

    @Override
    public Object call() throws Exception {
        for (int i = count; i > 0; i--) {
            // 暂停当前正在执行的线程对象，并执行其他线程。
            //Thread.yield();
            System.out.println(Thread.currentThread().getName()+"当前票数：" + i);
        }
        return "sale out";
    }
}
