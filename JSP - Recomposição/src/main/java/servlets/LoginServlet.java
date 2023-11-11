package servlets;

import DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Session session = HibernateUtil.getSessionFactory().openSession();
    UserDAO userDAO = new UserDAO(session);
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenha os parâmetros de usuário e senha do formulário HTML
        String usernameLogin = request.getParameter("usernameLogin");
        String passwordLogin = request.getParameter("passwordLogin");




        // Verifique se o usuário e a senha são válidos (isso pode envolver uma consulta ao banco de dados)
        if (isValidUser(usernameLogin, passwordLogin)) {
            User user = userDAO.findByUsername(usernameLogin);

            // Armazene o usuário autenticado na sessão
            HttpSession session = request.getSession();
            session.setAttribute("authenticatedUser", user);

            // Verifique se o usuário é organizador ou participante
            boolean isOrganizador = user.isOrganizador();

            // Defina os atributos na requisição
            request.setAttribute("isOrganizador", isOrganizador);
            request.setAttribute("username", usernameLogin);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/sucesso.jsp");
            dispatcher.forward(request, response); // Redirecione para a página de sucesso
        } else {
            // Autenticação falhou
            response.sendRedirect("/pagina-de-erro.jsp"); // Redirecionar para a página de erro
        }
    }

    private boolean isValidUser(String usernameLogin, String passwordLogin) {
        User user = userDAO.findByUsername(usernameLogin);

        if (user != null && user.getUsername().equals(usernameLogin) && user.getPassword().equals(passwordLogin)) {
            return true;
        }else{
            return false;
        }

    }

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
        dispatcher.forward(req, resp);
    }
}
