function buscaAcao(campo_id_acao) {
	$.ajax({
				url:"/visualizaEvento",
				type:"POST",
				data:{
					id: campo_id_acao,
				}
			}).done(
				alert("Campo Retornado!")
			);
}

function excluiEvento(campo_id_acao) {
	$.ajax({
				url:"/excluiEvento",
				type:"POST",
				data:{
					id: campo_id_acao,
				}
			}).done(
				alert("Campo Retornado!")
			);
}
