<!DOCTYPE html>
<html>
<head>
    <title> mainPageTitle </title>
</head>
<body>
<h1>fuck yeah | <a href = "/login"> Войти в аккаунт </a></h1>
<form action = "/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти"/>
</form>
<h2>Категории</h2>
<#list category as category>
    <div>
        <p><b><a href = "/category/${category.idCateg}"> ${category.categName} </a></b></p>
    </div>
</#list>
</body>
</html>