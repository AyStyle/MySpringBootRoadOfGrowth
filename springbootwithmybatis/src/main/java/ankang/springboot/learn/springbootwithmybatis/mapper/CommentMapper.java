package ankang.springboot.learn.springbootwithmybatis.mapper;

import ankang.springboot.learn.springbootwithmybatis.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-22
 */
@Mapper // 表标识该接口是Mybatis的接口文件，并且让SpringBoot能够扫描到该接口，生成该接口的代理对象，存到容器中
public interface CommentMapper {

    @Select("SELECT * FROM springbootdata.t_comment WHERE id = #{id}")
    Comment findById(Integer id);

}
