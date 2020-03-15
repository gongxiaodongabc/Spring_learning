package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，它的作用和bean.xml是一样的
 * spring中的新注解
 *  Configuration
 *      指定当前类是一个配置类
 *      当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不使用
 *  ComponentScan
 *      用于通过注解指定spring在创建容器时要扫描的包
 *      属性： value和basePackages的作用一样，都是用于指定创建容器时要扫描的包
 *      使用此注解相当于 <context:component-scan base-package="com.qmh"></context:component-scan>
 *   Bean
 *      用于把当前方法的返回值作为Bean对象存入spring的ioc容器中
 *      属性：
 *          name:用于指定bean的id,默认值时当前方法的名称
 *       当使用注解配置方法时，如果方法有参数，则spring框架会去容器中查找有没有可用的bean对象。查找方式和Autowired注解作用是一样的
 *    Import
 *      用于导入其他的配置类
 *      属性 value 用于指定其他配置类的字节码， 使用import注解之后，有Import注解的类就是父配置类
 *    PropertySource
 *      用于指定properties文件的位置
 *      属性 value 指定文件的名称和路径 关键字 classpath，表示类路径下
 *
 */
//@Configuration
@ComponentScan("com.qmh")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
