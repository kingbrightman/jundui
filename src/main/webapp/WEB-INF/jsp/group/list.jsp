<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
</head>
<body>

<a href="add">添加</a>

<table border="1px solid #000">
    <thead>
    <tr>
        <td>ID</td>
        <td>名称</td>
        <td>描述</td>
        <td>上级</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${datas.datas}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td>${group.description}</td>
            <td>${group.parent.id}</td>
            <td>
                <a href="delete/${group.id}">删除</a>
                <a href="update/${group.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
