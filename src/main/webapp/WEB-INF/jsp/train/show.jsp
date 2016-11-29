<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String contextPaht = request.getContextPath();
%>

<h2>训练信息</h2>
<table border="1px solid #000">
    <h2>${train.name} > ${train.level}</h2>
</table>

<h2>参加成员</h2>
<table border="1px solid #000">
    <thead>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>所属队伍</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.group.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>所有项目</h2>
<table border="1px solid #000">
    <thead>
    <tr>
        <td>科目编号</td>
        <td>科目名称</td>
        <td>操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td><a href="<%=contextPaht%>/admin/grade/update/${train.id}/${subject.id}">录入成绩</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
