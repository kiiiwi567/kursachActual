<!DOCTYPE html>
<html>
<head>
    <title> mainPageTitle </title>
</head>
<body>
<h1>fuck yeah</h1>
<h4>товары товарчики</h4>
<form action="/" method="get">
    Поиск: <input type="text" name="instName"><br/>
    <input type="submit" value ="Поиск"/>
</form>
<#list instrument as instrument>
    <div>
        <p><b> ${instrument.instName} </b> ${instrument.instPrice} BYN <a href = "/instrument/${instrument.idInst}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/instrument/create" method="post">
    Название: <input type="text" name="instName"/><br><br>
    Цена: <input type="number" name="instPrice"/><br><br>
    Категория: <input type="number" name="idCateg"/><br><br>
    Описание: <input type="text" name="instDescription"/><br><br>
    Количество товара: <input type="number" name="instQuantity"/><br><br>
    <input type ="submit" value="Добавить товар"/>
</form>
</body>
</html>