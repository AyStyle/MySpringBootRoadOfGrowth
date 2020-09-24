package ankang.springboot.learn.springbootwithjpa;

import ankang.springboot.learn.springbootwithjpa.repository.ArticleRepository;
import ankang.springboot.learn.springbootwithjpa.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringbootwithjpaApplicationTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void commentTest() {
        System.out.println(commentRepository.findById(1).get());
    }


    @Test
    void articleTest() {
        System.out.println(articleRepository.findById(1).get());
    }


}
