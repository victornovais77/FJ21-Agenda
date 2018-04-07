<%@ page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Formulário de contato</title>
	<link rel="stylesheet" href="/assets/css/jquery.css">

	<script src="/assets/js/jquery.js"></script>
	<script src="/assets/js/jquery-ui.js"></script>
</head>
<body>

	<h1>Formulário de contato</h1>

	<form action="/salvaContato" method="post">
		
		Nome:
		<input type="text" name="nome">
		
		Email:
		<input type="email" name="email">
		
		Endereço:
		<input type="text" name="endereco">
		
		<tags:datas texto="Data de nascimento" data="dataNascimento" />
		
		<button>Salvar</button>
		
	</form>


</body>
</html>