package com.leafyun.jim.future.defineOnSelfFuture;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-04
 * @time: 16:23
 */
public class Main {
    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("644064799");
        System.out.println("主线程数据发送成功");
        System.out.println("主线程执行其他任务");
        String result = request.getRequest();
        System.out.println("主线程获取 result ："+result);
    }
}
