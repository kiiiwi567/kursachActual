<!DOCTYPE html>
<html>
<head>
    <title> neMainPageTitle </title>
</head>
<body>
<h1>fuck yeah</h1>
<h4>инфа по товарчику</h4>
<#list images as img>
    <img src="/images/${img.imgId}" height="100px"/><br><br>
</#list>
<b>Название товара: </b> ${instrument.instName}<br>
<b>Цена товара: </b> ${instrument.instPrice}<br>
<b>Категория товара: </b> ${instrument.categoryIdCateg}<br>
<b>Описание товара: </b> ${instrument.instDescription}<br>
<b>Количество товара: </b> ${instrument.instQuantity}<br>
<b>Автор: </b>${instrument.author}<br>
<hr>
<form action="/instrument/delete/${instrument.idInst}" method="post">
    <input type ="submit" value="Удоли"/>
</form>
</body>
</html>