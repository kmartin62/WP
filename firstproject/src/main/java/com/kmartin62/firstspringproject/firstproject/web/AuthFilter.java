package com.kmartin62.firstspringproject.firstproject.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kmartin62
 */
@WebFilter
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String name = (String) req
                .getSession()
                .getAttribute("firstName");

        String path = req.getServletPath();

        if (!"/login".equals(path) && (name == null || name.isEmpty())) {
            resp.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
