<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理首页</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">
</head>
<body>


<div id="container">
    <!--顶部标题栏-->
    <nav class="navbar navbar-default" role="navigation" style="position: fixed; z-index: 2; width: 100%;">
        <div class="container-fluid" style="background-color: #E8E8E8;">
            <div class="navbar-header">
                <a class="navbar-brand" href="#" style="color:#006600; font-size: 30px; font-family:'Microsoft Yahei', '微软雅黑', Arial, sans-serif; ">后台管理</a>
            </div>
        </div>
    </nav>
    <div class="container-fluid all">
        <jsp:include page="index_left.jsp"/>
    </div>

    <div class="maincontent row">
        <iframe name="content" style="border: 0px; width: 100%; height: 90%;"></iframe>
    </div>

</div>


</body>
</html>
