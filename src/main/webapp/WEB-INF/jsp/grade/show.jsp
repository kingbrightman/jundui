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
    <li class="active">成绩查看</li>
</ul>
<div class="col-sm-12">
    <p style="text-align:center; font-size: 20px; font-family:'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">训练名称：<a href="${pageContext.request.contextPath}/admin/train/show/${train.id}">${train.name}</a> &nbsp;&nbsp;&nbsp; 科目名称：${subject.name}</p>

    <form method="post">
        <table  class="table table-hover table-bordered">
            <thead>
            <tr>
                <td>用户ID</td>
                <td>姓名</td>
                <td>成绩</td>
                <td>级别</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${grades}" var="grade">
                <tr>
                    <td>${grade.user.id}</td>
                    <td>${grade.user.name}</td>
                    <td>${grade.content}</td>
                    <td>${grade.score}</td>
                </tr>
            </c:forEach>
            </tbody>
            <tr>
                <td colspan="4">
                    <a href="${pageContext.request.contextPath}/admin/grade/update/${train.id}/${subject.id}">修改成绩</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
