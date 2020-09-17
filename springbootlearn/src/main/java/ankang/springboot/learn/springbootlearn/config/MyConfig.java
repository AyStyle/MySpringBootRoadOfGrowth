package ankang.springboot.learn.springbootlearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-18
 */
// @Configuration����������Ϊ������
@Configuration
public class MyConfig {

    // @Bean�������ص�Bean������Ϊ�����ӵ�Spring�����У�idĬ���Ƿ�����
    @Bean("service")
    public MyService service() {
        return new MyService();
    }


}
