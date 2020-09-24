package ankang.springboot.learn.springbootwithredis.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@RedisHash("address")
public class Address {

    @Indexed
    private String province;
    @Indexed
    private String city;


}
