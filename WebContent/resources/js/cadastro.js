var contEnd = 0;
var contTel = 0;
var tiposEndereco;
var tiposPhones;

$(document).ready(function() {
	carregarTipos();
	
    $("span.add-phone").on('click',function(){
    	contTel++;
    	$("#telefones").append(
    		'<div class="form-group" class="phone" data-seq="'+(contTel+1)+'">'+
    		    '<div class="row">'+
    		        '<div class="col-md-3">'+
    		            '<input type="text" class="form-control" name="telefones['+contTel+'].ddd" id="ddd" placeholder="DDD">'+
    		        '</div>'+
    		        '<div class="col-md-5">'+
    		            '<input type="text" class="form-control" name="telefones['+contTel+'].numero" id="numero" placeholder="Número">'+
    		        '</div>'+
    		        '<div class="col-md-3">'+
    		            '<select name="telefones['+contTel+'].tipo" class="form-control" >'+
    		                carregarOptions(tiposPhones)+
    		            '</select>'+
    		        '</div>'+
    		        '<div class="col-md-1">'+
    		            '<span class="btn btn-danger excluir">Excluir</span>'+
    		        '</div>'+
    		    '</div>'+
    		'</div>'
    	)
    });
    
    $("span.add-endereco").on('click',function(){
    	contEnd++;
    	$("#enderecos").append(
    		'<div class="form-group endereco well" data-seq="'+(contEnd+1)+'">'+
    			'<br>'+
    		    '<div class="row">'+
    		        '<div class="col-md-12" style="margin-bottom: 15px">'+
    		            '<div class="row">'+
    		                '<div class="col-md-2">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].cep" id="cep" placeholder="CEP">'+
    		                '</div>'+
    		                '<div class="col-md-5">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].logradouro" id="logradouro" placeholder="Logradouro">'+
    		                '</div>'+
    		                '<div class="col-md-1">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].numero" id="numero" placeholder="N°">'+
    		                '</div>'+
    		                '<div class="col-md-4">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].complemento" id="complemento" placeholder="Complemento">'+
    		                '</div>'+
    		            '</div>'+
    		        '</div>'+
    		        '<br><br>'+
    		        '<div class="col-md-12">'+
    		            '<div class="row">'+
    		                '<div class="col-md-3">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].bairro" id="bairro" placeholder="Bairro">'+
    		                '</div>'+
    		                '<div class="col-md-3">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].cidade" id="cidade" placeholder="Cidade">'+
    		                '</div>'+
    		                '<div class="col-md-3">'+
    		                    '<input type="text" class="form-control" name="enderecos['+contEnd+'].estado" id="estado" placeholder="Estado">'+
    		                '</div>'+
    		                '<div class="col-md-2">'+
    		                    '<select name="enderecos['+contEnd+'].tipoEndereco" class="form-control" >'+
    		                    	carregarOptions(tiposEndereco)+
    		                    '</select>'+
    		                '</div>'+
    		                '<div class="col-md-1">'+
    		                    '<span class="btn btn-danger excluir">Excluir</span>'+
    		                '</div>'+
    		            '</div>'+
    		        '</div>'+
    		    '</div>'+
    		'</div>'
    	);
    });
    
    $(document).on('click',"span.excluir",function(){
    	$(this).parents(".form-group").fadeOut('fast',function(){
    		$(this).remove();
    	});
    });
    
    $(document).on('blur',"#cep",function(){
    	if($(this).val().length < 8){
    		alert("CEP inválido");
    		return;
    	}
    		
    	var parent = $(this).parents(".form-group");
    	$.ajax({
		  method: "GET",
		  url: 'http://api.postmon.com.br/v1/cep/'+$(this).val(),
		  dataType: "application/json",
		  statusCode: {
			  200: function(data) {
				  address = JSON.parse(data.responseText);
				  $("#logradouro", parent).val(address.logradouro);
				  $("#bairro", parent).val(address.bairro);
				  $("#cidade", parent).val(address.cidade);
				  $("#estado", parent).val(address.estado);
			  }, // Ok
    		  400: function(msg) { alert("Erro ao buscar CEP!");  }, // Bad Request
		      404: function(msg) { alert("CEP não encontrado!!"); } // Not Found
		  }
    	});
    })
});

function carregarOptions(obj){
	var str = '';
	$.each(obj,function(i, val){
		str += "<option>"+val+"</option>";
	});
	return str;
}

function carregarTipos(){
	tiposEndereco = JSON.parse($.ajax({
	  method: "GET",
	  url: '/CantinaIgreja/enderecos/tipos',
	  dataType: "application/json",
	  async : false
	}).responseText);
	
	
	tiposPhones = JSON.parse($.ajax({
	  method: "GET",
	  url: '/CantinaIgreja/telefones/tipos',
	  dataType: "application/json",
	  async : false
	}).responseText);
	
}