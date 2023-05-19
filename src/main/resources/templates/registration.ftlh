<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
<h4>Регистрация</h4>
<form action="/registration" method="post">
  Имя пользователя: <input type="text" name="userName" required><br><br>
  Эл. почта: <input type="email" name="userEmail" required><br><br>
  Номер телефона: <input type="text" name="userPhone"><br><br>
  Пароль: <input type="password" name="password" minlength="8" maxlength="20" required><br><br>
  <input type="hidden" name="_csrf" value="${_csrf.token}">
  <input type="submit" value="Создать аккаунт"/>
</form>
<#if errorMessage??>
  <h2 style ="color: red"> ${errorMessage}</h2>
</#if>
</@t.template>