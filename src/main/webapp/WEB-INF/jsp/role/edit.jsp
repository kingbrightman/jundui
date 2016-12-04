<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
</head>
<body>

<ul class="breadcrumb" id="breadcrumb">
    <li class="active">角色管理</li>
    <li class="active">添加角色</li>
</ul>

<div style="margin-left:10px; margin-top: 10px;">

    <sf:form method="post" modelAttribute="role">
        <table class="table table-bordered"  style="width: auto;">
            <tr>
                <td>名称</td>
                <td><sf:input path="name" maxlength="30"/></td>
            </tr>
            <tr>
                <td>描述</td>
                <td><sf:textarea path="description"/></td>
            </tr>
            <tr>
                <td>类型</td>
                <td>
                    <sf:select path="type">
                        <sf:options items="${types}"/>
                    </sf:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-default" type="submit" value="提交">
                    <input class="btn btn-default" type="reset" value="重置">
                </td>
            </tr>
        </table>
    </sf:form>
</div>


</body>
</html>
