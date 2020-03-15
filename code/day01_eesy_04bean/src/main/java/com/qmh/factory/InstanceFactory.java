package com.qmh.factory;

import com.qmh.service.IAccountService;
import com.qmh.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类，（该类是可能存在于jar包中的，无法通过修改源码的方式来通过默认构造函数
 *
 * */
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
