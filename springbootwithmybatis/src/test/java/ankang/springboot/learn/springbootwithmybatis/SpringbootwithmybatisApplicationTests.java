package ankang.springboot.learn.springbootwithmybatis;

import ankang.springboot.learn.springbootwithmybatis.mapper.ArticleMapper;
import ankang.springboot.learn.springbootwithmybatis.mapper.CommentMapper;
import ankang.springboot.learn.springbootwithmybatis.pojo.Article;
import ankang.springboot.learn.springbootwithmybatis.pojo.Comment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringbootwithmybatisApplicationTests {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Test
    void commentTest() {
        final Comment comment = commentMapper.findById(1);

        System.out.println(comment);
    }


    @Test
    void articleTest(){
        final Article article = articleMapper.findById(1);
        System.out.println(article);
    }
}
