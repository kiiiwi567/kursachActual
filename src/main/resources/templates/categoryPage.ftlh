<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>

    <section id="services">
        <div class="container text-start" style="margin-top: 40px;">
            <div class="row">
                <div class="col-xxl-3"><h1>${category.categName}</h1></div>
            </div>
        </div>
        <div class="container" style="margin-bottom: 90px;">
            <div class="row">
                <div class="col-xxl-3">
                    <form action="/category/${category.idCateg}" method="get">
                        <p
                                style="margin-bottom: 8px;font-weight: bold;">Поиск по названию:</p><input
                                class="shadow form-control" type="text" name="instName">
                        <button class="btn btn-primary" type="submit"
                                style="margin-top: 14px;font-weight: bold;color: var(--bs-btn-color);">Поиск
                        </button>
                    </form>

                    <form action="/category/${category.idCateg}" method="get">
                        <p style="font-weight: bold;margin-bottom: 0px;margin-top: 14px;">Фильтр по цене:</p>
                        <input
                                class="form-range" type="range" name="minPrice" id="minPrice" min="1" max="10000"
                                oninput="minPriceOut.value = minPrice.value" value="1">
                        <output id="minPriceOut">1</output>
                        <input class="form-range" type="range" name="maxPrice" id="maxPrice" min="1" max="10000"
                               oninput="maxPriceOut.value = maxPrice.value" value="10000">
                        <output id="maxPriceOut">10000</output>
                        <p style="margin-bottom: 0px;font-weight: bold;margin-top: 14px;">Сортировать по:</p>
                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-3" name="sortByName"><label
                                    class="form-check-label" for="formCheck-3">Названию</label></div>
                        <div class="form-check"><input class="form-check-input" type="radio" id="formCheck-4" name="sortByPrice"><label
                                    class="form-check-label" for="formCheck-4">Цене</label></div>
                        <button class="btn btn-primary" type="submit"
                                style="margin-top: 14px;font-weight: bold;color: var(--bs-btn-color);">Фильтр
                        </button>
                    </form
                    >
                </div>

                <div class="col">

                    <div class="row row-cols-3">
                        <#list instrument as instrument>
                            <div class="col">
                                <div class="card" style="padding-right: 0px;margin-right: 0px;">
                                    <div class="card-body"><a
                                                href="/category/${idCateg}/instrument/${instrument.idInst}"><img
                                                    src="/images/${instrument.previewImageId}" width="200" height="200"
                                                    style="margin-right: 103px;margin-bottom: 80px;padding-bottom: 0px;padding-right: 0px;"></a>
                                        <h4 class="card-title" style="margin-top: 19px;">${instrument.instName}</h4>
                                        <p class="card-text" style="font-weight: bold;color: var(--bs-danger);">
                                            ${instrument.instPrice} BYN</p>
                                        <#if userPr.userEmail??>
                                            <form action="/category/${idCateg}/${instrument.idInst}/bucket"
                                                  method="get">
                                                <button class="btn btn-primary" data-bss-hover-animate="pulse"
                                                        type="submit"
                                                        style="color: var(--bs-black);">Добавить в корзину
                                                </button>
                                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                                            </form>
                                        <#else>
                                            <p>Чтобы добавить товар в корзину - авторизуйтесь</p>
                                        </#if>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>

                </div>

            </div>
        </div>
        <#if userPr.isAdmin()>
            <div class="container" style="margin-top: 120px;"><h1 style="margin-bottom: 44px;">Добавить новый
                    инструмент</h1>
                <div class="col">
                    <form action="/category/${category.idCateg}/instrument/create" method="post"
                          enctype="multipart/form-data">
                        <h1 style="font-size: 28px;">Название</h1>
                        <input
                                class="form-control" type="text" name="instName">
                        <p style="font-weight: bold;color: var(--bs-danger);font-size: 27px;margin-bottom: 0px;">
                            Цена</p>
                        <input
                                class="form-control" type="number" style="margin-bottom: 0px;" name="instPrice">
                        <p style="margin-bottom: 0px;">Описание</p><input class="form-control" type="text"
                                                                          style="margin-bottom: 0px;"
                                                                          name="instDescription">
                        <p style="margin-bottom: 0px;">Номер категории</p><input class="form-control" type="number"
                                                                                 style="margin-bottom: 1px;"
                                                                                 name="categoryIdCateg">
                        <p style="margin-bottom: 0px;">Количество</p><input class="form-control" type="number"
                                                                            style="margin-bottom: 0px;"
                                                                            name="instQuantity">
                        <p style="margin-bottom: 8px;margin-top: 8px;">Изображения:</p>
                        <input type="file" name="file1"><input type="file" name="file2"><input type="file"
                                                                                               style="margin-bottom: 0px;"
                                                                                               name="file3">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-primary" data-bss-hover-animate="pulse"
                                type="submit"
                                style="color: var(--bs-black);">Добавить товар
                        </button>
                    </form>
                </div>
            </div>
        </#if>
    </section>
</@t.template>