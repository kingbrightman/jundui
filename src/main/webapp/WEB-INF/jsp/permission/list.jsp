<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<h1>权限URL控制</h1>

<a href="${pageContext.request.contextPath}/admin/permission/add">添加</a>

<table>
    <tr>
        <td>ID</td>
        <td>url</td>
        <td>描述</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${datas.datas}" var="permissionUrl">
        <tr>
            <td>${permissionUrl.id}</td>
            <td>${permissionUrl.url}</td>
            <td>${permissionUrl.description}</td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/permission/update/${permissionUrl.id}">修改</a>
                <a href="${pageContext.request.contextPath}/admin/permission/delete/${permissionUrl.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<jsp:include page="/jsp/pager.jsp">
    <jsp:param value="${datas.total }" name="totalRecord"/>
    <jsp:param value="list" name="url"/>
</jsp:include>

</body>
</html>
