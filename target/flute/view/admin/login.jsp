<%--
  Created by IntelliJ IDEA.
  User: xuh
  Date: 2017/4/3
  Time: 9:18
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<shiro:authenticated>
    <%--<%--%>
        <%--response.sendRedirect("/admin/index");--%>
    <%--%>--%>
    <script>
        window.location.href = "/admin/index";
    </script>
</shiro:authenticated>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8" />
    <base href="/" />
    <link href="/images/favicon.ico" rel="shortcut icon">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
    <title>后台登录-浙江长笛网</title>
    <!--Beyond styles-->
    <link id="beyond-link" href="/assets/css/beyond.min.css" rel="stylesheet" />
    <!-- CSS -->
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/form-elements.css">
    <link rel="stylesheet" href="/assets/css/style.css">

    <script src="/js/jquery-1.7.2.min.js"></script>

    <!--Basic Scripts-->
    <script src="/assets/js/bootstrap.min.js"></script>
    <!--Beyond Scripts-->
    <script src="/assets/js/toastr/toastr.js"></script>
    <script src="/assets/js/beyond.min.js"></script>

    <script src="/assets/js/login/jquery.backstretch.min.js"></script>
    <script src="/assets/js/login/scripts.js"></script>
</head>
<style>
    body:before{
        content:none !important;
    }
    #toast-container{
        text-align:left;
        line-height: 20px !important;
    }
</style>

<body>

<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <div class="description">
                        <p>
                            <%--This is a free responsive login form made with Bootstrap.--%>
                            <%--Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!--%>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Login to our site</h3>
                            <p>Enter your username and password to log on</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" method="post" action="/admin/login" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Username</label>
                                <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">Sign in!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

        var msg = '${msg}';
        if(msg == 1){
            Notify('用户名或密码错误!', 'top-right', '3000', 'error', 'fa-warning', true);
        }
</script>
<!-- Javascript -->
</body>
</html>