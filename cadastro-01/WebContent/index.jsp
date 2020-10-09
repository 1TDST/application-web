<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<%@ include file="./WEB-INF/snippets/imports/libs-head.jsp"%>
<title>CADASTRO</title>
</head>
<body>


	<!-- ESSE COMENTÁRIO O CLIENTE CONSEGUE VER -->
	<%-- ESSE COMENTÁRIO O CLIENTE NÃO CONSEGUE VER--%>

	<%@ include file="menu-header.html"%>

	<c:choose>
		<c:when test="${param.status eq 'ok'}">	
			<div>
				<h2 class="alert alert-success" role="alert">${param.msgStatus}</h2>
			</div>
		</c:when>
		<c:when test="${param.status eq 'err'}">	
			<div>
				<h2 class="alert alert-danger" role="alert">${param.msgStatus}</h2>
			</div>
		</c:when>
	</c:choose>

	<section>
		<form action="cadastro" method="POST">
			<fieldset>
				<legend>Cadastro de Clientes</legend>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm">Nome</label>
					<div class="col-sm-8">
						<input type="text" name="txtNm" id="idNm" class="form-control"
							placeholder="Digite seu nome." required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm">Sobrenome</label>
					<div class="col-sm-8">
						<input type="text" name="txtSnm" id="idSnm" class="form-control"
							placeholder="Digite seu sobrenome." required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc">Data Nascimento</label>
					<div class="col-sm-8">
						<input type="date" name="txtDtNasc" id="idDtNasc" class="form-control" required="required">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idGen">Gênero</label>
					<div class="col-sm-8">
						<select name="txtGen" id="idGen" class="form-control" required="required">
							<option value="0" selected="selected">Selecione sua opção</option>
							<option value="m">Masculino</option>
							<option value="f">Feminino</option>
							<option value="o">Outros</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idTel">Telefone</label>
					<div class="col-sm-8">
						<input type="tel" name="txtTel" id="idTel" class="form-control"
							placeholder="(99) 99999-9999" required="required" maxlength="15"
							pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success btn-lg">Cadastrar</button>
					</div>
				</div>
				
			</fieldset>
		</form>
	</section>
	<footer></footer>
<%@ include file="./WEB-INF/snippets/imports/libs-footer.jsp" %>
</body>
</html>





