package ankang.springboot.learn.springbootwithredis.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-23
 */
@Getter
@Setter
@ToString
@RedisHash("persons") // 指定实体类对象在redis中的存储空间
public class Person {

    @Id // 用来标识实体类主键，字符串形式的hashkey标识唯一的实体类对象id
    private String id;
    @Indexed // 用来标识对应属性在redis中生成二级索引
    private String name;
    private Address address;


}
