<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
        <div class="container text-start" style="margin-top: 40px;">
            <div class="row">
                <div class="col-xxl-3"><h1>Авторизация</h1></div>
            </div>
        </div>

        <div class="container" style="margin-bottom: 318px;">
            <div class="row">
                <div class="col-xxl-3">
                    <form action="/login" method="post">
                        <p style="margin-bottom: 5px;">Email</p><input
                                class="shadow form-control d-xxl-flex justify-content-xxl-start" type="email"
                                required=""
                                style="margin-bottom: 22px;padding-right: 11px;" name="username">
                        <p style="margin-bottom: 5px;">Пароль</p><input class="shadow form-control" type="password"
                                                                        name="password">
                        <button class="btn btn-primary link-dark" type="submit"
                                style="margin-top: 30px;margin-right: -66px;padding-right: 154px;">Войти в аккаунт
                        </button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                    <a href="/registration">
                        <button class="btn btn-primary link-dark" type="button"
                                style="margin-top: 28px;padding-right: 11px;margin-right: -150px;margin-bottom: 18px;padding-bottom: 6px;">
                            Нет аккаунта? Зарегистрируйся!
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </section>
</@t.template>