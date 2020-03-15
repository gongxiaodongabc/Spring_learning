package com.qmh.proxy;

/**
 * 生产者
 */
public class Producer implements IProducer{
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money){
        System.out.println("销售产品，拿到钱"+money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(float money){
        System.out.println("提供售后服务并拿到钱"+money);
    }
}