package ankang.springboot.learn.springbootwithtymleaf.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义方法区域解析器
 *
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-09-29
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取URL传入的语言
        final String l = request.getParameter("l");
        if (l != null && !"".equals(l)) {
            // 参数不为空，根据参数手动切换
            final String[] s = l.split("_");
            return new Locale(s[0] , s[1]);
        } else {
            final String header = request.getHeader("Accept-Language");
            final String[] s = header.split(",")[0].split("-");

            return new Locale(s[0] , s[1]);
        }
    }

    @Override
    public void setLocale(HttpServletRequest request , HttpServletResponse response , Locale locale) {

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
