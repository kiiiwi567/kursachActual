<!DOCTYPE html>
<html>
<head>
    <title> neMainPageTitle </title>
</head>
<body>
<h1>fuck yeah</h1>
<h4>инфа по товарчику</h4>
<b>Название товара: </b> ${instrument.name}<br>
<b>Цена товара: </b> ${instrument.price}<br>
<b>Категория товара: </b> ${instrument.category}<br>
<b>Описание товара: </b> ${instrument.description}<br>
<hr>
<form action="/instrument/delete/${instrument.ID}" method="post">
    <input type ="submit" value="Удоли"/>
</form>
</body>
</html>