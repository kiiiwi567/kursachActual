<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
<h4>Авторизация</h4>
<form action="/login" method="post">
    Эл. почта: <input type="email" name="username" required><br><br>
    Пароль: <input type="password" name="password" requered><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<p>Нет аккаунта? <a href="/registration">Зарегистрируйся!</a>
</@t.template>