package com.qmh.service.impl;

import com.qmh.dao.IAccountDao;

import com.qmh.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * 账户的业务层实现类
 *
 * <bean id="accountService" class="com.qmh.service.impl.AccountServiceImpl"
 *        scope="" init-method="" destroy-method="">
 *              <property name="" value="" ref=""></property>
 *        </bean>
 *
 *  用于创建对象的注解
 *          和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *          Component:
 *              用于把当前对象存入spring容器中
 *              属性：
 *                  value:用于指定bean的id,不写时默认时当前类名，且首字母小写
 *           Controller 一般用在表现层
 *           Service    一般用在业务层
 *           Repository  一般用于持久层
 *           以上三个注解的作用和属性与Component一模一样，他们是spring框架提供的明确的三层使用的注释
 *  用于注入数据的
 *          和在<bean>标签中写<property>标签是一样的
 *          Autowired:
 *              自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错
 *              如果ioc容器中有多个bean对象类型匹配时，则需要根据变量名称查找id,若找不到则会报错
 *              可以出现在变量上，也可以是方法上
 *           Qualifier:
 *              在按照类中注入的基础上(Autowired)，再按照名称注入。给类成员注入时不能单独使用，但在给方法参数注入时可以
 *              属性：
 *                  value 用于指定注入bean的id
 *            Resource:
 *              作用：直接按照bean的id注入，可以独立使用
 *              属性：
 *                  name:用于指定bean的id
 *             以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现
 *             另外，集合类型的注入只能通过xml实现
 *
 *             Value
 *                  用于注入基本类型和String类型的数据
 *                  属性：
 *                      value:用于指定数据的值。可以使用spring中的SpEl
 *                      SpEl ${表达式}
 *
 *  用于改变作用范围
 *          和在<bean>标签中使用scope属性是一样的
 *          Scope
 *              用于指定bean的作用范围
 *              属性：  value指定范围的取值， singleton,prototype
 *
 *  和生命周期相关
 *          和在<bean>标签中使用init-method和destroy-method的作用是一样的
 *          PreDestroy 用于指定销毁方法
 *          PostConstruct 用于指定初始化方法
 * */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public AccountServiceImpl(){
        System.out.println("对象创建");
    }
    @Resource(name = "accountDao1")
    private IAccountDao accountDao;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
