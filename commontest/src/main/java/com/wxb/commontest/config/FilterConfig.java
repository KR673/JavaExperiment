package com.wxb.commontest.config;

import javax.servlet.*;
import java.io.IOException;

//@Order(1)
//@WebFilter(filterName = "fiterConfig", urlPatterns = "/*", initParams = {
//        @WebInitParam(name = "URL", value = "http://localhost:8070")})
public class FilterConfig implements Filter {

    private String url;

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        this.url = filterConfig.getInitParameter("URL");
        System.out.println("我是过滤器的初始化方法！URL=" + this.url +  "，生活开始.........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器的执行方法，客户端向Servlet发送的请求被我拦截到了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("我是过滤器的执行方法，Servlet向客户端发送的响应被我拦截到了");
    }

    @Override
    public void destroy() {

    }
}
