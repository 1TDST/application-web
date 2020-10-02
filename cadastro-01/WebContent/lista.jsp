<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="f"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.css">

<title>LISTA CLIENTE</title>
</head>
<body>

<%@ include file="menu-header.html"%>

	<section>
	
		<table class="table table-dark table-hover">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Dt Nasc</th>
				<th>Gênero</th>
				<th>Tel</th>
				<th>Editar</th>
			</tr>
	<%-- Criando a estrutura para receber o atributo com a lista de clientes --%>
		
		<c:forEach var="cli" items="${listaCliente}" varStatus="id">
			<tr>
				<td>${id.count}</td>
				<td>${cli.nome} ${cli.sobrenome}</td>
				<td>${cli.dataNasc}</td>
				<td>${cli.genero}</td>
				<td>${cli.telefone}</td>
				<td>Editar</td>
			</tr>
		</c:forEach>
		
		</table>
		
		
	</section>
	<footer></footer>

	<script type="text/javascript" src="./js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="./js/bootstrap.js"></script>
</body>
</html>











