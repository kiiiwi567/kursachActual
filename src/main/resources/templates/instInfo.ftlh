<!DOCTYPE html>
<html>
<head>
    <title> neMainPageTitle </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a> | <a href = "/login"> Войти в аккаунт </a></h1>
<form action = "/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Выйти"/>
</form>
<h4>инфа по товарчику</h4>
<#list images as img>
    <img src="/images/${img.idImg}" height="100px"/><br><br>
</#list>
<b>Название товара: </b> ${instrument.instName}<br>
<b>Цена товара: </b> ${instrument.instPrice}<br>
<b>Категория товара: </b> ${instrument.idCateg}<br>
<b>Описание товара: </b> ${instrument.instDescription}<br>
<b>Количество товара: </b> ${instrument.instQuantity}<br>
<b>Автор: </b>${instrument.author}<br>
<hr>
<form action="delete/${instrument.idInst}" method="post">
    <input type ="submit" value="Удоли"/>
</form>
</body>
</html>