package com.qmh.service.impl;

import com.qmh.dao.IAccountDao;

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
//        int i = 1;
//        accountDao.saveAccount();
//        System.out.println(i);
//        i++;
    }
}
