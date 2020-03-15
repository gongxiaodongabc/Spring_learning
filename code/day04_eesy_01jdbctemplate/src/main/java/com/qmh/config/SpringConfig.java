package com.qmh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sound.midi.SoundbankResource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.qmh")
@Import({JdbcConfig.class})
public class SpringConfig {

    @Autowired
    private DataSource dataSource;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(){
        //1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(dataSource);

        return jt;
    }
}
