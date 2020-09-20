package ankang.springboot.learn.config;

import ankang.springboot.learn.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-20
 */
@Configuration
// @ConditionalOnClass：当类路径classpath下有指定的类时，就会进行自动配置
@ConditionalOnClass
public class MyAutoConfiguration {

    static {
        System.out.println("MyAutoConfiguration init...");
    }

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

}
