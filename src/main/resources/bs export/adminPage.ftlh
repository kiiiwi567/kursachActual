<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services" style="color: var(--bs-black);">
        <div class="container" style="margin-top: 36px;margin-bottom: 44px;"><h1 style="margin-bottom: 16px;">Список
                пользователей</h1>
            <div class="table-responsive text-center">
                <table class="table">
                    <thead style="font-size: 20px;">
                    <tr>
                        <th>Имя</th>
                        <th>Email</th>
                        <th>Номер телефона</th>
                        <th>Активность</th>
                        <th>Роли</th>
                        <th>Бан</th>
                        <th>Изменить роль</th>
                        <th>Ссылка на профиль</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list users as user>
                        <tr>
                            <td>${user.userNickname}</td>
                            <td>${user.userEmail}</td>
                            <td>${user.userPhone}</td>
                            <td><#if user.active>true<#else>false</#if></td>
                            <td><#if user.isAdmin()>Админ<#else>Клиент</#if></td>
                            <td>
                                <#if user.idUser != 1>
                                    <form action="/admin/user/ban/${user.idUser}" method="post">
                                        <button class="btn btn-primary" type="submit"
                                                style="color: var(--bs-btn-color);">
                                            Бан
                                        </button>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    </form>
                                </#if>
                            </td>
                            <td>
                                <#if user.idUser != 1>
                                    <form action=/admin/user/edit method="post">
                                        <input type="hidden" name="idUser" value="${user.idUser}">
                                        <button class="btn btn-primary" type="submit"
                                                style="color: var(--bs-btn-color);padding-right: 39px;padding-left: 40px;">
                                            Изменить
                                        </button>
                                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                                    </form>
                                </#if>
                            </td>
                            <td>
                                <form action=/user/${user.idUser} method="post">
                                    <button class="btn btn-primary" type="submit"
                                            style="color: var(--bs-btn-color);padding-left: 71px;padding-right: 77px;">
                                        Ссылка
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container" style="margin-bottom: 104px;"><h1 style="margin-bottom: 16px;">Список заказов</h1>
            <div class="table-responsive text-center" style="margin-bottom: 28px;">
                <table class="table">
                    <thead style="font-size: 20px;">
                    <#list orderDetails as orderDetail>
                    <tr>
                        <th>Email</th>
                        <th>Номер телефона</th>
                        <th>Дата заказа</th>
                        <th>Дата доставки</th>
                        <th>Сумма заказа</th>
                        <th>Тип доставки</th>
                        <th>Инструменты</th>
                        <th>Статус</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDetail.userEmail}</td>
                        <td>${orderDetail.userPhone}</td>
                        <td>${orderDetail.orderCrDate}</td>
                        <td>${orderDetail.orderDelivDate}</td>
                        <td>${orderDetail.orderSum}</td>
                        <td>${orderDetail.orderType}</td>
                        <td>${orderDetail.orderInstList?join(", ")}</td>
                        <td>
                            <form action="/updateOrderStatus" method="POST">
                                <input type="hidden" name="orderId" value="${orderDetail.idOrder}">
                                <button class="btn btn-primary" type="submit" style="color: var(--bs-btn-color);">Статус
                                </button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </form>
                        </td>
                    </tr>
                    <tr></tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container" style="margin-bottom: 162px;">
            <form action="/export/json" method="POST">
                <button class="btn btn-primary" type="button"
                        style="padding-right: 108px;margin-right: 70px;color: var(--bs-btn-color);">Экспорт в JSON
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>

            <button class="btn btn-primary" type="button"
                    style="padding-right: 108px;margin-right: 90px;color: var(--bs-btn-color);">Импорт в JSON
            </button>

            <form action="/wordreport" method="POST">
                <button class="btn btn-primary" type="button"
                        style="padding-right: 108px;margin-right: 70px;color: var(--bs-black);">Отчёт Word
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </div>
    </section>
</@t.template>