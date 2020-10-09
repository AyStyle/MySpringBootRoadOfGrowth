package ankang.springboot.learn.sprintbootwithcatch.controller;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import ankang.springboot.learn.sprintbootwithcatch.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-07
 */
@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

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
