package dev.kurama.control;

import dev.kurama.data.UsuarioDao;
import dev.kurama.model.Usuario;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUsuarios extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        String responseMsg = "";
        if (email != null && pass != null && email.length() > 0 && pass.length() > 0) {
            Usuario usuario = new Usuario(email, pass);

            try {
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(usuario);
                em.flush();
                em.getTransaction().commit();
                responseMsg = "Nuevo Usuario Creado con id " + usuario.getId();
            } catch (Exception e) {
                responseMsg = "Error";
            }

        }
        response.setContentType("text/html");
        response.getWriter().println(responseMsg + "<br><br> <a href=\"/admin/usuarios\">Volver</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("usuarios", UsuarioDao.getUsuarios());
        request.getRequestDispatcher("AdminUsuarios.jsp").forward(request, response);
    }
}
