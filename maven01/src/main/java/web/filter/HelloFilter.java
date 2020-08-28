package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author dyh
 * @date 2020.08.27 上午 10:20
 */
@WebFilter(filterName = "HelloFilter",urlPatterns = "/*")
public class HelloFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("...................1: 过滤器 (初始化) ...................");
        System.out.println("eeee你好");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("................... 过滤器   (前) ...................");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8"); //返回页面数据乱码处理


        chain.doFilter(request, response);
        System.out.println("................... 过滤器   (后) ...................");
    }

    public void destroy() {
        System.out.println("................... 过滤器 (销毁) ...................");
    }

}
