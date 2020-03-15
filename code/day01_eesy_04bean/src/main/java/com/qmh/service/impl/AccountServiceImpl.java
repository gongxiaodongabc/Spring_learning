package com.qmh.service.impl;

import com.qmh.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;

/**
 * 账户的业务层实现类
 * */
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("对象创建");
    }
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }
    public void init(){
        System.out.println("对象初始化了");
    }

    public void destory(){
        System.out.println("对象销毁了");
    }
}
