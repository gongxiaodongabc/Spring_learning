import com.qmh.domain.Account;
import com.qmh.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

/**
 * 使用Junit单元测试配置
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用spring提供的main方法
@ContextConfiguration(classes = SpringConfiguration.class) // 告知spring的ioc创建是基于xml的还是基于注解的
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){

       as.transfer("aaa","bbb",100f);

    }

}
