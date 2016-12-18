<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩查询</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">训练管理</li>
    <li class="active">训练信息</li>
</ul>

<div class="col-sm-9">
    <p style="text-align:center; font-size: 20px; font-family:'Microsoft Yahei', '微软雅黑', Arial, sans-serif;">
        训练名称：${train.name} &nbsp;&nbsp;&nbsp;级别： ${train.level.name}</p>

    <span>参加成员</span>
    <table class="table table-hover table-bordered" id="list_table">
        <thead>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>所属队伍</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/grade/show_user_train_grades/${train.id}/${user.id}"> ${user.name}</a>
                </td>
                <td>${user.group.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <span>所有项目</span>
    <table class="table table-hover table-bordered" id="list_table">
        <thead>
        <tr>
            <td>科目编号</td>
            <td>科目名称</td>
            <td>操作</td>
        </thead>
        <tbody>
        <c:forEach items="${subjects}" var="subject">
            <tr>
                <td>${subject.id}</td>
                <td>${subject.name}</td>
                <td colspan="2">
                    <a href="${pageContext.request.contextPath}/admin/grade/show_subject_train_grades/${train.id}/${subject.id}">查看成绩</a>
                    <a href="${pageContext.request.contextPath}/admin/grade/update/${train.id}/${subject.id}">录入成绩</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
