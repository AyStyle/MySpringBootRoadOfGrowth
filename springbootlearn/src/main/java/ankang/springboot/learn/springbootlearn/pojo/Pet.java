package ankang.springboot.learn.springbootlearn.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-17
 */
@Component
@ConfigurationProperties(prefix = "pet")
public class Pet {

    private String type;
    private String name;

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
