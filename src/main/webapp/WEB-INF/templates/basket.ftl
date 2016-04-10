<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
    <#if buckets?has_content>
        <#list buckets as bucket>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${bucket.product.name}</h3>
                </div>
                <div class="panel-body">
                    Итого: ${bucket.product.price} руб. * X <input type="number" placeholder="Количество" id="numberProduct${bucket.id}" value="${bucket.numberProduct}">
                    <button onclick="changeNumberProduct(${bucket.id})">Изменить</button>
                </div>
            </div>
        </#list>
        <#else>
        <h3>Вы еще ничего не добавили в корзину, <a href="/products">перейти к покупкам</a></h3>
    </#if>
    <a href="/bucket/buy" class="btn btn-success btn-block">Оформить заказ</a>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>