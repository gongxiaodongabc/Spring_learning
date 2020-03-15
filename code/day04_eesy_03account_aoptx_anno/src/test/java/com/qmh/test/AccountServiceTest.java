package com.qmh.test;

import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public void testTransfer(){

       as.transfer("aaa","bbb",100f);
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }

}
