<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
</head>
<body>

<div class="sidebar">
    <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/admin/role/list" target="content">角色管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/group/list" target="content">团体管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/user/list" target="content">用户管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/subject/list" target="content">训练科目管理</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/train/list" target="content">训练管理</a></li>
    </ul>
</div>

    <script src="${pageContext.request.contextPath}/resources/js/temp.js"></script>
</body>
</html>
