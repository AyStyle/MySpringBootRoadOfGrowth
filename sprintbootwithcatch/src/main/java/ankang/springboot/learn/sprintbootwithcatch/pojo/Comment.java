package ankang.springboot.learn.sprintbootwithcatch.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-07
 */
@Getter
@Setter
@ToString
@Table(name = "t_comment")
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String author;
    @Column(name = "a_id")
    private Integer aid;

}
