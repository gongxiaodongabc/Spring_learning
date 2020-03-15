package com.qmh.jdbctemplate;

import com.qmh.config.JdbcConfig;
import com.qmh.config.SpringConfig;
import com.qmh.dao.IAccountDao;
import com.qmh.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sound.midi.SoundbankResource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate的CRUD操作
 */

public class JdbcTemplateDemo_anno {

    public static void main(String[] args) {
        // 1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);

        Account account = accountDao.findAccountById(5);
        System.out.println(account);

//        JdbcTemplate jt= (JdbcTemplate)ac.getBean("jdbcTemplate");
        //3.执行操作
        //保存
//        jt.update("insert into account(name,money)values(?,?)","eeee",3333f);
        //更新
//        jt.update("update account set name=?,money=? where id=?","zs",8888,7);
        //删除
//        jt.update("delete from account where id=?",8);
        //查询所有
//        List<Account> accounts = jt.query("select * from account where money>?",new AccountRowMapper(),1000f);
//        List<Account> accounts = jt.query("select * from account where money>?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
//        for(Account account:accounts){
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accounts = jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),1);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一行一列（使用聚合函数，但不加group by 子句）
//        Long count = jt.queryForObject("select count(*) from account where money>?",Long.class,1000f);
//        System.out.println(count);
    }

    /**
     * 定义Account的封装策略
     */
    class AccountRowMapper implements RowMapper<Account>{
        /**
         * 把结果集中的数据封装到Account中，由spring把每个Account封装到集合中
         * @param resultSet
         * @param i
         * @return
         * @throws SQLException
         */

        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getFloat("money"));
            return account;
        }
    }


}
