<!DOCTYPE html>
<html>
<head>
    <title> ${instrument.instName} Info </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<#if user.userEmail??>
<h3>Имя пользователя: ${user.username}
    <form action = "/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/adminPage"> Панель администратора</a>
    </#if>
    <#else>
        <a href = "/login">Войти</a>
    </#if>
<h4><b>${instrument.instName}</b></h4><br>
<#list images as img>
    <img src="/images/${img.idImg}" height="100px"/><br><br>
</#list>
<b>Название товара: </b> ${instrument.instName}<br>
<b>Цена товара: </b> ${instrument.instPrice}<br>
<b>Категория товара: </b> ${instrument.idCateg}<br>
<b>Описание товара: </b> ${instrument.instDescription}<br>
<b>Количество товара: </b> ${instrument.instQuantity}<br>
<b>Автор: </b>${instrument.user.username}<br>
<#if user.isAdmin()>
    <hr>
    <form action="edit/${instrument.idInst}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type ="submit" value="Редактировать"/>
    </form>
    <hr>
    <form action="delete/${instrument.idInst}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type ="submit" value="Удалить"/>
    </form>
</#if>
</body>
</html>