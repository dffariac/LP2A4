<!DOCTYPE html>
<html>
<head>
    <title>Adicionar Atividade</title>
</head>
<body>
<h1>Adicionar Atividade</h1>
<form action="/AddAtividade" method="post">
    <label for="nome">Nome da Atividade:</label>
    <input type="text" id="nome" name="nome" required>
    <br>
    <label for="descricao">Descrição:</label>
    <textarea id="descricao" name="descricao" required></textarea>
    <br>
    <label for="Data">Data:</label>
    <input type="date" id="Data" name="Data" required>
    <br>
    <label for="hora">Hora:</label>
    <input type="text" id="hora" name="hora" required>
    <br>
    <label for="local">Local:</label>
    <input type="text" id="local" name="local" required>
    <br>
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="Adicionar Atividade">
</form>
</body>
</html>