<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    editUser ${user.userNickname}

    <h1><a href="/"> mainFuckingPage </a></h1>
    <h3>Редактирование пользователя ${user.userNickname}</h3>
    <form action="/admin/user/edit" method="post">
        <#list roles as role>
            <div>
                <label><input type="checkbox"
                              name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.idUser}" name="idUser">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit">Сохранить</button>
    </form>
</@t.template>