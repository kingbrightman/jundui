<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/multiple-select.css">
</head>
<body>
<ul class="breadcrumb" id="breadcrumb">
    <li class="active">成绩查询</li>
</ul>
<div class="col-sm-12 container">
    <div class="form-group">
        <sf:form modelAttribute="gradeSelectDto" action="list_select">
            <sf:select path="uids" id="ms" multiple="multiple" class="uselect">

                <sf:options items="${users}" itemValue="id" itemLabel="name"/>
            </sf:select>

            <sf:select path="tids" id="ms" multiple="multiple" class="tselect">

                <sf:options items="${trains}" itemValue="id" itemLabel="name"/>
            </sf:select>

            <sf:select path="sids" id="ms" multiple="multiple" class="sselect">

                <sf:options items="${subjects}" itemValue="id" itemLabel="name"/>
            </sf:select>

            <sf:select path="gids" id="ms" multiple="multiple" class="gselect">

                <sf:options items="${groups}" itemValue="id" itemLabel="name"/>
            </sf:select>

            <input type="submit" value="查询" class="btn btn-default">
        </sf:form>

        <a href="list_sort?sort=content*1&order=desc" class="btn btn-default">降序</a>
        <a href="list_sort?sort=content*1&order=asc" class="btn btn-default">升序</a>
    </div>

    <table class="table table-hover table-bordered">
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
</div>


<script src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/multiple-select.js"></script>
<script>
    $(function() {
        $('.uselect').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '23%',
            placeholder: '选择用户'
        });
        $('.tselect').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '23%',
            placeholder: '选择训练项目'
        });
        $('.sselect').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '23%',
            placeholder: '选择训练'
        });
        $('.gselect').change(function() {
            console.log($(this).val());
        }).multipleSelect({
            width: '23%',
            placeholder: '选择参加团体'
        });
    });

</script>
</body>
</html>
