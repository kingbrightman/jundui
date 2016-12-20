<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sf:form modelAttribute="rolePermissionDto">
    ${rolePermissionDto.role.name}<br>
    <sf:checkboxes path="permissionIds" items="${all_permissions}" itemLabel="url" itemValue="id"/> <br>
    <input type="submit" value="提交">
</sf:form>

</body>
</html>
