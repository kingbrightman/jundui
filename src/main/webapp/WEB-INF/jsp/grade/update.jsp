<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>录入成绩</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">训练管理</li>
    <li class="active">成绩录入</li>
</ul>
<div class="col-sm-6">
    <p style="text-align:center; font-size: 20px; font-family:'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">训练名称：<a href="${pageContext.request.contextPath}/admin/train/show/{train.id}">${train.name}</a> &nbsp;&nbsp;&nbsp;  科目名称：${subject.name}</p>

    <form method="post">
        <table  class="table table-hover table-bordered">
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
                    <input  name="uid" type="hidden" value="${grade.user.id}">
                    <td><input  name="content" class="form-control" type="text" value="${grade.content}" style="border:0;"></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2"><input type="submit" value="提交" class="btn btn-default"></td>
            </tr>
            </tbody>
        </table>

    </form>
</div>
</body>
</html>
