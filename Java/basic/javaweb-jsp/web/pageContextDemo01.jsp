<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/3/23
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--内置对象--%>

<%
    pageContext.setAttribute("name1","xinmu1");//保存的数据只在一个页面中有效
    request.setAttribute("name2","xinmu2");//保存的数据只在一次请求中有效,请求转发会携带这个数据
    session.setAttribute("name3","xinmu3");//保存的数据只在一次会话中有效,从打开浏览器到关闭浏览器
    application.setAttribute("name4","xinmu4");//保存的数据在服务器中有效,从服务器打开到服务器关闭
%>


<%--脚本片段中的代码,会被原封不动的生成到jsp.java
  要求:这里面的代码,必须要保证java代码的正确性
--%>
<%
    //通过pageContext取出我们保存的值,我们通过寻找的方式来
    //从底层到高层 page->request->session->application
    String name1 =(String) pageContext.findAttribute("name1");
    String name2 =(String) pageContext.findAttribute("name2");
    String name3 =(String) pageContext.findAttribute("name3");
    String name4 =(String) pageContext.findAttribute("name4");
    String name5 =(String) pageContext.findAttribute("name5");  //不存在

    pageContext.forward("/pageDemo02.jsp");
%>

<%--使用EL表达式输出--%>
<h1>取出的值为:</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3><%=name5%></h3>
</body>
</html>
