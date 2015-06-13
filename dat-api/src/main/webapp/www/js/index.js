/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


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
    var inputpass  = $('#psw').val();
    console.log('ok'); 
    if(inputuname == "admin" && inputpass == "admin") {
      // successful validation and create cookie
      $.cookie('username', 'admin', { expires: 1 });
      var currentusr = $.cookie('username');
	console.log(currentusr);
      window.location = "index_admin.html";
	console.log('ok2');
    }
    else{
	$("#modal_error").modal();
}
}
