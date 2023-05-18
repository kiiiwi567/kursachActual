<#import "TEMPLATE.ftlh" as t>
<@t.template userPr>
        <h3>Редактировать товар ${instrument.instName}</h3>
        <form action="/category/${idCateg}/instrument/edit/${instrument.idInst}/1" method="post" enctype="multipart/form-data">
            Название: ${instrument.instName} <input type="text" name="instName" value="${instrument.instName}"/><br><br>
            Цена: ${instrument.instPrice} <input type="number" name="instPrice" value=${instrument.instPrice}/><br><br>
            Категория: ${instrument.idCateg} <input type="number" name="idCateg" value=${instrument.idCateg}/><br><br>
            Описание: ${instrument.instDescription} <input type="text" name="instDescription" value="${instrument.instDescription}"/><br><br>
            Количество товара: ${instrument.instQuantity} <input type="number" name="instQuantity" value=${instrument.instQuantity}/><br><br>
            <#list images as img>
                <img src="/images/${img.idImg}" height="100px"/><br><br>
            </#list>
            Главное изображение: <input type="file" name="file1"/><br><br>
            Доп. изображение 1: <input type="file" name="file2"/><br><br>
            Доп. изображение 2: <input type="file" name="file3"/><br><br>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type ="submit" value="Редактировать товар"/>
        </form>
</@t.template>