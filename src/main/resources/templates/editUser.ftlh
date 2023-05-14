<!DOCTYPE html>
<html>
<head>
    <title>editUser ${user.userNickname}</title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
<h3>Редактирование пользователя ${user.userNickname}</h3>
<form action="/admin/user/edit" method="post">
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input type="hidden" value="${user.idUser}" name="userId">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</body>
</html>