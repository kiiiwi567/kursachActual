<#macro template userPr>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <title>Home - Brand</title>
        <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="/static/css/styles.min.css">
    </head>
    <body id="page-top" data-bs-spy="scroll" data-bs-target="#mainNav" data-bs-offset="54">
    <nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-dark" id="mainNav">
        <div class="container">
            <a class="navbar-brand" href="/"
               style="font-family: Anton, sans-serif;">&nbsp;<img
                        src="/static/img/mainLogo.png"
                        style="width: 50px;padding-top: 0px;padding-bottom: 0px;margin-bottom: 9px;">&nbsp;VolumeUp!</a>
            <#if userPr.userEmail??>
                <#if userPr.isAdmin()>
                    <button class="btn btn-primary" type="button" style="color: var(--bs-black);"
                            onclick="window.location.href = '/adminPage'">Панель администратора
                    </button>
                </#if>
                <a href="/bucket">
                    <img src="/static/img/cartIcon.png"
                         width="32" height="32" class="rounded">
                </a>
                <a href="/user/profile">
                    <img src="/static/img/userIcon.png"
                         width="32" height="32" class="rounded-circle">
                </a>
            <#else>
                <button class="btn btn-primary" type="button" style="color: var(--bs-btn-disabled-color); "
                        onclick="window.location.href = '/login'">Войти
                </button>
            </#if>
        </div>
    </nav>
    <#nested/>
    <footer class="text-center" style="color: var(--bs-gray-300);background: var(--bs-gray-dark);">
        <div class="container">
            <div class="row">
                <div class="col-md-4"><span class="copyright">Интернет-магазин VolumeUp!</span></div>
                <div class="col-md-4">
                    <ul class="list-inline social-buttons">
                        <li class="list-inline-item"></li>
                        <li class="list-inline-item"></li>
                        <li class="list-inline-item"></li>
                    </ul>
                </div>
                <div class="col-md-4"><span class="copyright">Разработка: Михновец А.Ю.</span></div>
            </div>
        </div>
    </footer>
    <script src="/static/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/js/script.min.js"></script>
    </body>
    </html>
</#macro>