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
        <p><b> ${instrument.instName} </b> ${instrument.instPrice} BYN <a href = "/instrument/${instrument.idInst}"> Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/instrument/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="instName"/><br><br>
    Цена: <input type="number" name="instPrice"/><br><br>
    Категория: <input type="number" name="categoryIdCateg"/><br><br>
    Описание: <input type="text" name="instDescription"/><br><br>
    Количество товара: <input type="number" name="instQuantity"/><br><br>
    Главное изображение: <input type="file" name="file1"/><br><br>
    Доп. изображение 1: <input type="file" name="file2"/><br><br>
    Доп. изображение 2: <input type="file" name="file3"/><br><br>
    Автор: <input type="text" name="author"/><br><br>
    <input type ="submit" value="Добавить товар"/>
</form>
</body>
</html>