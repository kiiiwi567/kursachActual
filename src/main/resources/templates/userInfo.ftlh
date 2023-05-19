<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
        <div class="container text-start" style="margin-top: 40px;">
            <div class="row">
                <div class="col-xxl-4"><img src="/static/img/userIcon.png"
                                            height="120">
                    <h1></h1></div>
            </div>
            <div class="row">
                <div class="col-xxl-4"><h1>${user.userEmail}</h1></div>
            </div>
        </div>
        <div class="container" style="margin-bottom: 394px;">
            <div class="row">
                <div class="col-xxl-3" style="font-size: 27px;">
                    <form><p style="margin-bottom: 5px;margin-top: 16px;font-weight: bold;font-size: 27px;">Имя
                            пользователя:</p>
                        <p style="margin-bottom: 5px;font-weight: bold;font-size: 27px;">Email:</p>
                        <p style="margin-bottom: 5px;font-weight: bold;">Номер телефона:</p></form>
                </div>
                <div class="col-xxl-3" style="font-size: 27px;">
                    <form><p style="margin-bottom: 5px;margin-top: 16px;font-weight: bold;font-size: 27px;">
                            ${user.userNickname}</p>
                        <p style="margin-bottom: 5px;font-weight: bold;font-size: 27px;">${user.userEmail}</p>
                        <p style="margin-bottom: 5px;font-weight: bold;">${user.userPhone}</p></form>
                </div>
                <#if userPr.idUser = user.idUser>
                    <div class="row">
                        <form form action="/logout" method="post">
                            <button class="btn btn-primary" type="submit"
                                    style="color: var(--bs-btn-color);">Выйти из аккаунта
                            </button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    </div>
                </#if>
            </div>
        </div>
    </section>
</@t.template>