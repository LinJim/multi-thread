package com.leafyun.jim.future.defineOnSelfFuture;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-04
 * @time: 16:23
 */
public class FutureClient {
    public Data request(String requestData){
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 阻塞
                RealData realData = new RealData("644064");
                futureData.setRealData(realData);
            }
        }).start();
        return futureData;
    }
}
