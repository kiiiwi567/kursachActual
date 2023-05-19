<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
        <div class="container text-start" style="margin-top: 40px;">
            <div class="row">
                <div class="col-xxl-6">
                    <div class="row row-cols-3">
                        <#list images as img>
                            <img src="/images/${img.idImg}" height="200px"/><br><br>
                        </#list>
                    </div>
                </div>
                <div class="col"><h1>${instrument.instName}</h1>
                    <p style="font-weight: bold;color: var(--bs-danger);font-size: 30px;">${instrument.instPrice} BYN</p>
                    <p>${instrument.instDescription}</p>
                    <#if userPr.userEmail??>
                        <form action="/category/${idCateg}/${instrument.idInst}/bucket"
                              method="get">
                            <button class="btn btn-primary" type="submit"
                                    style="color: var(--bs-black);margin-bottom: 22px;">
                                Добавить в корзину
                            </button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    <#else>
                        <p>Чтобы добавить товар в корзину - авторизуйтесь</p>
                    </#if>

                </div>
            </div>
        </div>
        <#if userPr.isAdmin()>
            <div class="container" style="margin-bottom: 20px;">
                <div class="row">
                    <div class="col-xxl-2" style="text-align: left;font-weight: bold;font-size: 29px;"><p>Добавил:</p>
                    </div>
                    <div class="col" style="padding-left: 10px;font-weight: bold;font-size: 27px;"><p
                                style="font-size: 29px;">
                            ${instrument.user.username}</p></div>
                </div>
                <div class="row">
                    <div class="col-xxl-6">
                        <form action="edit/${instrument.idInst}" method="post">
                            <button class="btn btn-primary" type="submit"
                                    style="margin-right: 12px;color: var(--bs-btn-disabled-color);padding-right: 460px;">
                                Редактировать
                            </button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    </div>
                    <div class="col">
                        <form action="delete/${instrument.idInst}" method="post">
                            <button class="btn btn-primary" type="submit"
                                    style="background: var(--bs-red);margin-right: 0px;padding-right: 540px;">Удалить
                            </button>
                            <input type="hidden" name="_csrf" value="${_csrf.token}">
                        </form>
                    </div>
                </div>
            </div>
        </#if>
    </section>
</@t.template>
