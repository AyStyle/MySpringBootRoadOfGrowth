package ankang.springboot.learn.homework.service;

import ankang.springboot.learn.homework.dao.ArticleDao;
import ankang.springboot.learn.homework.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-10
 */
@Service
public class MySqlArticleService implements ArticleService {

    private final ArticleDao articleDao;

    public MySqlArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article findById(Integer id) {
        return articleDao.findById(id).orElse(null);
    }

    @Override
    public List<Article> findAll() {
        return articleDao.findAll();
    }

    @Override
    public List<Article> findAllWithPageable(Integer page , Integer size) {
        if (page == null || page <= 0 || size == null || size == 0) {
            return Collections.emptyList();
        }

        final Sort sort = Sort.by(Sort.Order.asc("id"));
        final int sqlPage = page - 1;
        final Pageable pageable = PageRequest.of(sqlPage , size , sort);
        final Page<Article> all = articleDao.findAll(pageable);

        if (!all.hasContent()) {
            return Collections.emptyList();
        }

        return all.getContent();
    }
}
