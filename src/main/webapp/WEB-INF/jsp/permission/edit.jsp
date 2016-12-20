<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>

<h3><a href=”#” onClick="javascript :history.back(-1);">返回</a></h3>

<sf:form modelAttribute="permissionUrl">
    <table>
        <tr>
            <td>url:</td>
            <td><sf:input path="url"/></td>
        </tr>
        <tr>
            <td>描述:</td>
            <td><sf:input path="description"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</sf:form>

</body>
</html>
