package ankang.springboot.learn.sprintbootwithcatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // 开启SpringBoot基于注解的缓存管理支持
public class SprintbootwithcatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintbootwithcatchApplication.class , args);
    }

}
