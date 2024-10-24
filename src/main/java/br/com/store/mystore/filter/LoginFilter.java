package br.com.store.mystore.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();

        if (session.getAttribute("user") == null && !url.endsWith("login") && !url.contains("resources") && !url.contains("home")) {
            req.setAttribute("erro", "Entre com o usuário e senha!");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }
    }
}
