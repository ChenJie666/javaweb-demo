<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/9
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<div>
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        账号: <input type="text" name="username"> <br>
        密码: <input type="password" name="password"> <br>

        爱好:
        <input type="checkbox" name="hobby" value="代码">代码
        <input type="checkbox" name="hobby" value="游戏">游戏
        <input type="checkbox" name="hobby" value="运动">运动

        <br>
        <input type="submit">
    </form>
</div>
<body>

</body>
</html>
