<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sf:form method="post" modelAttribute="role">
    <table>
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
            <td><sf:select path="type">
                <sf:options items="${types}"/>
            </sf:select></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"> <input type="reset" value="重置"></td>
        </tr>
    </table>
</sf:form>

</body>
</html>
