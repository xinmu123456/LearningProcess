<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/27
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--通过表单上传文件
    get:上传的文件有大小的限制
    post:上传的文件没有大小的限制
--%>
<form action="/upload.do" method="post" enctype="multipart/form-data"></form>
    上传用户:<input type="text" name="username"> <br>
    <p> <input type="file" name="file1"></p>
    <p> <input type="file" name="file1"></p>

    <p><input type="submit">|<input type="reset"></p>
</body>
</html>
