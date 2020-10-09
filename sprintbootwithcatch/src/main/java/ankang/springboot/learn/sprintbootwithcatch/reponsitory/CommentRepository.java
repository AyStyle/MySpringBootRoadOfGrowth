package ankang.springboot.learn.sprintbootwithcatch.reponsitory;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-07
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE springbootdata.t_comment SET author = ?1 WHERE id = ?2", nativeQuery = true)
    Integer updateComment(String auther , Integer id);

}
