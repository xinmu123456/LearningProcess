<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我是2</h1>
<hr>
<%--取出参数--%>

名字:<%=request.getParameter("name")%>
<br>
年龄:<%=request.getParameter("age")%>
</body>
</html>
