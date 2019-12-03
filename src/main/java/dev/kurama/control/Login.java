package dev.kurama.control;

import dev.kurama.data.UsuarioDao;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        System.out.println(email + " " + pass);

        Optional<Usuario> usuario = UsuarioDao.getUsuario(email, pass);
        System.out.println(usuario.orElse(new Usuario(0, "Err", "Err")));
        if (usuario.isPresent()) {
            request.getSession().setAttribute("usuario", usuario.get());
            response.sendRedirect("/home");
        } else
            response.sendRedirect("Error.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario == null) {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else
            response.sendRedirect("/home");
    }
}
