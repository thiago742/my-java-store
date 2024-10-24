package br.com.store.mystore.controller;

import br.com.store.mystore.bo.EmailBo;
import br.com.store.mystore.dao.UsuarioDao;
import br.com.store.mystore.exception.EmailException;
import br.com.store.mystore.factory.DaoFactory;
import br.com.store.mystore.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsuarioDao usuarioDao;
    private EmailBo bo;

    public LoginServlet() {
        usuarioDao = DaoFactory.getUsuarioDAO();
        bo = new EmailBo();
    }

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = new Usuario(email, senha);
        if (usuarioDao.validarUsuario(usuario)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", email);

            String mensagem =
                    "Um login foi realizado na plataforma em " + LocalDate.now();
            request.getRequestDispatcher("home.jsp").forward(request, response);
            try {
                bo.enviarEmail(email, "Login Realizado", mensagem);
            } catch (EmailException e) {
                e.printStackTrace();
            }

        } else {
            request.setAttribute("erro", "Usuário e/ou senha inválidos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
