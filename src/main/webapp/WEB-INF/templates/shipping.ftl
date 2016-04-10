<#include "main-template.ftl"/>
<#macro m_body>
<div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Доставка</h3>
                </div>
                <div class="panel-body">
                    <form class="form-signin form-block" id="registration-form" role="form" action="/registration" method="post">
                        <h2 class="form-signin-heading">Регистрация</h2>
                        <input type="login" class="form-control" name="login" id="login" placeholder="Логин" required autofocus>
                        <span class="error" id="loginExists">Логин занят</span>
                        <input type="password" name="password" id="password" class="form-control" placeholder="Пароль" required>
                        <input type="password" name="confirmPassword" id="confirm-password" class="form-control" placeholder="Пароль" required>
                        <span class="error" id="passwordNotEqual">Пароли не совпадают</span>
                        <button class="btn btn-lg btn-primary btn-block">Регистрация</button>
                    </form>
                </div>
            </div>
    <a href="/bucket/buy" class="btn btn-success btn-block">Купить</a>
</div> <!-- /container -->

</#macro>
<@main title="Корзина" customStyles=["/css/bucket.css"] customScripts=["/js/bucket.js"]/>