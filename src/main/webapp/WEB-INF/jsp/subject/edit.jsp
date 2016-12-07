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

<div style="margin-left:10px; margin-top: 10px;">
    <sf:form modelAttribute="subjectDto" method="post">

        <table class="table table-bordered" style="width: auto;">
            <tbody>
            <tr>
                <td>名称</td>
                <td><sf:input path="name"/><sf:errors path="name" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>描述</td>
                <td><sf:input path="description"/></td>
            </tr>
            <tr>
                <td>类型</td>
                <td>
                    <sf:select path="type">
                        <sf:options items="${types}"/>
                    </sf:select>
                    <sf:errors path="type" cssStyle="color: red"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    　优秀：<sf:input path="yfrom"/> - <sf:input path="yto"/><br>
                    　良好：<sf:input path="lfrom"/> - <sf:input path="lto"/><br>
                    　合格：<sf:input path="zfrom"/> - <sf:input path="zto"/><br>
                    不合格：<sf:input path="cfrom"/> - <sf:input path="cto"/><br>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input class="btn btn-default" type="submit" value="提交">
                </td>
            </tr>
            </tbody>
        </table>

    </sf:form>
</div>
</body>
</html>
