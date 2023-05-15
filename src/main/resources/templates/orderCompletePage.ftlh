<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1><a href="/"> mainFuckingPage </a></h1>
<#if user.userEmail??>
<h3>Имя пользователя: ${user.username}
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
    <#if user.isAdmin()>
        <a href="/adminPage"> Панель администратора</a>
    </#if>
    <#else>
    <a href="/login">Войти</a>
</h3>
</#if>
Ваш заказ оформлен!