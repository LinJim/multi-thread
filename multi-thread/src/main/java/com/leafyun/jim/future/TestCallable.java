package com.leafyun.jim.future;

import java.util.concurrent.*;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-04
 * @time: 9:17
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<String> submit = threadPool.submit(new CallableTest());
        System.out.println("1. 主线程开始");
//        String result = submit.get();
//        System.out.println("2. 主线程执行中");
//        System.out.println("3. result: " + result);
        // 如果为了不影响主线程，就注释掉代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String result = submit.get();
                    System.out.println("3. result: " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("6. 主线程结束");
    }
}


class CallableTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("4. 正在执行任务:需要 5 秒，执行任务开启");
        Thread.sleep(5000);
        System.out.println("5. 正在执行任务:需要 5 秒，执行任务结束");
        return "执行成功";
    }
}