<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="./snippets/imports/libs-head.jsp"%><title>ATUALIZAÇÃO</title>
</head>
<body>

	<%@ include file="../menu-header.html"%>
	
	<section>
		<form action="update" method="POST">
			<input type="hidden" name="txtIdCli" value="${objCli.id}">
			<fieldset>
				<legend>Atualização de Clientes</legend>
				<div class="form-group">
					<label class="control-label col-sm-4" for="idNm">Nome</label>
					<div class="col-sm-8">
						<input type="text" name="txtNm" id="idNm" class="form-control"
							placeholder="Digite seu nome." required="required" value="${objCli.nome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idSnm">Sobrenome</label>
					<div class="col-sm-8">
						<input type="text" name="txtSnm" id="idSnm" class="form-control"
							placeholder="Digite seu sobrenome." required="required" value="${objCli.sobrenome}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idDtNasc">Data Nascimento</label>
					<div class="col-sm-8">
						<input type="date" name="txtDtNasc" id="idDtNasc" class="form-control" 
					required="required" value='<f:formatDate value="${objCli.dataNasc}" pattern="yyyy-MM-dd"/>'> 
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idGen">Gênero</label>
					<div class="col-sm-8">
						<select name="txtGen" id="idGen" class="form-control" required="required">
						<c:choose>
							<c:when test="${objCli.genero eq 'm'.charAt(0)}">
								<option value="0">Selecione sua opção</option>
								<option value="m" selected="selected">Masculino</option>
								<option value="f">Feminino</option>
								<option value="o">Outros</option>
							</c:when>
							<c:when test="${objCli.genero eq 'f'.charAt(0)}">
								<option value="0">Selecione sua opção</option>
								<option value="m">Masculino</option>
								<option value="f" selected="selected">Feminino</option>
								<option value="o">Outros</option>
							</c:when>
							<c:otherwise>
								<option value="0">Selecione sua opção</option>
								<option value="m">Masculino</option>
								<option value="f">Feminino</option>
								<option value="o" selected="selected">Outros</option>
							</c:otherwise>
						</c:choose>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-4" for="idTel">Telefone</label>
					<div class="col-sm-8">
						<input type="tel" name="txtTel" id="idTel" class="form-control"
							placeholder="(99) 99999-9999" required="required" maxlength="15"
							pattern="\([0-9]{2}\) [0-9]{4,6}-[0-9]{3,4}$" value="${objCli.telefone}">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-info btn-lg">Atualizar</button>
					</div>
				</div>
				
			</fieldset>
		</form>
	</section>
	<footer></footer>
<%@ include file="./snippets/imports/libs-footer.jsp" %>
</body>
</html>
