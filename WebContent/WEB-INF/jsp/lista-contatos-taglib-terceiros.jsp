<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

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
	
	
<!-- 	Cria o Dao, precisa do construtor default -->
	<jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao" />
	
<!-- 	Seta a lista no atributo do request -->
	<% request.setAttribute("tabela", dao.getLista()); %>
	
<!-- 	Preenche a tabela com o objetos lista que esta no atributo do request chamado tabela -->
	<display:table name="tabela">
		<display:column property="id" title="ID" />
		<display:column property="nome" title="NOME" />
		<display:column property="email" title="E-MAIL" />
		<display:column property="endereco" title="ENDEREÇO" />
		<display:column property="dataNascimento" title="DATA NASCIMENTO" />
	</display:table>
	
<!-- 	Importando outras paginas -->
	<c:import url="./rodape/rodape.jsp" />
</body>
</html>