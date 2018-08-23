<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${prize}" var="pr" varStatus="index">
		 <c:if test="${index.index eq 0}" > FIRST  PRIZE: ${pr} </c:if> <br/>
		 <c:if test="${index.index eq 1}" > SECOND PRIZE: ${pr} </c:if> <br/>
		 <c:if test="${index.index eq 2}" > THIRD  PRIZE: ${pr} </c:if> <br/>
	</c:forEach>
</body>
</html>