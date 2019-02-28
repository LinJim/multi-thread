package com.leafyun.jim.future.defineOnSelfFuture;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description: 获取真实数据
 * @date: 2019-02-04
 * @time: 16:16
 */
public class RealData extends Data {

    private String requestResult;

    /**
     * 构造函数
     */
    public RealData(String requestData) {
        System.out.println("正在使用 data 进行网络请求，data：" + requestData + " .开始");
        try {
            // 业务操作耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("操作完毕.....获取到结果");
        // 获得返回结果
        this.requestResult="结果成功 哈哈";
    }

    @Override
    public String getRequest() {
        return requestResult;
    }
}
