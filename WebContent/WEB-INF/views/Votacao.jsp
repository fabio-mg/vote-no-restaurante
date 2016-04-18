<!DOCTYPE html>
<html>

<meta charset="utf-8">
<meta name="description" content="resources/ChartNew.js" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/w3.css">

<title>Batalha de Restaurantes !</title>

<head>
	<title>Batalha de Restaurantes !</title>
	
	<style>
		.button {
    		background-color: #ff6600;
    		border: none;
    		color: white;
    		padding: 20px 32px;
    		text-align: center;
    		text-decoration: none;
    		display: inline-block;
    		font-size: 20px;
    		margin: 4px 2px;
    		cursor: pointer;
    		border-radius: 12px;
		}
		
	</style>
</head>
<body>	
	<div class="w3-container w3-white">
		<img src="resources/logo.png" alt="Logo" style="width:800px;height:200px;">
	</div>
	<br><br>
	
	
	<div class="w3-row">
		<div class="w3-content">
			<form action="votar" method="post">
				Qual dos Restaurantes abaixo você gosta mais ? 
				<br>
				<br>
				 
				<input type="radio" name="opcaoSelecionada" value="${opcao1.idRestaurante}" checked> ${opcao1.nome} 
				<br>
				<br> 
				<input type="radio" name="opcaoSelecionada" value="${opcao2.idRestaurante}"> ${opcao2.nome} 
				<br> 
				<br>

				<input class="button" type="submit" name="action" value="Votar">
				
				<input type="hidden" name="opcao1" value="${opcao1.idRestaurante}" />
				<input type="hidden" name="opcao2" value="${opcao2.idRestaurante}" />
			</form>
		</div>
	</div>

</body>
</html>