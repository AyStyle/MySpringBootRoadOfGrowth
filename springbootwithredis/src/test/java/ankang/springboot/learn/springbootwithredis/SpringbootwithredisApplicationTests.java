package ankang.springboot.learn.springbootwithredis;

import ankang.springboot.learn.springbootwithredis.pojo.Address;
import ankang.springboot.learn.springbootwithredis.pojo.Person;
import ankang.springboot.learn.springbootwithredis.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringbootwithredisApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testSavePerson() {
        final Person person = new Person();
        person.setName("张三");

        final Address address = new Address();
        address.setCity("北京");
        address.setProvince("北京");
        person.setAddress(address);

        // 向Redis中写入数据
        personRepository.save(person);
    }

    @Test
    void personTest() {
        personRepository.findAll().forEach(System.out::println);
    }

    @Test
    void testFindByCity() {
        personRepository.findByAddressCity("北京").forEach(System.out::println);
    }

}
