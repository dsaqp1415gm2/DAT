/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


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

$(document).ready(function(){
$('#cerrar_sesion').click(function(){
   
    if($.removeCookie('username')) {
      window.setTimeout('location.href = "index.html"', 2000); // refresh after 2 sec
    }
  });
 
});

// redirigir

function redirigir(){
	console.log('ok');
	location.href = "index.html";
}
