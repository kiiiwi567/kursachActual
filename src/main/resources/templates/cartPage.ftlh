<!DOCTYPE html>
<html>
<head>
    <title> ${instrument.instName} Info </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<#if user.userEmail??>
<h3>Имя пользователя: ${user.username}
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
</h3>
<h2>Ваша корзина</h2>

<table border="0">
    <tr>
        <th>Пикча</th>
        <th>Название</th>
        <th>Цена за 1шт.</th>
        <th>Количество</th>
    </tr>
    <#list cartPos as cartPos>
        <tr>
            <th><img src="/images/${img.idImg}" height="100px"/><br><br></th>
            <th>${inst.instName}</th>
            <th>${inst.instPrice}</th>
            <th>${cartPos.cartposInstQuantity} <input type="number" name="cartposInstQuantity" value=${cartPos.cartposInstQuantity}/><br><br></th>
        </tr>
    <#else>
        <h3>Товаров нет</h3>
    </#list>
</table>

</body>
</html>