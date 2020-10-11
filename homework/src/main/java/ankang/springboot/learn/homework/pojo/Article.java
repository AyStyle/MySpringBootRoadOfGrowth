package ankang.springboot.learn.homework.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-09
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "t_article",schema = "blog_system")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Date created;
    private Date modified;
    private String categories;
    private String tags;
    @Column(name = "allow_comment")
    private Integer allowComment;
    private String thumbnail;

}
