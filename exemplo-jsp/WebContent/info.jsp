<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<figure>
			<img alt="" src="${param.imgUrl}">
		</figure>
	</div>
	<div>
		<a href="index.jsp">INÍCIO</a>
	</div>
	<%@ include file="rodape.jsp"%>
</body>
</html>