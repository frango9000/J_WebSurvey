package dev.kurama.control;

import dev.kurama.data.DataSource;
import dev.kurama.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioDetail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (request.getParameter("id") != null && usuario.getId() == 1)
            request.setAttribute("userDetail", DataSource.getUsuario(Integer.parseInt(request.getParameter("id"))));
        else {
            request.setAttribute("userDetail", usuario);
        }
        request.getRequestDispatcher("Usuario.jsp").forward(request, response);
    }
}
