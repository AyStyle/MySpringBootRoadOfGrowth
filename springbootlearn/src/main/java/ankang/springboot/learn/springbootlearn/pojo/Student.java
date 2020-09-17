package ankang.springboot.learn.springbootlearn.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-17
 */
@Component
public class Student {

    @Value("${person.id}")
    private Integer id;

    @Value("${person.name}")
    private  String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
