package cn.mobilemart.demo.web.common;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域
 *
 * @author bostin
 * @date 2017-12-26
 */
public class CrossDomainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers:Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Content-Type", "application/json");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
