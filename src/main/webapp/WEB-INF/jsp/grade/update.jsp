<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入成绩</title>
</head>
<body>

<h1>成绩录入</h1>

<h2>训练名称：<a href="${pageContext.request.contextPath}/admin/train/show/{train.id}">${train.name}</a></h2>
<h2>科目名称：${subject.name}</h2>

<form method="post">
    <table border="1px solid #000">
        <thead>
        <tr>
            <td>姓名</td>
            <td>成绩</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${grades}" var="grade">
            <tr>
                <td>${grade.user.name}</td>
                <input name="uid" type="hidden" value="${grade.user.id}">
                <td><input name="content" type="text" value="${grade.content}"></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
        </tbody>
    </table>

</form>

</body>
</html>
