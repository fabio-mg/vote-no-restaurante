<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="resources/ChartNew.js" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/w3.css">
<title>Batalha de Restaurantes !</title>
</head>
<body>
	<div class="w3-container w3-white">
		<img src="resources/logo.png" alt="Logo" style="width:800px;height:200px;">
	</div>
	<br><br>
	
	
	<div class="w3-container"> 
		<strong>Ranking Geral de Votos</strong>
		<br>
		<canvas id="pieGeral" width=500 height=500></canvas>
		<br>
		<strong>Ranking Pessoal de Votos - Veja em quem vocë votou mais !</strong>
		<br>
		<canvas id="pieUsuario" width=500 height=500></canvas>
		<br>
		
		
		<script src=resources/ChartNew.js></script>
		<script>
			var newoptsGer = {
				inGraphDataShow : true,
				inGraphDataRadiusPosition : 2,
				inGraphDataFontColor : 'black'
			}
			var newoptsUsu = {
					inGraphDataShow : true,
					inGraphDataRadiusPosition : 2,
					inGraphDataFontColor : 'black',
			}
			
			var pieDataGer = [ {
				value : "${votosGeral1}",
				color : "#ff0000",
				label : "${restaurante1.nome}"
			}, {
				value : "${votosGeral2}",
				color : "#1a75ff",
				label : "${restaurante2.nome}"
			}, {
				value : "${votosGeral3}",
				color : "#ffff00",
				label : "${restaurante3.nome}"
			}, {
				value : "${votosGeral4}",
				color : "#00b300",
				label : "${restaurante4.nome}"
			}, {
				value : "${votosGeral5}",
				color : "#4d0099",
				label : "${restaurante5.nome}"
			} ]
			
			var pieDataUsu = [ {
				value : "${votosUsu1}",
				color : "#ff0000",
				label : "${restaurante1.nome}"
			}, {
				value : "${votosUsu2}",
				color : "#1a75ff",
				label : "${restaurante2.nome}"
			}, {
				value : "${votosUsu3}",
				color : "#ffff00",
				label : "${restaurante3.nome}"
			}, {
				value : "${votosUsu4}",
				color : "#00b300",
				label : "${restaurante4.nome}"
			}, {
				value : "${votosUsu5}",
				color : "#4d0099",
				label : "${restaurante5.nome}"
			} ]
			var pieCtxGer = document.getElementById('pieGeral').getContext('2d');
			var pieCtxUsu = document.getElementById('pieUsuario').getContext('2d');
			
			new Chart(pieCtxGer).Pie(pieDataGer, newoptsGer);
			new Chart(pieCtxUsu).Pie(pieDataUsu, newoptsUsu);
		</script>
	</div>
</body>
</html>