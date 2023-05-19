<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <section id="services">
        <div class="container text-start" style="margin-top: 40px;padding-bottom: 0px;">
            <div class="row">
                <div class="col-xxl-6">
                    <div class="simple-slider">
                        <div class="swiper-container">
                            <div class="swiper-wrapper">
                                <#list images as img>
                                    <div class="swiper-slide"
                                         style="background: center center / cover no-repeat;padding-bottom: 0px;margin-bottom: 80px;"></div>
                                    <img src="/images/${img.idImg}">
                                </#list>
                            </div>
                            <div class="swiper-pagination"></div>
                            <div class="swiper-button-prev"></div>
                            <div class="swiper-button-next"></div>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <form action="/category/${idCateg}/instrument/edit/${instrument.idInst}/1" method="post"
                          enctype="multipart/form-data">
                        <h1 style="font-size: 28px;">${instrument.instName}</h1><input class="form-control" type="text"
                                                                                       name="instName">
                        <p style="font-weight: bold;color: var(--bs-danger);font-size: 27px;margin-bottom: 0px;">
                            ${instrument.instPrice}</p><input class="form-control" type="number"
                                                              style="margin-bottom: 0px;"
                                                              name="instPrice">
                        <p style="margin-bottom: 0px;">${instrument.instDescription}</p><input class="form-control"
                                                                                               type="text"
                                                                                               style="margin-bottom: 0px;"
                                                                                               name="instDescription">
                        <p style="margin-bottom: 0px;">${instrument.idCateg}</p><input class="form-control"
                                                                                       type="number"
                                                                                       style="margin-bottom: 1px;"
                                                                                       name="idCateg">
                        <p style="margin-bottom: 0px;">${instrument.instQuantity}</p><input class="form-control"
                                                                                            type="number"
                                                                                            style="margin-bottom: 0px;"
                                                                                            name="instQuantity">
                        <p style="margin-bottom: 8px;margin-top: 8px;">Изображения:</p>
                        <input type="file" name="file1"><input type="file" name="file2"><input type="file"
                                                                                               style="margin-bottom: 0px;"
                                                                                               name="file3">
                        <div class="container" style="margin-bottom: 20px;">
                            <div class="row">
                                <div class="col">
                                    <button class="btn btn-primary" type="submit"
                                            style="color: var(--bs-black);margin-bottom: 22px;font-size: 35px;padding-right: 1077px;margin-right: 0px;text-align: center;">
                                        Сохранить
                                    </button>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                    </form>
                </div>
            </div>
        </div>
    </section>
</@t.template>