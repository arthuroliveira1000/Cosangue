function buscaAcao(campo_id_acao) {
	$.ajax({
				url:"/buscaEventoTeste",
				type:"GET",
			    data:	{
			    	id : campo_id_acao
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

function validaEvento(campo_id) {
	
	$.ajax({
		url:"/buscaEvento",
		type:"POST",
		data:{
			id: campo_id
		}
	}).done(function(resp){	
					if(!resp.id) {
						alert("Evento não encontrado!");
						} else {
					$(".mdl-oi").html("");
					$(".mdl-oi").append("<ul><li><h6>"+resp.data+"</h6><br><h6>"+resp.nome+"</h6><br><h6>"+resp.categoria+"</h6></li></ul>");
				}
			});
 	}

function validaEvento2(campo_id) {
	
	$.ajax({
		url:"/buscaEvento",
		type:"POST",
		data:{
			id: campo_id
		}
	}).done(function(resp){	
					if(!resp.id) {
						alert("Evento não encontrado!");
					} else {
						$.ajax({
							url:"/eventoEncontrado",
							type:"POST",
							data:{
								id : resp.id,
								nome : resp.nome
							}
						}).done(function(resp) {
							alert("info enviada! ");
							}
						);
				}
			});
 	}
