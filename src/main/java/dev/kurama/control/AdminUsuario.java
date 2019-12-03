package dev.kurama.control;

import dev.kurama.data.UsuarioDao;
import dev.kurama.model.Usuario;
import java.io.IOException;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUsuario extends HttpServlet {

    private static final int ACTION_CAMBIO_CLAVE = 1;
    private static final int ACTION_RESET_ENCUESTA = 2;
    private static final int MIN_PASSWORD_LENGTH = 4;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int action = Integer.parseInt(request.getParameter("action"));
        int affectedid = Integer.parseInt(request.getParameter("affectedid"));
        String responseMsg = "";
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        Optional<Usuario> userOpt = UsuarioDao.getUsuario(em, affectedid);

        switch (action) {
            case ACTION_CAMBIO_CLAVE:
                String newPass1 = request.getParameter("newPass1");
                String newPass2 = request.getParameter("newPass2");
                if (newPass1 != null && newPass1.equals(newPass2) && !newPass1.isEmpty() && newPass1.length() >= MIN_PASSWORD_LENGTH && userOpt.isPresent()) {
                    userOpt.get().setPass(newPass1);
                    mergeUsuario(userOpt, em);
                    responseMsg = "Operacion finalizada";
                } else
                    responseMsg = "Parametros invalidos";
                break;
            case ACTION_RESET_ENCUESTA:
                if (userOpt.isPresent()) {
                    userOpt.get().getRespuestas().clear();
                    mergeUsuario(userOpt, em);
                    responseMsg = "Operacion finalizada";
                } else
                    responseMsg = "Error";
                break;
            default:
                responseMsg = "Error";
                break;
        }

        response.setContentType("text/html");
        response.getWriter().println(responseMsg + "<br><br> <a href=\"/admin/usuario?id=" + affectedid + "\">Volver</a>");

    }

    private void mergeUsuario(Optional<Usuario> userOpt, EntityManager em) {
        em.getTransaction().begin();
        em.merge(userOpt.get());
        em.flush();
        em.getTransaction().commit();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if (request.getParameter("id") != null && usuario.getId() == 1) {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<Usuario> userDetail = UsuarioDao.getUsuario(id);
            if (userDetail.isPresent()) {
                request.setAttribute("userDetail", userDetail.get());
                request.getRequestDispatcher("AdminUsuario.jsp").forward(request, response);
            }
        }
        response.setContentType("text/html");
        response.getWriter().println("Error 418 Im a Teapot <br><br><br> <a href=\"/admin/usuarios\">Volver</a>");
    }
}
