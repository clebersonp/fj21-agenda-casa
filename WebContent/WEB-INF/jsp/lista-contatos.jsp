<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista contatos com JSTL taglibs</title>
</head>
<body>
<!-- 	Importando outras paginas -->
	<c:import url="./cabecalho/cabecalho.jsp" />
	
	<table border="1px solid #000" cellpadding="7px" cellspacing="0px">
		<tr bgColor="#99A">
			<th>NOME</th>
			<th>E-MAIL</th>
			<th>ENDEREÇO</th>
			<th>DATA NASCIMENTO</th>
			<th>AÇÕES</th>
		</tr>
		
<!-- 		Contatos esta vindo do parametro do request setado no servlet -->
		
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			
<!-- 			Condicional para colorir as linhas da tabela -->
			<tr bgcolor="#${((id.count mod 2) == 0) ? 'DDD' : 'FFF'}">			
				<td>${contato.nome}</td>
				
<!-- 				Condicional com o switch/case, pois o if não tem a tag else, -->
				<c:choose>
					<c:when test="${not empty contato.email}">
						<td><a href="mailto:${contato.email}">${contato.email}</a></td>
					</c:when>
					<c:otherwise>
						<td>NÂO INFORMADO</td>
					</c:otherwise>
				</c:choose>
				
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/></td>
				<td>
					<a href="mvc?logica=MostraContatoManutencaoLogic">Novo</a> | 
					<a href="mvc?logica=MostraContatoManutencaoLogic&id=${contato.id}">Alterar</a> | 
					<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<!-- 	Importando outras paginas -->
	<c:import url="./rodape/rodape.jsp" />
</body>
</html>