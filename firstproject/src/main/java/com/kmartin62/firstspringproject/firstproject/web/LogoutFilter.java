package com.kmartin62.firstspringproject.firstproject.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kmartin62
 */

@WebFilter(urlPatterns = "/logout")
public class LogoutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        req.getSession().invalidate();

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        resp.sendRedirect("/login");
    }

    @Override
    public void destroy() {

    }
}
