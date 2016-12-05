<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<div class="container" style="margin-top:50px;">

    <form action="login" method="post" class="form-signin" role="form" style="max-width: 340px; margin:0 auto;">
        <h2 class="form-signin-heading" style="text-align: center;">训练管理系统</h2>

        <input name="username" type="text" class="form-control" placeholder="用户名" required="" autofocus=""
               style="padding: 20px;margin-bottom:3px;">
        <input name="password" type="password" class="form-control" placeholder="密码" required="" style="padding: 20px;">

        <%--
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        --%>
        <p style="color: red;">${error_info}</p>

        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div>

</body>
</html>
