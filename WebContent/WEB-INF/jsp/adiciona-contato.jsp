<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
	<head>
		<link href="../css/jquery-ui.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/jquery-ui.js"></script>
		<script type="text/javascript" src="../js/i18n/datepicker-pt-BR.js"></script>
		<meta charset="UTF-8">
		<title>Adiciona um novo contato</title>
	</head>
	<body>
		
<!-- 			Adiciona o cabeçalho -->
		<c:import url="./cabecalho/cabecalho.jsp" />
			
<!-- 		o nome no action eh o nome do servlet -->
		<form action="adicionaContato" method="post">
			<label for="name">Nome:</label>
			<input type="text" id="name" name="nome"/><br />
			
			<label for="e-mail">E-mail:</label>
			<input type="text" id="e-mail" name="email"/><br />
			
			<label for="address">Endereço:</label>
			<input type="text" id="address" name="endereco"/><br />
			
			<caelum:campoData label="Data Nascimento" id="dataNascimento" /><br />
						
			<input type="submit" value="Gravar" />
		</form>
		
<!-- 		Adiciona o rodape -->
		<c:import url="./rodape/rodape.jsp" />
	</body>
</html>