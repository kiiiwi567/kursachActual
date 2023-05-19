<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services" style="color: var(--bs-black);">
        <div class="container justify-content-center align-content-center">
            <div class="table-responsive justify-content-center align-content-center"
                 style="margin-bottom: 8px;padding-bottom: 0px;">
                <table class="table">
                    <thead style="font-size: 15px;">
                    <tr class="fs-4 text-center" style="font-size: 24px;">
                        <th>Изображение</th>
                        <th>Название</th>
                        <th>Цена</th>
                        <th>Количество</th>
                        <th>Суммарная стоимость</th>
                    </tr>
                    </thead>
                    <tbody class="justify-content-center align-content-center" style="font-size: 22px;">
                    <#list bucket.bucketDetails as detail>
                        <tr class="text-center justify-content-center align-content-center">
                            <td><img src="/images/${detail.previewImgId}" class="d-xxl-flex" width="150" height="150">
                            </td>
                            <td>${detail.title}</td>
                            <td>${detail.instPrice}</td>
                            <td>${detail.instQuantity}</td>
                            <td>${detail.sum}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="row" style="font-size: 35px;font-weight: bold;margin-bottom: 18px;">
                <div class="col-xxl-4"><p>Итоговая стоимость:</p></div>
                <div class="col-xxl-4"><p style="color: var(--bs-danger);">${bucket.sum}</p></div>
            </div>
        </div>
        <div class="container" style="margin-top: 36px;margin-bottom: 44px;">
            <form action="/order/complete" method="post">
                <div class="row">
                    <div class="col-xxl-3"><p style="font-size: 36px;">Дата доставки:</p></div>
                    <div class="col"><input class="form-control" type="date" style="font-size: 30px;"
                                            name="orderDelivDate" required></div>
                </div>
                <div class="row" style="margin-bottom: 40px;">
                    <div class="col-xxl-3"><p style="font-size: 36px;">Тип доставки:</p></div>
                    <div class="col-xxl-2" style="font-size: 23px;text-align: left;">
                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-1"
                                                       name="orderType" value="Доставка" required><label
                                    class="form-check-label" for="formCheck-1">Доставка</label></div>
                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-2"
                                                       name="orderType" value="Самовывоз" required><label
                                    class="form-check-label" for="formCheck-2">Самовывоз</label></div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit"
                        style="font-size: 34px;padding-right: 968px;color: var(--bs-gray-900);">Оформить заказ
                </button>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </form>
        </div>
    </section>
</@t.template>