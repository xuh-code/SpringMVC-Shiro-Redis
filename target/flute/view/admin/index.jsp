<%--
  Created by IntelliJ IDEA.
  User: xuh
  Date: 2017/4/3
  Time: 11:22
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>首页-浙江长笛网</title>
<base href="/"/>
</head>
<body>

    用户名:<shiro:principal/>
    <h4>SUCCESS</h4>

</body>
</html>