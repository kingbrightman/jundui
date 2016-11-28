<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理首页</title>
</head>
<body>

<%
    String contextPath = request.getContextPath();
%>

<div id="container">
    <div id="top" style="width: 100%; height: 100px; border: 1px solid #000">
        <h1>后台管理首页</h1>
    </div>
    <div id="middle" style="width: 100%; height: 800px;">
        <div id="left" style="float: left; width: 20%; height: 100%; border: 1px solid #000;">
            <iframe src="<%=contextPath%>/admin/main/index_left" style="border:0px;"></iframe>
        </div>

        <div id="right" style=" float: left; width: 79%; height: 100%; border: 1px solid #000;">
            <iframe name="content" style="border: 0px; width: 100%; height: 100%;"></iframe>
        </div>
    </div>
</div>


</body>
</html>
