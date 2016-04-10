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
                    Итого: ${bucket.product.price} руб. * X${bucket.numberProduct}
                </div>
            </div>
        </#list>
        <#else>
        <h3>Вы еще ничего не добавили в корзину, <a href="/products">перейти к покупкам</a></h3>
    </#if>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["css/bucket.css"]/>