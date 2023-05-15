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
<table border="1">
    <tr>
        <td>Название</td>
        <td>Количество</td>
        <td>Суммарная стоимость</td>
    </tr>
    <#list bucket.bucketDetails as detail>
        <tr>
            <td> ${detail.title}</td>
            <td> ${detail.instQuantity}</td>
            <td> ${detail.sum}</td>
        </tr>
    </#list>
</table>
Общая стоимость заказа: <#if bucket.sum??> ${bucket.sum} <#else> 0 </#if> <br>
<form action="/order/complete" method="post">
Дата доставки: <input type="date" name="orderDelivDate" required/> <br>
Тип доставки:  Доставка<input type="radio" id="Dost" name="orderType" value="Доставка" required><br>
               Самовывоз<input type="radio" id="Samov" name="orderType" value="Самовывоз" required>
    <input type="submit" value="Завершить заказ"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</body>
</html>