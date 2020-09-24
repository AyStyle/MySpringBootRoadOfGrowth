package ankang.springboot.learn.springbootwithjpa.repository;

import ankang.springboot.learn.springbootwithjpa.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-22
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
}
