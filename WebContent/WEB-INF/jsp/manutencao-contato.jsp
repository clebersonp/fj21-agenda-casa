<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
	<head>
		<link href="css/jquery-ui.css" rel="stylesheet">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<script type="text/javascript" src="js/i18n/datepicker-pt-BR.js"></script>
		<meta charset="UTF-8">
		<c:choose>
			<c:when test="${not empty contato.id}">
				<title>Alteração de contato</title>
			</c:when>
			<c:otherwise>
				<title>Adição de um novo contato</title>
			</c:otherwise>
		</c:choose>
	</head>
	<body>
		
<!-- 			Adiciona o cabeçalho -->
		<c:import url="./cabecalho/cabecalho.jsp" />
			
<!-- 			O contato esta vindo do parametro contato setado no request no servlet -->
			
<!-- 		o nome no action eh o nome do servlet -->


		<form action="mvc?logica=ManutencaoContatoLogic" method="post" >
			<input type="text" id="pk" name="id" hidden="true" value="${contato.id}" /><br />
		
			<label for="name">Nome:</label>
			<input type="text" id="name" name="nome" value="${contato.nome}" /><br />
			
			<label for="e-mail">E-mail:</label>
			<input type="text" id="e-mail" name="email" value="${contato.email}" /><br />
			
			<label for="address">Endereço:</label>
			<input type="text" id="address" name="endereco" value="${contato.endereco}" /><br />
			
			<caelum:campoData label="Data Nascimento" id="dataNascimento" value="${contato.dataNascimentoFormatada}" /><br />

			<c:choose>
				<c:when test="${not empty contato.id}">
					<input type="submit" value="Alterar" />
				</c:when>
				<c:otherwise>
					<input type="submit" value="Gravar" />
				</c:otherwise>
			</c:choose>						
		</form>
		
<!-- 		Adiciona o rodape -->
		<c:import url="./rodape/rodape.jsp" />
	</body>
</html>