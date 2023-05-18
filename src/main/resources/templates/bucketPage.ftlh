<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
<table border="1">
    <tr>
        <td>Название</td>
        <td>Цена за 1шт.</td>
        <td>Количество</td>
        <td>Суммарная стоимость</td>
        <td></td>
    </tr>
    <#list bucket.bucketDetails as detail>
        <tr>
            <td> ${detail.title}</td>
            <td> ${detail.instPrice}</td>
            <td> ${detail.instQuantity}</td>
            <td> ${detail.sum}</td>
            <td>
                <form action="/bucket/remove/${detail.idInst}" method="post">
                    <input type="submit" value="Убрать"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            </td>
        </tr>
    </#list>
</table>
Общая стоимость товаров в корзине: <#if bucket.sum??> ${bucket.sum} <#else> 0 </#if>

<form action="/order" method="get">
    <input type="submit" value="Оформить заказ"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@t.template>