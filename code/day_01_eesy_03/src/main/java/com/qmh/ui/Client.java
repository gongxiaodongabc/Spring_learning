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
     * applicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext:加载类路径下的配置文件
     *      FileSystemXmlApplicationContext： 加载磁盘任意路径下的配置文件
     *      AnnotationConfigApplicationContext：用于读取注解创建容器
     *
     *   核心容器的两个接口引发的问题：
     *      ApplicationContext ：  单例对象适用 采用此接口
     *          构建核心容器时，创建对象采取的策略是立即加载的方式
     *       BeanFactory:       多例对象适用
     *          构建核心容器时，创建对象采用延迟加载的方式，根据id获取对象时才真正创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\qmh\\IdeaProjects\\spring_demo\\src\\main\\resources\\bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);*/


        /*beanfactory*/
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");

    }
}
