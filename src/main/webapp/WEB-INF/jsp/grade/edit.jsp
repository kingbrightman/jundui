<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>
<ul class="breadcrumb" id="breadcrumb">
    <li class="active">成绩查询</li>
    <li class="active">成绩修改</li>
</ul>

<div  class="col-sm-6">
    <sf:form modelAttribute="grade">
        <table class="table table-bordered" style="width: auto;">
            <tr>
                <td>ID</td>
                <td>${grade.id}</td>
                <sf:hidden path="id"/>
            </tr>
            <tr>
                <td>训练名称</td>
                <td>${grade.train.name}</td>
            </tr>
            <tr>
                <td>项目名称</td>
                <td>${grade.subject.name}</td>
            </tr>
            <tr>
                <td>新兵名称</td>
                <td>${grade.user.name}</td>
            </tr>
            <tr>
                <td>成绩</td>
                <td><sf:input path="content"/></td>

            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交" class="btn btn-default">
                <button href=”#” onClick="javascript :history.back(-1);" class="btn btn-default">返回</button>
                </td>
            </tr>
        </table>

    </sf:form>
</div>
</body>
</html>
