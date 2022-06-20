<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@include 会将两个页面合二为一--%>
    <%@include file="common/header.jsp"%>
    <h1>网页主体</h1>
    <%@include file="common/footer.jsp"%>

    <hr>

    <%--jsp标签
    jsp:include 拼接页面.本质还是三个,里面定义的变量互不影响
    <%@include file="common/header.jsp"%>这种方式相当于嵌入,还是会影响
    --%>
    <jsp:include page="/common/header.jsp"/>
    <jsp:include page="/common/footer.jsp"/>


</body>
</html>
