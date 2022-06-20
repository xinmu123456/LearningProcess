<%--
  Created by IntelliJ IDEA.
  User: xinmu123
  Date: 2022/4/9
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
      function a() {
          $.post({
              url:"${pageContext.request.contextPath}/a1",
              data:{"name":$("#username").val()},
              success:function (data,status) {
                alert(data);
                console.log("data="+data);
                console.log("status="+status);
              }
          })
      }
    </script>
  </head>
  <body>

  <%--失去焦点的时候,发起一个请求(携带信息)到后台--%>
  用户名: <input type="text" id="username" onblur="a()">

  </body>
</html>
