<%@page import="org.yxm.jundui.model.SystemContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/temp.css">


<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<pg:pager export="curPage=pageNumber"
          items="${param.totalRecord }"
          maxPageItems="<%=SystemContext.getPageSize() %>"
          url="${param.url }">

    <span style="float:right;padding:6px;">

    <nav style="margin:0 auto; ">

        <ul class="pagination">

            <li><pg:last><a>共${param.totalRecord}条  第${curPage}页</a></pg:last></li>

            <li>
                <pg:first>
                    <a href="${pageUrl }" class="pager_link">首页</a>
                </pg:first>
            </li>


            <li>
                <pg:prev>
                    <a href="${pageUrl }" class="pager_link">上一页</a>
                </pg:prev>
            </li>

            <pg:pages>
                <c:if test="${curPage eq pageNumber }">
                    <li class="active"><a href="${pageUrl }" class="pager_link">${pageNumber }</a></li>
                </c:if>
                <c:if test="${curPage != pageNumber }">
                    <li><a href="${pageUrl }" class="pager_link">${pageNumber }</a></li>
                </c:if>
            </pg:pages>

            <li>
            <pg:next>
                <a href="${pageUrl }" class="pager_link">下一页</a>
            </pg:next>
            </li>

            <li>
                <pg:last>
                    <a href="${pageUrl }" class="pager_link">尾页</a>
                </pg:last>
            </li>
        </ul>
    </nav>

</pg:pager>
</span>