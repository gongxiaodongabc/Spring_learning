package com.qmh.service.impl;

import com.qmh.dao.IAccountDao;
import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制都在业务层
 */
@Service("accountService")
@Transactional()
//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

//    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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
//        int i=1/0;
        accountDao.updateAccount(target);

    }





}
