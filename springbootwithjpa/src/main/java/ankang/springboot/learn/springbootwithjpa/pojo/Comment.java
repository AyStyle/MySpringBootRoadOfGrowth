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
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")
    private Integer aId;

}
