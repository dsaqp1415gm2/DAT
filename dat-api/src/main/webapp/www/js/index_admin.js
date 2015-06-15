var API_BASE_URL = "http://147.83.7.156:8080/dat-api";

$(function(){
  if($.cookie('username')) {
$(document).ready(function(){
	
});    
console.log('ok');
  }
  else{
	$("#form_login").modal();
	console.log('ok2');
  }

});

// Evento de validacion del login
$("#validar_login").click(function(){

validar();
});


// Validacion para acceder a la web secreta de admin

function validar(){
    
    var inputuname = $('#usrname').val();
	console.log(inputuname);
    var inputpass  = $('#psw').val();
	console.log(inputpass);
    var newLogin = new Object();
    newLogin.username = inputuname;
    newLogin.userpass = inputpass;

    var data = JSON.stringify(newLogin);
    console.log(data);
    
     var url = API_BASE_URL +'/dat/users/login';
	$.ajax({
		url : url,
		type : 'POST',
		crossDomain : true,
		dataType : 'json',
		contentType : 'application/vnd.dat.api.user+json',
		data : data,
		async: false
		
		
	}).done(function(data, status, jqxhr) {

		console.log('ok2');
		if(data.loginSuccessful==true){
		console.log('ok3');
		$.cookie('username', 'admin', { expires: 1 });
      		var currentusr = $.cookie('username');
     		window.location = "index_admin.html";
   		}
    		else{
		$("#modal_error").modal();
		}
					
  	}).fail(function() {
		console.log('fallo'); 
		
		
	});
    
   
}

$(document).ready(function(){
$('#cerrar_sesion').click(function(){
   
    if($.removeCookie('username')) {
      location.href = "index.html";
    }
  });
 
});

// redirigir

function redirigir(){
	console.log('ok');
	location.href = "index.html";
}
