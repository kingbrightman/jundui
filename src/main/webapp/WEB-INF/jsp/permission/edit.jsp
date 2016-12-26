<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>
<ul class="breadcrumb" id="breadcrumb">
    <li class="active">权限控制</li>
    <li class="active">添加</li>
</ul>

<div style="margin-left:10px; margin-top: 10px;">
    <sf:form modelAttribute="permissionUrl">
        <table class="table table-bordered" style="width: auto;">
            <tr>
                <td>url:</td>
                <td><sf:input path="url"/></td>
            </tr>
            <tr>
                <td>描述:</td>
                <td><sf:input path="description"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交">
                <button href=”#” onClick="javascript :history.back(-1);" class="btn btn-default">返回</button>
                </td>
            </tr>
        </table>
    </sf:form>
</div>
</body>
</html>
