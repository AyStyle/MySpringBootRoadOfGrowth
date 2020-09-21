package ankang.springboot.learn.springbootwithmybatis.mapper;

import ankang.springboot.learn.springbootwithmybatis.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-22
 */
@Mapper
public interface ArticleMapper {

    Article findById(Integer id);

}
