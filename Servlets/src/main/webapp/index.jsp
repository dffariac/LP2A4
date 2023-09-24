<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>Formulário de cadastro!</h1>
<form action="/exemploum" method="post">
    <div>
        <label>Nome:</label>
        <input type="text" name="name"/>
    </div>
    <div>
        <label>E-mail:</label>
        <input type="email" name="mail"/>
    </div>
    <div>
        <label>Idade:</label>
        <input type="number" name="age"/>
    </div>
    <br>
    <div class="button">
        <button type="submit">Enviar seu cadastro</button>
    </div>
</form>
</body>
</html>