/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */

// Dropdown Menu
var dropdown = document.querySelectorAll('.dropdown');
var dropdownArray = Array.prototype.slice.call(dropdown,0);
dropdownArray.forEach(function(el){
	var button = el.querySelector('a[data-toggle="dropdown"]'),
			menu = el.querySelector('.dropdown-menu'),
			arrow = button.querySelector('i.icon-arrow');

	button.onclick = function(event) {
		if(!menu.hasClass('show')) {
			menu.classList.add('show');
			menu.classList.remove('hide');
			arrow.classList.add('open');
			arrow.classList.remove('close');
			event.preventDefault();
		}
		else {
			menu.classList.remove('show');
			menu.classList.add('hide');
			arrow.classList.remove('open');
			arrow.classList.add('close');
			event.preventDefault();
		}
	};
})

Element.prototype.hasClass = function(className) {
    return this.className && new RegExp("(^|\\s)" + className + "(\\s|$)").test(this.className);
};





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
}
$(document).ready(function(){
$('#cerrar_sesion').click(function(){
   
    if($.removeCookie('username')) {
      window.setTimeout('location.href = "index.html"', 2000); // refresh after 2 sec
    }
  });
 
});
