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
    <li class="active">个人成绩查看</li>
</ul>

<div class="col-sm-6" >
    <p style="text-align:center; font-size: 20px; font-family:'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">
        训练名称：<a href="${pageContext.request.contextPath}/admin/train/show/${train.id}">${train.name}</a> &nbsp;&nbsp;&nbsp;新兵：${user.name}</p>

    <form method="post" style="text-align: center;">
        <table class="table table-hover table-bordered" style="text-align: center;">
            <tr>
                <td>项目ID</td>
                <td>项目名称</td>
                <td>成绩</td>
                <td>分数</td>
            </tr>
            <c:forEach items="${datas.datas}" var="grade">
                <tr>
                    <td>${grade.subject.id}</td>
                    <td>${grade.subject.name}</td>
                    <td>${grade.content}</td>
                    <td>${grade.score}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
