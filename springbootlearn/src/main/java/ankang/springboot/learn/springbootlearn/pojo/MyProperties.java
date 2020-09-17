package ankang.springboot.learn.springbootlearn.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-18
 */
@Component
// @PropertySource：加载自定义配置文件
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "test")
public class MyProperties {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
