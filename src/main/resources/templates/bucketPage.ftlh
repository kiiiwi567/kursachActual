<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

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
    </tr>
    </#list>
</table>
Общая стоимость товаров в корзине: <#if bucket.sum??> ${bucket.sum} <#else> 0 </#if>
</body>
</html>