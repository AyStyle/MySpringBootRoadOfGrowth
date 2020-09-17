package ankang.springboot.learn.springbootlearn;

import ankang.springboot.learn.springbootlearn.controller.HelloController;
import ankang.springboot.learn.springbootlearn.pojo.Person;
import ankang.springboot.learn.springbootlearn.pojo.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

//@ExtendWith：扩展测试启动器，使用Spring扩展支持Spring单元测试
@ExtendWith(SpringExtension.class)
// @SpringBootTest：标记该类为SpringBoot单元测试类，并加载项目的ApplicationContext上下文环境
@SpringBootTest
class SpringbootlearnApplicationTests {

    @Autowired
    private HelloController helloController;

    @Autowired
    private Person person;

    @Autowired
    private Student student;

    @Test
    void contextLoads() {
        final String demo = helloController.demo();
        System.out.println(demo);
    }

    @Test
    void propertyConfigTest() {
        System.out.println(person);
    }

    @Test
    void studentTest() {
        System.out.println(student);
    }

}
