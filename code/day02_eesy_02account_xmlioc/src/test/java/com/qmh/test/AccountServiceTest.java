package com.qmh.test;

import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用Junit单元测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用spring提供的main方法
@ContextConfiguration(locations = "classpath:bean.xml") // 告知spring的ioc创建是基于xml的还是基于注解的
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accounts = as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        Account account = as.findAccountById(1);
        System.out.println(account);

    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("test");
        account.setMoney(12345f);
        as.saveAccount(account);

    }

    @Test
    public void testUpdate(){
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(4);

    }


}
