<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="#" onclick="javascript:history.back(-1);">返回</a></h3>

<h1>${rolePermissionDto.role.name}</h1>


<sf:form modelAttribute="rolePermissionDto">

    <sf:checkboxes path="permissionIds" items="${all_permissions}" itemLabel="url" itemValue="id"/> <br>

    <input type="submit" value="提交">
</sf:form>

</body>
</html>
