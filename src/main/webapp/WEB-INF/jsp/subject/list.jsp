<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>训练项目列表</title>
</head>
<body>

<a href="add">添加</a>

<table border="1px solid #000">
    <thead>
    <tr>
        <td>ID</td>
        <td>名称</td>
        <td>描述</td>
        <td>类型</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${datas.datas}" var="subject">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td>${subject.description}</td>
            <td>${subject.type}</td>
            <td>
                <a href="update/${subject.id}">更新</a>
                <a href="delete/${subject.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
