<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--引入JSTL的核心标签,我们菜鸟使用JSTL标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>if测试</h4>

<hr>

<form action="coreif.jsp" method="get">

<%--
  EL表达式获得表达中的数据
  ${param.参数名}
  --%>
    <input type="text"  name="username" value="${param.username}">
    <input type="submit" value="login">
</form>

<%--判断提交的用户是管理员,则登录成功--%>
<c:if test="${param.username=='admin'}" var="isAdmin" >
    <c:out value="管理员欢迎您"/>
</c:if>
<c:out value="${isAdmin}"/>


<%--<%--%>
<%--    if(request.getParameter("username").equals("admin")){--%>
<%--        out.println("登录成功");--%>
<%--    }--%>
<%--%>--%>

</body>
</html>
