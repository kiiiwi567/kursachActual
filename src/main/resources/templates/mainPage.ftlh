<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>

    <img src="/static/staticImages/1.jpg" class="img-fluid">
    <br>
    <h2>Категории</h2>
    <br>

    <div class="row">
    <div class="col text-center">
        <a href="/category/1">
            <img
                    src="/static/staticImages/guitarIcon.png"
                    class="img-fluid"
            />
        </a>
        <p><b>Гитары</b></p>
    </div>


    <div class="col text-center">
        <a href="/category/2">
            <img
                    src="/static/staticImages/drumsIcon.png"
                    class="img-fluid"
            />
        </a>
        <p><b>Ударные</b></p>
    </div>

    <div class="col text-center ">
        <a href="/category/3">
            <img
                    src="/static/staticImages/violaIcon.png"
                    class="img-fluid"
            />
        </a>
        <p><b>Струнные</b></p>
    </div>

    <div class="col text-center">
        <a href="/category/4">
            <img
                    src="/static/staticImages/saxIcon.png"
                    class="w-100 shadow-1-strong"
            />
        </a>
        <p><b>Духовые</b></p>
    </div>

    <div class="col text-center">
        <a href="/category/5">
            <img
                    src="/static/staticImages/pianoIcon.png"
                    class="w-100 shadow-1-strong"
            />
        </a>
        <p><b>Клавишные</b></p>
    </div>


<#--<#list category as category>
    <div>
        <p><b><a href="/category/${category.idCateg}"> ${category.categName} </a></b></p>
    </div>
</#list>-->
</@t.template>