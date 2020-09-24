package ankang.springboot.learn.springbootwithredis.repository;

import ankang.springboot.learn.springbootwithredis.pojo.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-24
 */
public interface PersonRepository extends CrudRepository<Person, String> {

    /**
     * 根据城市，查询Person
     * @param city
     * @return
     */
    List<Person> findByAddressCity(String city);

}
