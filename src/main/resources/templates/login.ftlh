<!DOCTYPE html>
<html>
<head>
    <title>loginPage</title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1><hr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username" required><br><br>
    Пароль: <input type="password" name="password" requered><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<p>Нет аккаунта? <a href="/registration">Зарегистрируйся!</a>
</body>
</html>