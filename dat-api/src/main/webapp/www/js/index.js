var API_BASE_URL = "http://147.83.7.156:8080/dat-api";

//Abre el form del login
$(document).ready(function(){
    $("#abrir_login").click(function(){
	if($.cookie('username')){
	window.location="index_admin.html";
	}
     else{
        $("#form_login").modal();
     }
    });
});
// redirigir

function redirigir(){
	console.log('ok');
	location.href = "index.html";
}

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
