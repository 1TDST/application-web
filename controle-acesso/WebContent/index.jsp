<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<title>LOGIN</title>
</head>
<body>

	<h2>ID SESSION :${id}</h2>
			
	<!-- Carregando o Modal -->
	<button type="button" class="btn btn-info" data-toggle="modal"
		data-target="#box-login">LOGIN</button>

	<!-- Estrutura do Modal -->
	<div class="modal fade" role="dialog" id="box-login">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4>Login de Usuários</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					

					<form action="index.php" method="post">
						<div class="form-group">
							<label for="nm-user">Nome de Usuário</label> <input type="text"
								name="txt-user" id="nm-user"
								placeholder="Digite o seu nome de Usuário." required="required" class="form-control">
						</div>
						<div class="form-group">
							<label for="pass-user">Senha</label> <input type="password"
								name="txt-pass" id="pass-user"
								placeholder="Digite a sua senha." required="required" class="form-control">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</form>


				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="btn btn-danger">Fechar</button>
				</div>
			</div>

		</div>
	</div>
<script language=’Javascript’>
segundos = 7;
function contagem_tempo(){

document.contador.segundos.value = segundos;
segundos = segundos – 1;

if (segundos == -1) {
segundos = 0;
}

timerID = setTimeout(“contagem_tempo()”,1000);
}
</script>

<form name=”contador”>
<input name=”segundos” type=”text” />
</form>
	
	
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>