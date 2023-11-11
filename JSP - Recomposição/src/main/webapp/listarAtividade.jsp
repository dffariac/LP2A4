<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Listagem de Atividades</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Data</th>
        <th>Hora</th>
        <th>Local</th>
        <th>Situacao</th>
    </tr>
    <c:forEach var="atividade" items="${atividades}">
        <tr>
            <td>${atividade.nome}</td>
            <td>${atividade.descricao}</td>
            <td>${atividade.data}</td>
            <td>${atividade.hora}</td>
            <td>${atividade.local}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty atividade.inscritos}">
                        <c:forEach var="inscrito" items="${atividade.inscritos}">
                            <c:if test="${inscrito.id == authenticatedUser.id}">
                                <span>Inscrito</span>
                                <c:set var="isUserInscrito" value="true" scope="request" />
                            </c:if>
                        </c:forEach>
                    </c:when>
                </c:choose>

                <c:if test="${empty isUserInscrito}">
                    <form action="InscricaoAtividade" method="post">
                        <input type="hidden" name="userId" value="${authenticatedUser.id}">
                        <input type="hidden" name="atividadeId" value="${atividade.id}">
                        <input type="submit" value="Inscrever-se">
                    </form>
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
