// InscricaoAtividadeServlet.java
package servlets;

import DAO.AtividadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Atividade;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import java.io.IOException;

@WebServlet("/InscricaoAtividade")
public class InscricaoAtividadeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verifique se o usuário está autenticado
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("authenticatedUser");
        if (user == null || user.isOrganizador()) {
            // O usuário não está autenticado ou é um organizador
            response.sendRedirect("/pagina-de-erro.jsp");
            return;
        }

        // Recupere o ID da atividade da solicitação
        String atividadeIdParam = request.getParameter("atividadeId");

        if (atividadeIdParam != null) {
            int atividadeId = Integer.parseInt(atividadeIdParam);

            // Abra uma sessão do Hibernate
            Session hibernateSession = HibernateUtil.getSessionFactory().openSession();
            AtividadeDAO atividadeDAO = new AtividadeDAO(hibernateSession);

            // Agora você tem o ID da atividade, associe o usuário a essa atividade
            Atividade atividade = atividadeDAO.findById(atividadeId);

            if (atividade != null) {
                // Realize a inscrição associando o usuário à atividade
                atividadeDAO.realizarInscricao(user, atividade);

                // Feche a sessão do Hibernate
                hibernateSession.close();

                response.sendRedirect("/sucesso-inscricao.jsp");
            } else {
                // A atividade com o ID especificado não foi encontrada
                response.sendRedirect("/pagina-de-erro.jsp");
            }
        } else {
            // O ID da atividade não foi especificado na solicitação
            response.sendRedirect("/pagina-de-erro.jsp");
        }
    }
}
