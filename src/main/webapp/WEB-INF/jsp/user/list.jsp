<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">用户管理</li>
</ul>

<div class="col-sm-12">
    <a href="add" class="btn btn-default btn-lg  btn-sm" role="button">添加</a>

    <table class="table table-hover" id="list_table">
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
                    <a href="update/${user.id}" class="btn btn-default btn-lg  btn-xs" role="button">修改</a>
                    <a href="delete/${user.id}" class="btn btn-default btn-lg  btn-xs" role="button">删除</a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <%--分页--%>
    <jsp:include page="/jsp/bootstrap_pager.jsp">
        <jsp:param value="${datas.total }" name="totalRecord"/>
        <jsp:param value="list" name="url"/>
    </jsp:include>
</div>
</body>
</html>
