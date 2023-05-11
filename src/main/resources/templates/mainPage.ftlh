<!DOCTYPE html>
<html>
<head>
    <title> mainPageTitle </title>
</head>
<body>
<h1>fuck yeah</h1>
<h2>Категории</h2>
<#list category as category>
    <div>
        <p><b><a href = "/category/${category.idCateg}"> ${category.categName} </a></b></p>
    </div>
</#list>
</body>
</html>