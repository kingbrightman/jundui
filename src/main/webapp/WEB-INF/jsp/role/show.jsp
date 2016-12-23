<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>角色显示页面</h1>

<h2>${role.name}</h2>

<c:forEach items="${permissions}" var="permission">
    <p>${permission.url}</p>
</c:forEach>

<a href="${pageContext.request.contextPath}/admin/role/permission/edit/${role.id}">修改权限</a>
</body>
</html>
