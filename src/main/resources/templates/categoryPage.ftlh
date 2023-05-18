<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>

    <h4 xmlns="http://www.w3.org/1999/html">${category.categName}</h4>
    <form action="/category/${category.idCateg}" method="get">
        Поиск: <input type="text" name="instName">
        <br>
        <p>Фильтровать по цене</p>
        <br>
        От:
        <div class="slidecontainer">
             <input type="range" name="minPrice" id="minPrice" min="1" max="10000" oninput="minPriceOut.value = minPrice.value">
        </div> <output id="minPriceOut">0</output>
        До:
        <div class="slidecontainer">
            <input type="range" name="maxPrice" id="maxPrice" min="1" max="10000" oninput="maxPriceOut.value = maxPrice.value">
        </div> <output id="maxPriceOut">0</output>
        <br>
        <p>Сортировать по:</p>
        <div>
            <label><input type="checkbox" name="sortByName"> Названию</label>
            <label><input type="checkbox" name="sortByPrice"> Цене</label>
        </div>
        <input type="submit" value="Поиск"/>
    </form>

<#--<#list instrument as instrument>
    <div>
        <p><b><a href = "${idCateg}/instrument/${instrument.idInst}"> ${instrument.instName} </a></b>${instrument.instPrice} BYN </p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>-->
<#--<div class="card-columns">
    <#list instrument as instrument>

        <a href="/category/${idCateg}/instrument/${instrument.idInst}" class="product-link"> ${instrument.instName}
            ${instrument.instPrice} BYN

            <#if userPr.userEmail??>
                <form action="/category/${idCateg}/${instrument.idInst}/bucket" method="get">
                    <input type="submit" value="Добавить в корзину"/>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            <#else>
                Чтобы добавить товар в корзину - авторизуйтесь
            </#if>
        </a>
    </#list>
</div>-->


    <#--<#list instrument as instrument>
        <div class="row row-cols-3 row-cols-md-3 g-4">
        <div class="card text-white bg-dark my-3 product">
        <a href="/category/${idCateg}/instrument/${instrument.idInst}" class="product-link">
            <img class="card-img-top" src="/images/${instrument.previewImageId}">
        </a>
        <div class="card-body">
            <h5 class="card-title">${instrument.instName}</h5>
            <p class="card-text">${instrument.instPrice} BYN</p>
            <#if userPr.userEmail??>
                <form action="/category/${idCateg}/${instrument.idInst}/bucket" method="get">
                    <button type="submit" class="btn btn-outline-warning">Добавить в корзину</button>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </form>
            <#else>
                <p>Чтобы добавить товар в корзину - авторизуйтесь</p>
            </#if>
        </div>
    <#else>
        <h1 style="text-align: center">Не найдено</h1>
        </div>
        </div>
    </#list>-->

    <div class="card-columns">
        <#list instrument as instrument>
            <a href="/category/${idCateg}/instrument/${instrument.idInst}" class="product-link">
                <div class="card text-white bg-dark my-3 product">

                    <img src="/images/${instrument.previewImageId}"
                         class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${instrument.instName}</h5>
                        <p class="card-text">${instrument.instPrice} BYN</p>
                        <#if userPr.userEmail??>
                            <form action="/category/${idCateg}/${instrument.idInst}/bucket" method="get">
                                <button type="submit" class="btn btn-outline-warning">Добавить в корзину</button>
                                <input type="hidden" name="_csrf" value="${_csrf.token}">
                            </form>
                        <#else>
                            <p>Чтобы добавить товар в корзину - авторизуйтесь</p>
                        </#if>
                    </div>

                </div>
            </a>
        <#else>
            <h1 style="text-align: center">Не найдено</h1>
        </#list>
    </div>


    <#if userPr.isAdmin()>
        <hr>
        <h3>Создать новый товар</h3>
        <form action="/category/${category.idCateg}/instrument/create" method="post" enctype="multipart/form-data">
            Название: <input type="text" name="instName"/><br><br>
            Цена: <input type="number" name="instPrice"/><br><br>
            Категория: <input type="number" name="categoryIdCateg"/><br><br>
            Описание: <input type="text" name="instDescription"/><br><br>
            Количество товара: <input type="number" name="instQuantity"/><br><br>
            Главное изображение: <input type="file" name="file1"/><br><br>
            Доп. изображение 1: <input type="file" name="file2"/><br><br>
            Доп. изображение 2: <input type="file" name="file3"/><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Добавить товар"/>
        </form>
    </#if>

</@t.template>