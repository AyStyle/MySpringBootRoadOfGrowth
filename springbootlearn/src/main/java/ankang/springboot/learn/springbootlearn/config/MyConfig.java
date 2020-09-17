package ankang.springboot.learn.springbootlearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-18
 */
// @Configuration：表明该类为配置类
@Configuration
public class MyConfig {

    // @Bean：将返回的Bean对象作为组件添加到Spring容器中，id默认是方法名
    @Bean("service")
    public MyService service() {
        return new MyService();
    }


}
