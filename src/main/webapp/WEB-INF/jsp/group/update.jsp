<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<sf:form method="post" modelAttribute="group">
    <table border="1px solid #000">
        <tr>
            <td>名称</td>
            <td><sf:input path="name" size="30"/></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><sf:input path="description"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"> <input type="reset" value="重置"></td>
        </tr>
    </table>
</sf:form>


</body>
</html>