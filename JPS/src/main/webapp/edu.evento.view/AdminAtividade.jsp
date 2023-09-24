<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cursos e Palestras</title>
</head>
<body>
 <center>
  <h1>Cursos e Palestras - Semana do Programador</h1>
        <h2>
         <a href="new">Adicionar nova Atividade</a>
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de atividades</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="atividade" items="${listarAtividade}">
                <tr>
                    <td><c:out value="${atividade.id}" /></td>
                    <td><c:out value="${atividade.nome}" /></td>
                    <td><c:out value="${atividade.descricao}" /></td>
                    <td><c:out value="${atividade.data}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${atividade.id}' />">Editar</a>
                     &nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${atividade.id}' />">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>