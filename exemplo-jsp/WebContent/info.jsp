<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<%@ include file="imports.jsp"%>
<title>INFO-IMG</title>
</head>
<body>
	<div>
		<p>COM SCRIPTLETS</p>
		<span><%=request.getParameter("imgUrl") %></span>
	</div>
	<div>
		<c:choose>
			<c:when test="${param.imgUrl != ''}">
				<figure>
					<%-- COM EL - Expression Language --%>
					<img alt="" src="${param.imgUrl}" width="150px">
				</figure>
			</c:when>
			<c:when test="${param.imgUrl == ''}">
				<jsp:forward page="no-page.html"/>
			</c:when>
		</c:choose>
		
	</div>
	<div>
		<a href="index.jsp">INÍCIO</a>
	</div>
	<%@ include file="rodape.jsp"%>
</body>
</html>