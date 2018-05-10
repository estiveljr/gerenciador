<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gerenciador de Estoques</title>
</head>
<body>
	<h1>Gerenciador de estoque</h1>
	<form action="Controler">
		<h2>Custo de falta</h2>
		<input name='custoFalta' type='text' />
		<h2>Valor da Peça</h2>
		<input name='valorPeca' type='text' />
		<h2>Taxa de armazenamento</h2>
		<input name='taxaArmazenamento' type='text' />
		<h2>Consumo Médio</h2>
		<input name='consumoMedio' type='text' />
		<h2>Custo do Pedido</h2>
		<input name='custoPedido' type='text' />
		<h2>Estoque Limite</h2>
		<input name='estoqueLimite' type='text' /> 
		<br /> 
		<br /> 
		<input type="submit" value="Calcular Estoque">
	</form>
</body>
</html>