<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改成绩</title>
</head>
<body>

<a href=”#” onClick="javascript :history.back(-1);">返回</a>

<sf:form modelAttribute="grade">
    <table border="1px solid #000">
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
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>

</sf:form>
</body>
</html>
