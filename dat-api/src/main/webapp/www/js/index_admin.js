

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
