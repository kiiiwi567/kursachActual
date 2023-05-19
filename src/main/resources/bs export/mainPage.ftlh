<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
    <header class="masthead"
            style="background: url(assets/img/header_mainPage.jpg);background-size: cover;filter: brightness(96%);margin-bottom: 0px;">
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in"><span
                            style="text-shadow: 0px 0px 10px var(--bs-gray-dark);filter: brightness(101%);">Даже соседи захотят</span>
                </div>
                <div class="intro-heading text-uppercase"><span style="text-shadow: 0px 0px 20px var(--bs-gray-700);">Чтобы ты играл громче!</span>
                </div>
            </div>
        </div>
    </header>
    <section id="services" style="padding-top: 68px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center"><h2 class="text-uppercase section-heading">Категории</h2>
                    <h3 class="text-muted section-subheading">доступные в нашем магазине</h3></div>
            </div>
            <div class="row text-center">
                <div class="col-md-4"><a href="/category/1"><span class="fa-stack fa-4x"><img
                                    src="assets/img/clients/guitarIcon.png"
                                    style="margin-right: 0px;width: 100px;height: 100px;background: var(--bs-primary);"
                                    width="140" height="135"></span><h4
                                class="section-heading">Гитары</h4>
                        <p class="text-muted" style="margin-bottom: 0px;"><br><span style="color: rgb(30, 30, 30);">Без преувеличения можно сказать, что гитара является одним из самых популярных инструментов в мире</span><br><br>
                        </p></a></div>
                <div class="col-md-4"><a href="/category/2"><span class="fa-stack fa-4x"><img
                                    src="assets/img/clients/drumsIcon.png"
                                    style="width: 100px;background: var(--bs-primary);"></span>
                        <h4 class="section-heading">Ударные</h4>
                        <p class="text-muted"><br><span style="color: rgb(30, 30, 30);">Ударные инструменты являются основой в различных стилях современной музыки. Именно грув, который они создают, заставляет слушателей двигаться в такт</span><br><br>
                        </p></a></div>
                <div class="col-md-4"><a href="/category/3"><span class="fa-stack fa-4x"><img
                                    src="assets/img/clients/violaIcon.png"
                                    style="width: 100px;background: var(--bs-primary);"></span>
                        <h4 class="section-heading">Струнные</h4>
                        <p class="text-muted"><br><span style="color: rgb(30, 30, 30);">Принято считать, что их непосредственным предком является виола – итальянский инструмент, появившийся в XV веке</span><br><br>
                        </p></a></div>
                <div class="col-md-4"><a href="/category/4"><span class="fa-stack fa-4x"><img
                                    src="assets/img/clients/pianoIcon.png"
                                    style="width: 100px;background: var(--bs-primary);"></span>
                        <h4 class="section-heading">Клавишные</h4>
                        <p class="text-muted"><br><span style="color: rgb(30, 30, 30);">Различные клавишные инструменты объединяет одно - способ получения звука путем нажатия на клавиши, которые в свою очередь приводят в действие ту или иную систему звукообразования внутри инструмента</span><br><br>
                        </p></a></div>
                <div class="col-md-4"><a href="/category/2"><span class="fa-stack fa-4x"><img
                                    src="assets/img/clients/saxIcon.png" width="100"
                                    height="100" style="background: var(--bs-primary);"></span>
                        <h4 class="section-heading">Духовые</h4>
                        <p class="text-muted"><br><span style="color: rgb(30, 30, 30);">По своей конструкции большинство из них являются трубками различных форм и устройств. Инструменты духовой группы обладают различными тембрами и заполняют по своим диапазонам все регистры</span>
                        </p></a></div>
            </div>
        </div>
    </section>
</@t.template>