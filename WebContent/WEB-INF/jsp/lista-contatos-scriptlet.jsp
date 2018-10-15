<!-- @ significa diretiva para configurar uma pagina jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*, br.com.caelum.dao.*, br.com.caelum.modelo.*, java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Listando contatos</title>
	</head>
	<body>
		<% SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy"); %>
		<h1>Listagem de Contatos</h1>
		<hr />
		<table border="1px solid #000" cellpadding="7px" cellspacing="0px">
			<tr bgcolor="#99B">
				<th>NOME</th>
				<th>E-MAIL</th>
				<th>ENDEREÇO</th>
				<th>DATA NASCIMENTO</th>
			</tr>
			<%
				ContatoDao dao = new ContatoDao();
				List<Contato> contatos = dao.getLista();
				
				int contador = 0;
				
				for (Contato contato : contatos) {
			%>
					<% Date data = contato.getDataNascimento(); %>
					<% String dataNascimento = formater.format(data); %>
					
					<% String bgColor = "";
						if((contador & 1) == 0) {
							bgColor = "#EEE";
						} else {
						  bgColor = "#FFF";
						}
					  %>
					
					<tr bgcolor=<%=bgColor %>>
						<td><%= contato.getNome() %></td>
						<td><%= contato.getEmail() %></td>
						<td><%= contato.getEndereco() %></td>
						<td><%= dataNascimento %></td>
					</tr>
					
			<%
					contador++;
				}
			%>
		</table>
	</body>
</html>