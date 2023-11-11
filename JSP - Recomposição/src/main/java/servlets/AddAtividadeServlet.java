package servlets;


import DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import model.Atividade;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FormatarData;
import util.HibernateUtil;


import java.io.IOException;
import java.util.Date;

@WebServlet(name = "RegistrationServelet", urlPatterns = "/AddAtividade")
public class AddAtividadeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        Date data = FormatarData.formatarData(req.getParameter("Data"));
        String hora = req.getParameter("hora");
        String local = req.getParameter("local");

        // Verifique se o usuário está autenticado
        User authenticatedUser = (User) req.getSession().getAttribute("authenticatedUser");

        if (authenticatedUser != null && authenticatedUser.isOrganizador()) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            UserDAO userDAO = new UserDAO(session);

            // Obtenha o usuário autenticado diretamente da sessão
            User user = (User) req.getSession().getAttribute("authenticatedUser");

            // Crie a atividade associando-a ao usuário autenticado
            Atividade atividade = new Atividade(nome, descricao, data, hora, local, null);

            // Adicione a atividade à lista de atividades do usuário
            user.getAtividades().add(atividade);

            Transaction transaction = session.beginTransaction();

            session.persist(atividade);

            transaction.commit();
            session.close();

            resp.sendRedirect("ListarAtividade");
        } else {
            resp.sendRedirect("/pagina-de-erro.jsp");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Verifique se o usuário está autenticado
        User authenticatedUser = (User) req.getSession().getAttribute("authenticatedUser");
        if (authenticatedUser != null && authenticatedUser.isOrganizador()) {
            // Permita o acesso à página "/AddAtividade"
            RequestDispatcher dispatcher = req.getRequestDispatcher("/AddAtividade.jsp");
            dispatcher.forward(req, resp);
        } else {
            // Se o usuário não for um organizador, redirecione para uma página de erro ou negação de acesso
            resp.sendRedirect("/pagina-de-erro.jsp");
        }
    }
}