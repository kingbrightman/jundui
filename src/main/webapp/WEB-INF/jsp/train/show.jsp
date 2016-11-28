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

Train:
<table border="1px solid #000">
    <c:forEach items="users" var="user">
        <tr>
            <td>${train.id}</td>
            <td>${train.name}</td>
            <td>${train.description}</td>
            <td>${train.level}</td>
        </tr>
    </c:forEach>
</table>

Users:
<table border="1px solid #000">
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.group.id}</td>
        </tr>
    </c:forEach>
</table>

Subjects:
<table border="1px solid #000">
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td>${subject.id}</td>
            <td><a href="<%=contextPaht%>/admin/grade/update/${train.id}/${subject.id}">${subject.name}</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
