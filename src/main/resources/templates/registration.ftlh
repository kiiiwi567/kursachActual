<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
        <div class="container text-start" style="margin-top: 40px;">
            <div class="row">
                <div class="col-xxl-3"><h1>Регистрация</h1></div>
            </div>
        </div>
        <form action="/registration" method="post">
            <div class="container" style="margin-bottom: 198px;">
                <div class="row">
                    <div class="col-xxl-3">
                        <form><p style="margin-bottom: 5px;margin-top: 16px;font-weight: bold;">Имя пользователя</p>
                            <input
                                    class="form-control" type="text" style="margin-bottom: 15px;" name="userName"
                                    required>
                            <p style="margin-bottom: 5px;font-weight: bold;">Email</p><input class="form-control"
                                                                                             type="email"
                                                                                             style="margin-bottom: 15px;"
                                                                                             name="userEmail" required>
                            <p style="margin-bottom: 5px;font-weight: bold;">Номер телефона</p><input
                                    class="form-control"
                                    type="tel"
                                    style="margin-bottom: 15px;" name="userPhone"
                                    minlength="7"
                                    maxlength="13" required>
                            <p style="margin-bottom: 5px;font-weight: bold;">Пароль</p><input class="form-control"
                                                                                              type="password"
                                                                                              name="password"
                                                                                              minlength="8"
                                                                                              maxlength="20" required>
                        </form>
                        <button class="btn btn-primary link-dark" type="submit"
                                style="margin-top: 30px;margin-right: -79px;padding-right: 112px;">Зарегистрироваться
                        </button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </div>
                </div>
            </div>
        </form>
    </section>
</@t.template>