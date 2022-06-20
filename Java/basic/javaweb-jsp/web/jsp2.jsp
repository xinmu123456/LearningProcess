<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--定制错误页面--%>
<%@ page errorPage="error/500.jsp" %>

<%--显示声明这是一个错误的页面--%>
<%@ page isErrorPage="true" %>
<%@ page pageEncoding="UTF-8" %>

<html>


<head>
    <title>Title</title>
</head>
<body>
<%
    int x=1/0;
%>

</body>
</html>
