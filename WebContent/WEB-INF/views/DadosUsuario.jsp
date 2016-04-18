<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/w3.css">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>Batalha de Restaurantes !</title>
	
	<style>
		img {
    		width: 100%;
   	 		height: auto;
		}
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
			<form name="frm" action="confirmaDados" method="post" onsubmit="return validaDados()">
				Precisamos que você informe os dados abaixo para computar os seus votos ! 
				<br>
				<br>
				<strong>Nome:</strong> 
				<br>
				<input type="text" name="nome" size="100"> 
				<br>
				<br>
	
				<strong>E-Mail:</strong> 
				<br>
				<input type="text" name="email" size="85"> <br>
				
				<input class="button" type="submit" name="action" value="Confirmar">  
			</form>
		</div>
	</div>


	<script type="text/javascript">
		function validaDados() {
			if (document.frm.nome.value.trim() == "" || document.frm.email.value.trim() == "") {
				alert("Campos Nome e E-mail devem ser preenchidos para computar Votos !");
				document.frm.nome.focus();
				return false;
			} else { 
				return true;
			}
		}
	</script>

</body>
</html>