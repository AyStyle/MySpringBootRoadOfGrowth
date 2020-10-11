package ankang.springboot.learn.homework.controller;

import ankang.springboot.learn.homework.pojo.Article;
import ankang.springboot.learn.homework.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-10
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/findAllWithPageable")
    public String findAllWithPageable(Integer page , Integer size , Model model) {
        final List<Article> articles = articleService.findAllWithPageable(page , size);
        model.addAttribute("articles" , articles);

        return "index";
    }

}
