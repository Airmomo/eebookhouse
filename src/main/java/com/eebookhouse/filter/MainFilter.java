package com.eebookhouse.filter;

import com.eebookhouse.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class MainFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String url = req.getRequestURL().toString();
        if(!url.contains("/static/") && !url.contains("/login") && !url.contains("/register") && !url.contains("/index")){//&& !url.endsWith("/")
            HttpSession session = req.getSession();
            User user  = (User) session.getAttribute("user");
            if(user == null) {
                res.sendRedirect("login");
                return;
            }
        }
        chain.doFilter(req, res);
    }

}
