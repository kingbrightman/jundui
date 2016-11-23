<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="add">添加</a>

<table border="1px solid #000">
    <thead>
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>昵称</td>
        <td>性别</td>
        <td>创建日期</td>
        <td>所属部队</td>
        <td>密码</td>
        <td>操作</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${datas.datas}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.sex}</td>
            <td>${user.createDate}</td>
            <td>${user.group.name}</td>
            <td>${user.password}</td>
            <td>
                <a href="update/${user.id}">修改</a>
                <a href="delete/${user.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
