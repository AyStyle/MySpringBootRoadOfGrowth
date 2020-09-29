package ankang.springboot.learn.springbootwithtymleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-27
 */
@Controller
public class LoginController {

    @RequestMapping("toLoginPage")
    public String toLoginPage(Model model) {
        model.addAttribute("currentYear" , LocalDateTime.now(ZoneId.systemDefault()).getYear());

        return "login";
    }

}
