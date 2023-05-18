<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
<table border="1">
    <tr>
        <td>Название</td>
        <td>Количество</td>
        <td>Суммарная стоимость</td>
    </tr>
    <#list bucket.bucketDetails as detail>
        <tr>
            <td> ${detail.title}</td>
            <td> ${detail.instQuantity}</td>
            <td> ${detail.sum}</td>
        </tr>
    </#list>
</table>
Общая стоимость заказа: <#if bucket.sum??> ${bucket.sum} <#else> 0 </#if> <br>
<form action="/order/complete" method="post">
Дата доставки: <input type="date" name="orderDelivDate" required/> <br>
Тип доставки:  Доставка<input type="radio" id="Dost" name="orderType" value="Доставка" required><br>
               Самовывоз<input type="radio" id="Samov" name="orderType" value="Самовывоз" required>
    <input type="submit" value="Завершить заказ"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@t.template>