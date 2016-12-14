<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>训练项目操作</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">训练科目管理</li>
    <li class="active">添加训练科目</li>
</ul>

<h3><a href=”#” onClick="javascript :history.back(-1);">返回</a></h3>

<div style="margin-left:10px; margin-top: 10px;">
    <table class="table table-bordered" style="width: auto;">
        <tbody>
        <tr>
            <td>名称</td>
            <td>${subject.name}</td>
        </tr>
        <tr>
            <td>描述</td>
            <td>${subject.description}</td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                ${subject.type.name}:${subject.type}
            </td>
        </tr>
        <tr>
            <td colspan="2">
                　优秀：${subject.level.yfrom} - ${subject.level.yto}<br>
                　良好：${subject.level.lfrom} - ${subject.level.lto}<br>
                　合格：${subject.level.zfrom} - ${subject.level.zto}<br>
                不合格：${subject.level.cfrom} - ${subject.level.cto}<br>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/subject/update/${subject.id}">修改</a>
            </td>
        </tr>
        </tbody>
    </table>

</div>
</body>
</html>
