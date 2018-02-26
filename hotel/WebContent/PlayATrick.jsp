<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table >
<c:if test="${!empty requestScope.badguy}">
${requestScope.badguy }<br>
</c:if>
	<tr><td>当前登陆用户</td></tr>
	<c:forEach var="entry" items="${applicationScope.map }">
        <c:url var="url" value="KickServlet">
            <c:param name="username" value="${entry.key }"></c:param>
        </c:url>
		<tr><td>${entry.key }</td><td><a href="${url }">踢死你</a></td></tr>
    </c:forEach>
</table>
</body>
</html>