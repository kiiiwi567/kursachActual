<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title> categoryPage </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<#if user.userEmail??>
    <h3>Имя пользователя: ${user.username}, корзина: <a href="/bucket"> тык</a>
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

<h4>${category.categName}</h4>
<form action="/category/${category.idCateg}" method="get">
    Поиск: <input type="text" name="instName"><br/>
    <div>
        minPrice: <input type="range" name="minPrice" oninput="this.nextElementSibling.value = this.value" min="0" max="9999">
    </div>

    <div>
        maxPrice: <input type="range" name="maxPrice" oninput="this.nextElementSibling.value = this.value" min="1" max="10000">
    </div>
    <p>Сортировать по:</p>
    <div>
        <label><input type="checkbox" name="sortByName"> Названию</label>
        <label><input type="checkbox" name="sortByPrice"> Цене</label>
    </div>
    <input type="submit" value ="Поиск"/>
</form>

<#--<#list instrument as instrument>
    <div>
        <p><b><a href = "${idCateg}/instrument/${instrument.idInst}"> ${instrument.instName} </a></b>${instrument.instPrice} BYN </p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>-->
<table border="1">
    <tr>
        <th>Название</th>
        <th>Цена</th>
        <th></th>
    </tr>
    <#list instrument as instrument>
    <tr>
        <th><a href = "/category/${idCateg}/instrument/${instrument.idInst}"> ${instrument.instName} </a></th>
        <th>${instrument.instPrice} BYN</th>
        <th>
            <form action="/category/${idCateg}/${instrument.idInst}/bucket" method="get">
                <input type ="submit" value="Добавить в корзину"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </th>
    </tr>
    </#list>
</table>

<#if user.isAdmin()>
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