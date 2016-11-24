<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sf:form modelAttribute="trainDto" method="post">

    <table border="1px solid #000">
        <tr>
            <td>名称</td>
            <td><sf:input path="name"/></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><sf:input path="description"/></td>
        </tr>
        <tr>
            <td>等级</td>
            <td>
                <sf:select path="level">
                    <sf:options items="${levels}"/>
                </sf:select>
            </td>
        </tr>
        <tr>
            <td>项目</td>
            <td><sf:checkboxes path="subjects" items="${subjects}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td>参加团体</td>
            <td><sf:checkboxes path="groups" items="${groups}" itemLabel="name" itemValue="id"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>

</sf:form>

</body>
</html>
