<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%   String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<base href="<%=basePath%>">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>系统登录 - 神的孩子管理系统</title>
    <link rel="stylesheet" href="/css/style.css"/>
    <style>
 .login_bg {
    background: url("./imgs/loginBg.jpg") 0 0 repeat-x;
}

.loginBox {
    width: 1000px;
    margin: 0 auto;
    background: url("./imgs/login_bg.jpg") 0 0 no-repeat;
}

.loginHeader {
    padding-top: 102px;
    text-align: center;
    padding-bottom: 30px;
}
    </style>
</head>
<body class="login_bg">

    <div class="loginBox">
        <div class="loginHeader">
            <h1>神的孩子网站管理系统</h1>
        </div>
       
        <div class="loginCont">
            <form class="loginForm" action="/tologin" method="post">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                 <span style="color: red;float: left;position: absolute;">${msg}</span> 
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
              
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                   
                </div>

            </form>
          
        </div>
    </div>

</body>
</html>
