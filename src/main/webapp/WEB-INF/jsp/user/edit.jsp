<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<sf:form modelAttribute="userDto" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td><sf:input path="name"/><sf:errors path="name"/></td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><sf:input path="username"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <sf:radiobutton path="sex" label="男" value="男"/>
                <sf:radiobutton path="sex" label="女" value="女"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <c:if test="${isUpdate}">
                <td><sf:password disabled="true" path="password"/><sf:errors path="password"/></td>
            </c:if>
            <c:if test="${!isUpdate}">
                <td><sf:password path="password"/><sf:errors path="password"/></td>
            </c:if>

        </tr>
        <tr>
            <td>所在部门</td>
            <td>
                <sf:select path="group.id">
                    <sf:options items="${groups}" itemLabel="name" itemValue="id"/>
                </sf:select>
                <sf:errors path="group.id"/>
            </td>
        </tr>
        <tr>
            <td>角色</td>
            <td>
                <sf:checkboxes path="roleIds" items="${roles}" itemLabel="name" itemValue="id"/>
            </td>
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
