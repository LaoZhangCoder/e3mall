<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
<base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>神的孩子网页管理系统</h1>
   
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"><%=request.getSession().getAttribute("username")  %></span> , 欢迎你！</p>
      
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">

    <span>温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</span>
</section>
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                  <li ><a href="/toaddariticle">发布文章</a></li>
                <li><a href="/Mangermentarticles">管理文章</a></li>
                <li><a href="/Links">友链管理</a></li>
                <li><a href="/topassword">密码修改</a></li>
                <li><a href="/shutdown">退出系统</a></li>
            </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <form action="/updatepassword" method="post">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" name="oldPassword" id="oldPassword" required/>
                        <span>*请输入原密码</span>
                    </div>
                     <p style="color:red;margin-left: 200px; margin-top:-10px"></p>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="newPassword" id="newPassword" required/>
                        <span >*请输入新密码</span>
                    </div>
                    <div>
                        <label for="reNewPassword">用户名：</label>
                        <input type="text" name="username" id="reNewPassword" required/>
                        <span >*请输入新确认密码，保证和新密码一致</span>
                    </div>
                       <p style="color:red;margin-left: 200px; margin-top:-10px"></p>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="submit" value="保存"/>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <footer class="footer">
    </footer>
<script src="js/time.js"></script>

</body>
</html>