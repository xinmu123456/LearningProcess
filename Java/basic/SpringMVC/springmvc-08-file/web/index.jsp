<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/4/9
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="upload">

    <a href="/download">点击下载</a>
  </form>
  </body>
</html>
