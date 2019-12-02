package dev.kurama.control;

import dev.kurama.data.DataSource;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUsuario extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (request.getParameter("id") != null && usuario.getId() == 1) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<Usuario> userDetail = DataSource.getUsuario(id);
            if (userDetail.isPresent()) {
                request.setAttribute("userDetail", userDetail.get());
                request.getRequestDispatcher("AdminUsuario.jsp").forward(request, response);
            }
        }
        response.setContentType("text/html");
        response.getWriter().println("Error 418 Im a Teapot <br><br><br> <a href=\"/admin/usuarios\">");
    }
}
