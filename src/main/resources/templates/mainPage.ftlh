<!DOCTYPE html>
<html>
<head>
    <title> mainPage </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<#if user.userEmail??>
<h3>Имя пользователя: ${user.username}
    <form action = "/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
<#else>
    <a href = "/login">Войти</a>
</#if>
<h2>Категории</h2>
<#list category as category>
    <div>
        <p><b><a href = "/category/${category.idCateg}"> ${category.categName} </a></b></p>
    </div>
</#list>
</body>
</html>