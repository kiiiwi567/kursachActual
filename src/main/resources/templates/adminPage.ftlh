<!DOCTYPE html>
<html>
<head>
    <title>adminPage</title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
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
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <#if user.idUser != 1><form action="/admin/user/ban/${user.idUser}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form></#if>
            </th>
            <th><#if user.idUser != 1><a href="/admin/user/edit/${user.idUser}">Редактировние </#if></a></th>
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
</body>
</html>