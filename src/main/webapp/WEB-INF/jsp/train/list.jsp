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
        <td>名称</td>
        <td>描述</td>
        <td>创建人</td>
        <td>等级</td>
        <td>创建日期</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas.datas}" var="train">
        <tr>
            <td>${train.id}</td>
            <td><a href="show/${train.id}">${train.name}</a></td>
            <td>${train.description}</td>
            <td>${train.createUser.name}</td>
            <td>${train.level.name}</td>
            <td>${train.createDate}</td>
            <td>
                <a href="update/${train.id}">更新</a>
                <a href="delete/${train.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
