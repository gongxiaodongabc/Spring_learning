package com.qmh.service.impl;

import com.qmh.dao.IAccountDao;
import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import com.qmh.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制都在业务层
 */
public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;
    private TransactionManager txManager;

    // 通过spring来注入
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {

        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);

    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);

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
//        int i=1/0;
        accountDao.updateAccount(target);

    }





}
