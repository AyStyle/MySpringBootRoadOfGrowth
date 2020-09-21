package ankang.springboot.learn.springbootwithmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//  @MapperScan("ankang.springboot.learn.springbootwithmybatis.mapper") // 当有多个Mapper时，Mapper接口可以不使用@Mapper注解，但是必须通过@MapperScan注解来获取Mapper
@SpringBootApplication
public class SpringbootwithmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwithmybatisApplication.class , args);
    }

}
