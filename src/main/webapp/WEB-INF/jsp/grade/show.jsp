<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入成绩</title>
</head>
<body>
<h1>成绩查看</h1>

<h2>训练名称：${train.name}</h2>
<h2>科目名称：${subject.name}</h2>

<form method="post">
    <table border="1px solid #000">
        <thead>
        <tr>
            <td>用户ID</td>
            <td>姓名</td>
            <td>成绩</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${grades}" var="grade">
            <tr>
                <td>${grade.user.id}</td>
                <td>${grade.user.name}</td>
                <td>${grade.content}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <td colspan="3">
                <a href="">计算成绩</a>
                <a href="">修改成绩</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>