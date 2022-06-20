<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/22
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%-- jsp 表达式
作用:用来将程序的输出,输出到客户端
<%= (变量或者表达式)%>
--%>
<%= new Date()%>

<hr>

<%--jsp脚本片段--%>
<%
    int sum=0;
    for (int i = 0; i < 100; i++) {
        sum+=i;
    }
    out.println("<h1>sum="+sum+"</h1>");
%>

<%
    int x=10;
    out.println(x);
%>
<p>这是一个jsp文本</p>
<%
    int y=20;
    out.println(y);
%>
<hr>

<%--在代码中嵌入html元素--%>
<% for (int i = 0; i < 5; i++) { %>
<h1>hello world  <%= i%></h1>
<% }                             %>

<hr>

<%!
    static{
        System.out.println("loading servlet");
    }
    private int globalVar=0;
    public void xinmu(){
        System.out.println("进入了xinmu的方法");
        System.out.println("globalVar="+globalVar);
    }
%>

</body>
</html>
