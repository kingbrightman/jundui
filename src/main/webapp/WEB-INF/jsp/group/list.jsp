<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">团体管理</li>
</ul>


<div class="col-sm-12">

    <a href="add"  class="btn btn-default btn-lg  btn-sm" role="button">添加</a>

    <table class="table table-hover" id="list_table">
        <tr>
            <td>ID</td>
            <td>名称</td>
            <td>描述</td>
            <td>上级</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${datas.datas}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>${group.description}</td>
                <td>${group.parent.name}</td>
                <td>
                    <a href="update/${group.id}" class="btn btn-default btn-lg  btn-xs" role="button">修改</a>
                    <a href="delete/${group.id}" class="btn btn-default btn-lg  btn-xs" role="button">删除</a>
                </td>
            </tr>
        </c:forEach>


    </table>

    <%--分页--%>
    <jsp:include page="/jsp/bootstrap_pager.jsp">
        <jsp:param value="${datas.total }" name="totalRecord"/>
        <jsp:param value="list" name="url"/>
    </jsp:include>
</div>
</body>
</html>
