<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
%>

<ul>
    <li><a href="<%=contextPath%>/admin/role/list" target="content">角色管理</a></li>
    <li><a href="<%=contextPath%>/admin/group/list" target="content">团体管理</a></li>
    <li><a href="<%=contextPath%>/admin/user/list" target="content">用户管理</a></li>
    <li><a href="<%=contextPath%>/admin/subject/list" target="content">训练科目管理</a></li>
    <li><a href="<%=contextPath%>/admin/train/list" target="content">训练管理</a></li>
</ul>

</body>
</html>
