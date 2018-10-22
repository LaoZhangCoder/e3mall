<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%   String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="/css/public.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
    <script src="/jq/jquery-3.2.1.min.js"></script>
    <script src="/js/js.js"></script>
    <script type="text/javascript">
    function delProFromCart(id){
    	if(confirm("你确定要删除吗？")){		
    		location.href="${pageContext.request.contextPath}/Deletearticle?id="+id;
    	}
    }
    </script>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>神的孩子管理系统</h1>

    <div class="publicHeaderR">
        <p><span style="color: #fff21b"> <%=request.getSession().getAttribute("username")  %></span> , 欢迎你！</p>
        <a href="/shutdown">退出</a>
    </div>
</header>
<!--时间-->

<!--主体内容-->
<section class="publicTime">
 
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="/toaddariticle">发布文章</a></li>
                <li id="active"><a href="javascript:void(0)">管理文章</a></li>
                <li><a href="/Links">友链管理</a></li>
                <li><a href="/password.jsp?updatepassword">密码修改</a></li>
                <li><a href="/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>文章管理页面</span>
        </div>
        <div class="search">
            <span>文章分类：</span>
            <form action="cms/prividerlist2" method="post">
            <input type="text" name="search" placeholder="请输入文章的类别:JAVA or JS"/>
            <input type="submit" value="查询" style="width:100px; height:34px;"/>
            </form>
            <a href="javascript:void(0)">请谨慎操作</a>
        </div>
        <!--供应商操作表格-->
        
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">文章ID</th>
                <th width="20%">文章标题</th>
                <th width="10%">作者</th>
                <th width="10%">类别</th>         
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
         
            </tr>
            <c:forEach items="${list}" var="article">
            <tr>
           
           <td>
           ${article.id }
           </td>
             <td>
           ${article.title }
           </td>
             <td>
           ${article.autor }
           </td>
             <td>
           ${article.category}
           </td>
             <td>
           ${article.date}
           </td>
                <td>  
                   <a href="http://localhost:8080/#/detail/${article.id }"><img src="imgs/read.png" alt="查看" title="查看"/></a>
                    <a href="changearticlecontent?articles_id=${article.id }"> <img src="imgs/xiugai.png" alt="修改" title="修改"/></a>
              <a href="javascript:;" onclick="delProFromCart('${article.id}')" class="removeProvider"><img src="imgs/schu.png" alt="双击删除" title="删除"/></a>

                </td>
            </tr>
   </c:forEach>
        </table>

    </div>
</section>






</body>
</html>