<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Lista contatos</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<c:import url="cabecalho.jsp" />
<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />

<main class="container">

<h1>Listagem de contatos!</h1>

<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contato" items="${dao.lista}">
		<tr>
			<td>${contato.id}</td>
			<td>${contato.nome}</td>
			<td>
				<c:choose>
					<c:when test="${empty contato.email}">
						Não tem email cadastrado!
					</c:when>
					<c:otherwise>
						<a href="mailTo:${contato.email}">${contato.email}</a>
					</c:otherwise>
				</c:choose>
			</td>
			<td>${contato.endereco}</td>
			<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
		</tr>
		</c:forEach>
	</tbody>
</table>

</main>
	
</body>
</html>

