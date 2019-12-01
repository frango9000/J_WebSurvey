package dev.kurama.control;

import dev.kurama.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encuesta extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Encuesta.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario.getEncuesta() == null) {
            response.getWriter().println("<form method=\"post\" action=\"encuesta\"> <input type=\"submit\" value=\"Iniciar Encuesta\"></form>");
        } else
            response.getWriter().println("Ya has realizado esta encuesta<br><a href=\"login\">Volver</a> ");

    }
}
