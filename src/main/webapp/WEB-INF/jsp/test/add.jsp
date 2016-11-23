<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<sf:form modelAttribute="testValidation" method="post">
    name:<sf:input path="name"/><br>
    email:<sf:input path="email"/><br>

    <input type="submit">
</sf:form>

</body>
</html>
