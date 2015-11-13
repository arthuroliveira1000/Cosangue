function abreFichaTecnica() {
	var nomeInformado = document.getElementById("nomePesquisa").value;
	$.ajax({
				url:"/buscaFilme",
				type:"POST",
				data:{
					nome: nomeInformado
				}
			}).done(function(res) {
				$(".biblioteca").html("");
					$(".biblioteca").append("<ul><li><h2>Ficha Técnica</h2><img src="+res.capaDoFilme+"></br><h3>"+res.nome+"</h3><h4>"+res.anoLancamento+"</h4><h4>"+res.sinopse+"</h4></li></ul>");
				}
			);
}
function validaFormRegistro() {
	var formulario = document.form_registro; 
	if(formulario.nome.value == "" || formulario.apelido.value == "" || formulario.login.value == "" || formulario.senha.value =="") {
		alert("Preencha todos os campos!");
	} else {
		formulario.submit();
		}
}
function avaliaFilme(campo_id_filme, campo_nota) {
	$.ajax({
				url:"/avalia",
				type:"POST",
				data:{
					id_filme: campo_id_filme,
					nota: campo_nota
				}
			}).done(
				alert("Avaliação salva!")
			);
}
function buscaMediaGeral(campo_id_filme) {
	$.ajax({
				url:"/mediaGeral",
				type:"POST",
				data:{
					id_filme: campo_id_filme,
				}
			}).done(function(res) {
				alert("DEU CERTO")
			
			});
}

function validaFormulario() {
	var formulario = document.form_cadastro;
	var testaAnoLancamento = isNaN(formulario.anoLancamento.value);
	
		if(formulario.nome.value == "" || formulario.sinopse.value =="" || formulario.genero.value=="" || formulario.anoLancamento.value=="" || formulario.capaDoFilme.value =="") {
			alert("Preencha todos os campos!");
			} else if(testaAnoLancamento && formulario.anoLancamento !== "") {
				alert("Ano de lançamento inválido!");
				formulario.anoLancamento.value = "";
				formulario.anoLancamento.focus();
			} else {
				document.form_cadastro.submit();
			}
}
function validaFormularioPesquisa() {
	var nomeInformado = document.getElementById("nomePesquisa").value;
	if(nomeInformado == "") {
		alert("Preencha o campo de pesquisa!");
		} else {
			$.ajax({
				url:"/buscaFilme",
				type:"POST",
				data:{
					nome: nomeInformado
				}
			}).done(function(resp){	
					if(!resp.nome) {
						alert("Filme não encontrado!");
						} else {
					$("#listaDeFilmesCadastrados").html("");
					$("#listaDeFilmesCadastrados").append("<ul><li><h2>Ficha Técnica</h2><img src="+resp.capaDoFilme+"></br><h3>"+resp.nome+"</h3><h4>"+resp.anoLancamento+"</h4><h4>"+resp.sinopse+"</h4></li></ul>");
				}
			});
		}
}
function validaFormularioExclusao() {
	var nomeInformado = document.getElementById("nomeFilmeExcluido").value;
	if(nomeInformado == "") {
		alert("Preencha o nome do filme!");
		} else {
			$.ajax({
				url:"/buscaFilme",
				type:"POST",
				data:{
					nome: nomeInformado
				}
			}).done(function(resp){	
					if(!resp.nome) {
						alert("Filme não encontrado!");
						} else {
						$.ajax({
						url:"/excluir",
						type:"POST",
						data:{
							id_filme: resp.id_filme
						}
					}).done(function(resp) {
						$("#boxListaDeFilmes").html(resp);
						alert("Filme excluído com sucesso!");
						}
					);
				}
			});
		}
}
function validaFormidentificacao() {
	var formulario = document.form_identificacao;
	if(formulario.login.value() =="") {
		alert("Preencha seu login!");
	} if(formulario.senha.value == "") {
		alert("Preencha sua senha");
		} else {
			formulario.submit();
		}
}





