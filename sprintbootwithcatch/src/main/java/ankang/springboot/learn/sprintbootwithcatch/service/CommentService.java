package ankang.springboot.learn.sprintbootwithcatch.service;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import ankang.springboot.learn.sprintbootwithcatch.reponsitory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-07
 */
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Cacheable：将该方法查询到的结果comment存放在springboot的默认缓存中。
     * CachePut：该方法配合修改方法使用，将修改后的结果保存到缓存中
     * CacheEvict：该方法配合删除方法使用，删除缓存中的数据
     * cacheNames：起一个缓存命名空间，对应缓存唯一标识
     * 缓存结果：key -> 默认在只有一个参数的情况下，key值默认就是方法参数值；如果没有参数或者多个参数的情况下，使用SimpleKeyGenerate
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "comment", unless = "#result==null")
    public Comment findCommentById(Integer id) {
        final Optional<Comment> byId = commentRepository.findById(id);

        return byId.orElse(null);
    }

    @CachePut(value = "comment", key = "#result.id")
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor() , comment.getId());
        return comment;
    }

    @CacheEvict(value = "comment")
    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }

}
