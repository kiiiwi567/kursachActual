<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <hr>
    <h2>Панель администратора</h2>
    <h3>Информация о пользователях</h3>
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
                <th><#if user.isAdmin()>Админ<#else>Клиент</#if></th>
                <th>
                    <#if user.idUser != 1>
                        <form action="/admin/user/ban/${user.idUser}" method="post">
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                            <input type="submit" value="Бан">
                        </form>
                    </#if>
                </th>
                <th>
                    <#if user.idUser != 1>
                    <form action=/admin/user/edit method="post">
                        <input type="hidden" name="idUser" value="${user.idUser}">
                        <button type="submit" name="userRole" value="Редактировние">Редактирование</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                    </#if>
                </th>
                <th><a href="/user/${user.idUser}">Подробная информация</a></th>
            </tr>
        <#else>
            <h3>Пользователей нет</h3>
        </#list>
    </table>
    <br>
    <br>
    <h3>Информация о заказах</h3>
    <table border="1">
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
        <#list orderDetails as orderDetail>
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
                        <button type="submit" name="status" value="${orderDetail.status}">${orderDetail.status}</button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                </td>
            </tr>
        </#list>
    </table>

    <form action="/export/json" method="POST">
        <button type="submit" name="status" value="Экспорт в JSON">Экспорт в JSON</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
    <br>

    <form action="/import/json" method="POST" enctype="multipart/form-data">
        <input type="file" name="file" accept=".json">
        <button type="submit" name="status" value="Импорт из JSON">Импорт из JSON</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@t.template>