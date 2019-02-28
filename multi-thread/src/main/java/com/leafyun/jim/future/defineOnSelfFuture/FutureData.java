package com.leafyun.jim.future.defineOnSelfFuture;

/**
 * @author: JimLin
 * @email: leafyunjim@gmail.com
 * @description:
 * @date: 2019-02-04
 * @time: 16:12
 */
public class FutureData extends Data {
    // 标记
    private boolean flag = false;
    private RealData realData;


    /**
     * 当有线程需要读取 realData 的时候，程序会被阻塞，等到 realData 被注入才会使用 getReal() 方法。
     */
    public synchronized void setRealData(RealData realData) {
        // 如果已经取到结果，直接返回
        if (flag) {
            return;
        }
        // 如果 flag 为 false，没有取到数据，传递 realData 对象
        this.realData = realData;
        flag = true;
        notify();
    }

    @Override
    public synchronized String getRequest(){
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getRequest();
    }


}
