<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我是1</h1>
<jsp:forward page="/jsptag2.jsp">
    <jsp:param name="name" value="xinmu123" />
    <jsp:param name="age" value="20"/>

</jsp:forward>

</body>
</html>
