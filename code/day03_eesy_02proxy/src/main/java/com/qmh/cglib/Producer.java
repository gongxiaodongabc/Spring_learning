package com.qmh.cglib;

import com.qmh.proxy.IProducer;

/**
 * 生产者
 */
public class Producer {
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
