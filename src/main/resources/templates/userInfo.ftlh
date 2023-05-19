<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
<h1 style="text-align: center">Информация о пользователе</h1>
<hr>
<div style="text-align: center">
    <img src="/static/images/avatar.png"
         style="border:2px solid black; border-radius: 20px" height="120">
    <br>
    <br>
    <h2>${user.user}</h2>
    <br>
    Номер телефона: <b>${user.userPhone}</b>
    Email: </b> ${user.userEmail}<b
</div>
</@t.template>
