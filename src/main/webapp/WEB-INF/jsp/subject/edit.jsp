<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>训练项目操作</title>
</head>
<body>

<sf:form modelAttribute="subject" method="post">

    <table border="1px solid #000">
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
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
        </tbody>
    </table>

</sf:form>

</body>
</html>
