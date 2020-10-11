package ankang.springboot.learn.homework.service;

import ankang.springboot.learn.homework.pojo.Article;

import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-10
 */
public interface ArticleService {

    Article findById(Integer id);

    List<Article> findAll();

    List<Article> findAllWithPageable(Integer page , Integer size);

}
