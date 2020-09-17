package ankang.springboot.learn.springbootlearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-16
 */
// @RestController = @ResponseBody + @Controller
@RestController
public class HelloController {

    @RequestMapping("/demo")
    public String demo() {
        return "Hello Spring Boot.....";
    }

}
