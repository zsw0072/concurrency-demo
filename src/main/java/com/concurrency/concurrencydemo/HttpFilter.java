package com.concurrency.concurrencydemo;

import com.concurrency.concurrencydemo.example.threadlocal.RequestHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("do filter: "+Thread.currentThread().getId()
            +"-"+request.getRequestURI());
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
