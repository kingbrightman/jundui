<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩列表</title>
</head>
<body>
<h1>成绩查询</h1>

<div>
    <sf:form modelAttribute="gradeSelectDto" action="list_select">
        <sf:select path="uids">
            <sf:option value="" label="无"/>
            <sf:options items="${users}" itemValue="id" itemLabel="name"/>
        </sf:select>

        <sf:select path="tids">
            <sf:option value="" label="无"/>
            <sf:options items="${trains}" itemValue="id" itemLabel="name"/>
        </sf:select>

        <sf:select path="sids">
            <sf:option value="" label="无"/>
            <sf:options items="${subjects}" itemValue="id" itemLabel="name"/>
        </sf:select>

        <sf:select path="gids">
            <sf:option value="" label="无"/>
            <sf:options items="${groups}" itemValue="id" itemLabel="name"/>
        </sf:select>

        <input type="submit" value="查询">
    </sf:form>

    <a href="list_sort?sort=content*1&order=desc">降序</a>
    <a href="list_sort?sort=content*1&order=asc">升序</a>
</div>


<table border="1px solid #000">
    <tr>
        <td>ID</td>
        <td>训练名称</td>
        <td>项目</td>
        <td>新兵</td>
        <td>成绩</td>
        <td>分数</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${datas.datas}" var="grade">
        <tr>
            <td>${grade.id}</td>
            <td>${grade.train.name}</td>
            <td>${grade.subject.name}</td>
            <td>${grade.user.name}</td>
            <td>${grade.content}</td>
            <td>${grade.score}</td>
            <td>
                <a href="#">修改</a>
                <a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<div>
    <jsp:include page="/jsp/bootstrap_pager.jsp">
        <jsp:param value="${datas.total }" name="totalRecord"/>
        <jsp:param value="list" name="url"/>
    </jsp:include>
</div>
</body>
</html>
