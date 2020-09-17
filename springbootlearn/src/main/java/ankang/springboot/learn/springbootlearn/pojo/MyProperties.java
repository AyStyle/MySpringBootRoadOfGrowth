package ankang.springboot.learn.springbootlearn.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
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
    private Integer age;
    private String name;
    private String desc;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
