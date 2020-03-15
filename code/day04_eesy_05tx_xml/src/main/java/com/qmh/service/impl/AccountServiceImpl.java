package com.qmh.service.impl;

import com.qmh.dao.IAccountDao;
import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import org.springframework.transaction.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制都在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }


    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer...");
        // 查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        // 扣钱
        source.setMoney(source.getMoney()-money);
        // 加钱
        target.setMoney(target.getMoney()+money);
        // 更新账户
        accountDao.updateAccount(source);
        int i=1/0;
        accountDao.updateAccount(target);

    }





}
