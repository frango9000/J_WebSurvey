package dev.kurama.control;

import dev.kurama.data.DataSource;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Encuesta extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Integer> respuestas = new ArrayList<>();
        for (int i = 0; i < DataSource.getPreguntas().size(); i++) {
            respuestas.add(Integer.parseInt(request.getParameter("radio" + i)));
        }
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        usuario.setRespuestas(respuestas);
        em.getTransaction().begin();
        em.merge(usuario);
        em.flush();
        em.getTransaction().commit();

        response.setContentType("text/html");
        response.getWriter().println("<br>Encuesta enviada<br><br>");
        response.getWriter().println("<a href=\"login\">Volver</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (!usuario.isEncuestaRealizada()) {
            request.setAttribute("preguntas", DataSource.getPreguntas());
            request.getRequestDispatcher("Encuesta.jsp").forward(request, response);
        } else {
            response.setContentType("text/html");
            response.getWriter().println("Encuesta finalizada<br><br>");
            response.getWriter().println("<a href=\"login\">Volver</a>");
        }


    }
}
