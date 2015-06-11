/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


//Abre el form del login
$(document).ready(function(){
    $("#abrir_login").click(function(){
        $("#form_login").modal();

    });
});
// redirigir

function redirigir(){
	console.log('ok');
	location.href = "index.html";
}


// Validacion para acceder a la web secreta de admin

function validar(){
    
    var inputuname = $('#usrname').val();
    var inputpass  = $('#psw').val();
    console.log('ok'); 
    if(inputuname == "admin" && inputpass == "admin") {
      // successful validation and create cookie
      $.cookie('username', 'admin', { expires: 1 });
      var currentusr = $.cookie('username');
      window.location = "index_admin.html";
    }
    else{
	$("#modal_error").modal();
}
}
