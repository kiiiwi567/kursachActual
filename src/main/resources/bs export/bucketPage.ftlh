<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
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
                        <th></th>
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
                            <td>
                                <form action="/bucket/remove/${detail.idInst}" method="post">
                                    <button class="btn btn-primary" type="submit"
                                            style="color: var(--bs-btn-color);">
                                        Убрать
                                    </button>
                                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                                </form>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="row" style="font-size: 35px;font-weight: bold;margin-bottom: 442px;">
                <div class="col-xxl-4"><p>Итоговая стоимость:</p></div>
                <div class="col-xxl-4"><p
                            style="color: var(--bs-danger);"><#if bucket.sum??> ${bucket.sum} <#else> 0 </#if></p></div>
                <#if bucket.sum??>
                    <div class="col">
                    <form action="/order" method="get">
                        <button class="btn btn-primary" type="submit"
                                style="font-size: 30px;padding-right: 82px;color: var(--bs-black);">Оформить заказ
                        </button>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                    </div>
                </#if>
            </div>
        </div>
    </section>
</@t.template>