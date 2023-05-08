<!DOCTYPE html>
<html>
<head>
    <title> mainPageTitle </title>
</head>
<body>
<h1>fuck yeah</h1>
<h4>товары товарчики</h4>
<#list instrument as instrument>
    <div>
        <p><b> ${instrument.name} </b> ${instrument.price} BYN <a href = "/instrument/${instrument.ID}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/instrument/create" method="post">
    Название: <input type="text" name="name"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Категория: <input type="number" name="category"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    <input type ="submit" value="Добавить товар"/>
</form>
</body>
</html>