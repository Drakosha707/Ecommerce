<#include "main-template.ftl"/>
<#macro m_body>
    <div class="container product-panel">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Shop Name</p>
                <div class="list-group">
                <#if categories?has_content>
                    <#list categories as category>
                        <a href="/products?category=${category.id}" class="list-group-item">${category.name}</a>
                    </#list>
                </#if>
                </div>
            </div>

            <div class="col-md-9">

                <div class="row">
                   <#if products?has_content>
                       <#list products as product>
                           <div class="col-sm-4 col-lg-4 col-md-4">
                               <div class="thumbnail">
                                   <div class="caption">
                                       <h4 class="pull-right">${product.price}</h4>
                                       <h4><a href="/products/detail?id=${product.id}">${product.name}</a>
                                       </h4>
                                       <p>${product.description}</p>
                                   </div>
                                   <button class="btn btn-default btn-block">В корзину</button>
                               </div>
                           </div>
                       </#list>
                   </#if>
                </div>
            </div>
        </div>
    </div>
</#macro>
<@main title="Вход" customStyles=["css/shop-homepage.css"]/>