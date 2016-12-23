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
    <li class="active">训练管理</li>
</ul>
<div class="col-sm-12">
    <a href="add" class="btn btn-default btn-lg  btn-sm" role="button">添加</a>

    <%--error_info--%>
    <p style="color: red;">${ error_info}</p>

    <table class="table table-hover table-bordered" id="list_table">
        <thead>
        <tr>
            <td>ID</td>
            <td>名称</td>
            <td>描述</td>
            <td>创建人</td>
            <td>所属连队</td>
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
                <td>${train.createUser.group.name}</td>
                <td>${train.level.name}</td>
                <td>${train.createDate}</td>
                <td>
                    <a href="update/${train.id}" class="btn btn-default btn-lg  btn-xs" role="button">更新</a>
                    <a href="delete/${train.id}" class="btn btn-default btn-lg  btn-xs" role="button">删除</a>
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
