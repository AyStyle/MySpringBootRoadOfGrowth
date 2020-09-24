package ankang.springboot.learn.springbootwithjpa.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-22
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String title ;
    private String content;

}
