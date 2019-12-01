package dev.kurama.control;

import dev.kurama.data.DataSource;
import dev.kurama.model.EncuestaBean;
import dev.kurama.model.Pregunta;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        EncuestaBean encuestaBean = new EncuestaBean();
        encuestaBean.setRespuestas(respuestas);
        usuario.setEncuesta(encuestaBean);
        response.setContentType("text/html");
        response.getWriter().println("Encuesta enviada<br>");
        response.getWriter().println("<a href=\"login\">Volver</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (usuario.getEncuesta() == null) {

            request.setAttribute("preguntas", DataSource.getPreguntas());
            request.getRequestDispatcher("Encuesta.jsp").forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            int num = 0;
            for (Pregunta pregunta : DataSource.getPreguntas()) {
                pw.println("<br>Pregunta : " + pregunta.getPregunta() + "<br>");
                int respuesta = usuario.getEncuesta().getRespuestas().get(num);
                pw.println("Respuesta : " + num + " - " + pregunta.getOpciones().get(respuesta) + "<br><br>");
                num++;
            }
            pw.println("<a href=\"login\">Volver</a>");
        }


    }
}
