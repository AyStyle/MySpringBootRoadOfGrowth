package ankang.springboot.learn.homework.dao;

import ankang.springboot.learn.homework.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-10
 */
public interface ArticleDao extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {


}
