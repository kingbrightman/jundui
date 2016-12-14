<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>训练项目列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">训练科目管理</li>
</ul>

<div class="col-sm-12">
    <a href="add" class="btn btn-default btn-lg  btn-sm" role="button">添加</a>

    <table class="table table-hover" id="list_table">
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
                <td><a href="${pageContext.request.contextPath}/admin/subject/show/${subject.id}">${subject.name}</a>
                </td>
                <td>${subject.description}</td>
                <td>${subject.type}</td>
                <td>
                    <a href="update/${subject.id}" class="btn btn-default btn-lg  btn-xs" role="button">更新</a>
                    <a href="delete/${subject.id}" class="btn btn-default btn-lg  btn-xs" role="button">删除</a>
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
