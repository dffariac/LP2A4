package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class ExUm extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nome = req.getParameter("name");
        String email = req.getParameter("mail");
        String idade = req.getParameter("age");

        int idadeConvert = Integer.parseInt(idade);

        Pessoa pessoa = new Pessoa(nome, email, idadeConvert);

        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Seu cadastro</h1>");
        writer.println("<p>Nome: " + pessoa.getNome() + "</p>");
        writer.println("<p>Email: " + pessoa.getEmail() + "</p>");
        writer.println("<p>Idade: " + pessoa.getIdade() + "</p>");
    }
}

