package dev.kurama.control;

import dev.kurama.data.DataSource;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        System.out.println(email + " " + pass);
        Optional<Usuario> usuario = DataSource.getUsuario(email, pass);
        System.out.println(usuario.orElse(new Usuario(0, "Err", "Err")));
        if (usuario.isPresent()) {
            request.setAttribute("usuario", usuario.get());
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
        } else
            request.getRequestDispatcher("Error.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello Narf");
    }
}
