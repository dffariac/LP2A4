package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import model.Atividade;
import org.hibernate.Session;
import util.HibernateUtil;


import java.io.IOException;
import java.util.List;


@WebServlet(value = "/ListarAtividade")
public class ListarAtividadeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Atividade novaAtividade = new Atividade();


        List<Atividade> atividades = session.createQuery("from atividades", Atividade.class).list();


        req.setAttribute("atividades", atividades);
        RequestDispatcher dispatcher = req.getRequestDispatcher("listarAtividade.jsp");
        dispatcher.forward(req, resp);
    }
}

