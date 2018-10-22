<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
      <link rel="stylesheet" href="/kindeditor-4.1.10/themes/default/default.css" />
    <script src="/jq/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/kindeditor-4.1.10/lang/zh_CN.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<div style="background-image: url('${pageContext.request.contextPath}/imgs/4.jpg');">

<form action="Changearticles?id=${article.id }" method="post" class="form-horizontal" role="form">
<label class="radio-inline" style="margin-left:50%">选择分类:</label>
 <label class="radio-inline">
      <input type="radio" name="Category" value="JAVA"  checked="checked">JAVA
    </label>
 
<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  value="${article.title }"  name="title" required id="title" placeholder="请输入您的文章标题" maxlength="40" width="200">
    </div>
    <p style="margin-left: 40%">请对你想修改的内容进行操作</p>
  </div>
<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">标签</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="${article.tag }" name="tag" required id="title" placeholder="请输入您的文章标签" maxlength="40" width="200">
    </div>
    <p style="margin-left: 40%">JAVA,多线程(以逗号分隔)</p>
  </div>
<div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">作者:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="autor" value="${article.autor }" placeholder="请输入您的名字">
    </div>
  </div>
    <h3 style="margin-left: 20%;color: red">添加内容:注意格式的排版，你在编辑器里什么格式，在网页呈现的就是这个格式！</h3>
    <div style="margin-left:25%">
   
    <textarea style="visibility:hidden;display: block;" id="editor_id" name="content" >${article.content }</textarea> 
    </div>
    <input type="submit"  style="width: 500px;height: 80px;margin-left:35%; color: orange;" value="修改文章">
</form>

</div>
 

<script type="text/javascript">
var editor;
KindEditor.ready(function(K) {
    editor = K.create('textarea[name="content"]', {
        allowFileManager : true
    });
    editor.sync();

    K('input[name=getHtml]').click(function(e) {
        alert(editor.html());
    });
    K('input[name=isEmpty]').click(function(e) {
        alert(editor.isEmpty());
    });
    K('input[name=getText]').click(function(e) {
        alert(editor.text());
    });
    K('input[name=selectedHtml]').click(function(e) {
        alert(editor.selectedHtml());
    });
    K('input[name=setHtml]').click(function(e) {
        editor.html('<h3>Hello KindEditor</h3>');
    });
    K('input[name=setText]').click(function(e) {
        editor.text('<h3>Hello KindEditor</h3>');
    });
    K('input[name=insertHtml]').click(function(e) {
        editor.insertHtml('<strong>插入HTML</strong>');
    });
    K('input[name=appendHtml]').click(function(e) {
        editor.appendHtml('<strong>添加HTML</strong>');
    });
    K('input[name=clear]').click(function(e) {
        editor.html('');
    });
});
</script>



</body>
</html>