<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入成绩</title>
</head>
<body>
<h1>成绩查看</h1>

<h2>训练名称：<a href="${pageContext.request.contextPath}/admin/train/show/${train.id}">${train.name}</a></h2>
<h2>新兵：${user.name}</h2>

<form method="post">
    <table border="1px solid #000">
        <tr>
            <td>项目ID</td>
            <td>项目名称</td>
            <td>成绩</td>
            <td>分数</td>
        </tr>
        <c:forEach items="${grades}" var="grade">
            <tr>
                <td>${grade.subject.id}</td>
                <td>${grade.subject.name}</td>
                <td>${grade.content}</td>
                <td>${grade.score}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
