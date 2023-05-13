<!DOCTYPE html>
<html>
<head>
    <title> categoryPage </title>
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

<h4>${category.categName}</h4>
<form action="/category/${category.idCateg}" method="get">
    Поиск: <input type="text" name="instName"><br/>
    <input type="submit" value ="Поиск"/>
</form>
<#list instrument as instrument>
    <div>
        <p><b><a href = "${idCateg}/instrument/${instrument.idInst}"> ${instrument.instName} </a></b>${instrument.instPrice} BYN </p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>

<#if user.email??>
    <hr>
    <h3>Создать новый товар</h3>
    <form action="/category/${category.idCateg}/instrument/create" method="post" enctype="multipart/form-data">
        Название: <input type="text" name="instName"/><br><br>
        Цена: <input type="number" name="instPrice"/><br><br>
        Категория: <input type="number" name="categoryIdCateg"/><br><br>
        Описание: <input type="text" name="instDescription"/><br><br>
        Количество товара: <input type="number" name="instQuantity"/><br><br>
        Главное изображение: <input type="file" name="file1"/><br><br>
        Доп. изображение 1: <input type="file" name="file2"/><br><br>
        Доп. изображение 2: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type ="submit" value="Добавить товар"/>
    </form>
</#if>

</body>
</html>