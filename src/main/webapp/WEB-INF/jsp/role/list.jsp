<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
</head>
<body>

<div style="border: 1px solid #000; float: left;">
    <a href="add">添加</a>

    <table border="1px solid #000">
        <thead>
        <tr>
            <td>ID</td>
            <td>角色名称</td>
            <td>角色描述</td>
            <td>类型</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${datas.datas}" var="role">
            <tr>
                <td>${role.id}</td>
                <td>${role.name}</td>
                <td>${role.description}</td>
                <td>${role.type}</td>
                <td>
                    <a href="update/${role.id}">修改</a>
                    <a href="delete/${role.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5">
                <jsp:include page="/jsp/pager.jsp">
                    <jsp:param value="${datas.total }" name="totalRecord"/>
                    <jsp:param value="list" name="url"/>
                </jsp:include>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>
