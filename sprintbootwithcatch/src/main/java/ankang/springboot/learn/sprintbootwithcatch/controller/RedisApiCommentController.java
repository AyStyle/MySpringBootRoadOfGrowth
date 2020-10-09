package ankang.springboot.learn.sprintbootwithcatch.controller;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import ankang.springboot.learn.sprintbootwithcatch.service.CommentService;
import ankang.springboot.learn.sprintbootwithcatch.service.RedisApiCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-07
 */
@RestController
@RequestMapping("/redis")
public class RedisApiCommentController {

    @Autowired
    private RedisApiCommentService commentService;


    @RequestMapping("/findCommentById")
    public Comment findCommentById(Integer id) {
        return commentService.findCommentById(id);
    }

    @RequestMapping("/updateComment")
    public Comment updateComment(Comment comment) {
        final Comment byId = commentService.findCommentById(comment.getId());
        byId.setAuthor(comment.getAuthor());

        return commentService.updateComment(byId);
    }

    @RequestMapping("/deleteCommentById")
    public void deleteCommentById(Integer id) {
        commentService.deleteCommentById(id);
    }

}
