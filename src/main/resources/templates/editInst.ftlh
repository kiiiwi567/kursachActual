<!DOCTYPE html>
<html>
<head>
    <title> editInstPage </title>
</head>
<body>
<h1><a href = "/"> mainFuckingPage </a></h1>
        <hr>
        <h3>Редактировать товар ${instrument.instName}</h3>
        <form action="/category/${idCateg}/instrument/edit/${instrument.idInst}/1" method="post" enctype="multipart/form-data">
            Название: ${instrument.instName} <input type="text" name="instName"/><br><br>
            Цена: ${instrument.instPrice} <input type="number" name="instPrice" /><br><br>
            Категория: ${instrument.idCateg} <input type="number" name="categoryIdCateg" /><br><br>
            Описание: ${instrument.instDescription} <input type="text" name="instDescription" /><br><br>
            Количество товара: ${instrument.instQuantity} <input type="number" name="instQuantity" /><br><br>
            <#list images as img>
                <img src="/images/${img.idImg}" height="100px"/><br><br>
            </#list>
            Главное изображение: <input type="file" name="file1"/><br><br>
            Доп. изображение 1: <input type="file" name="file2"/><br><br>
            Доп. изображение 2: <input type="file" name="file3"/><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type ="submit" value="Редактировать товар"/>
        </form>
</body>
</html>