<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="resources/sucesso.css">
<html>
<head>
    <title>Página de Sucesso</title>
</head>
<body>
<h1>Bem-vindo à Página de Sucesso</h1>

<%-- Verifique se o usuário é organizador ou participante --%>
<%
    boolean isOrganizador = (boolean) request.getAttribute("isOrganizador");
    String username = (String) request.getAttribute("username");
%>

<p>Usuário: <%= username %></p>

<% if (isOrganizador) { %>
<p>Você é um Organizador.</p>
<% } else { %>
<p>Você é um Participante.</p>
<% } %>

<h1>Bem-vindo, ${authenticatedUser.username}!</h1>
<p>Selecione uma opção:</p>
<ul>
    <li><a href="/AddAtividade">Adicionar Atividade</a></li>
    <li><a href="/ListarAtividade">Listar Atividades</a></li>
</ul>

<p><a href="/login">Sair</a></p>
</body>
</html>
