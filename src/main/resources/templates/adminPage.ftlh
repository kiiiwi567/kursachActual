<!DOCTYPE html>
<html>
<head>
    <title>adminPage</title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Имя</th>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.userNickname}</th>
            <th>${user.userEmail}</th>
            <th>${user.userPhone}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.idUser}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.idUser}">Редактировние</a></th>
            <th><a href="/user/${user.idUser}">Подробная информация</a></th>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
</body>
</html>