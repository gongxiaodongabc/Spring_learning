package com.qmh.ui;

import com.qmh.dao.IAccountDao;
import com.qmh.service.IAccountService;
import com.qmh.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.beans.XMLDecoder;

/**
 * 模拟表现层 用于调用业务层
 * */
public class Client {
    /**
     * 获取Spring框架的IOC核心容器，并根据id获取对象
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\qmh\\IdeaProjects\\spring_demo\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountService as1 = (IAccountService) ac.getBean("accountService");
//        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(adao);
//        System.out.println(as==as1);
        as.saveAccount();
        ac.close();
    }
}
