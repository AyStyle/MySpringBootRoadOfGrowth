package ankang.springboot.learn.sprintbootwithcatch.service;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import ankang.springboot.learn.sprintbootwithcatch.reponsitory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-08
 */
@Service
public class RedisApiCommentService {

    private final CommentRepository commentRepository;

    private final RedisTemplate<String, Comment> redisTemplate;

    public RedisApiCommentService(CommentRepository commentRepository , RedisTemplate redisTemplate) {
        this.commentRepository = commentRepository;
        this.redisTemplate = (RedisTemplate<String, Comment>) redisTemplate;
    }


    /**
     * 使用API方式进行缓存，先去缓存中查询，如果有，则：直接返回；没有，查询数据库
     *
     * @param id
     * @return
     */
    public Comment findCommentById(Integer id) {
        final Comment o = redisTemplate.opsForValue().get("comment_" + id);

        if (o != null) {
            return o;
        }

        final Optional<Comment> byId = commentRepository.findById(id);
        if (byId.isPresent()) {
            redisTemplate.opsForValue().set("comment_" + id , byId.get() , 1 , TimeUnit.DAYS);
        }

        return byId.orElse(null);
    }

    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor() , comment.getId());

        final Comment cache = redisTemplate.opsForValue().get("comment_" + comment.getId());
        cache.setAuthor(comment.getAuthor());
        redisTemplate.opsForValue().set("comment_" + cache.getId() , cache);
        return cache;
    }

    public void deleteCommentById(Integer id) {
        redisTemplate.delete("comment_" + id);
        commentRepository.deleteById(id);
    }

}
