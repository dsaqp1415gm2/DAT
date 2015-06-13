/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */

var API_BASE_URL = "http://147.83.7.156:8080/dat-api";

// Carga la pagina con todos los threads y posts asociados al tema
$(document).ready(function(){
	var url = API_BASE_URL + '/dat/Theme/Videojuegos';
	getThreads(url);
});

// Abre el formulario para crear un thread
$(document).ready(function(){
    $("#Btn_form_crear_thread").click(function(){
        $("#form_crear_thread").modal();

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
      window.location = "Videojuegos_admin.html";
    }
    else{
	$("#modal_error").modal();
}
}



      
//Abre el form del login
$(document).ready(function(){
    $("#abrir_login").click(function(){
	if($.cookie('username')){
	window.location="Videojuegos_admin.html";
	}
     else{
        $("#form_login").modal();
     }
    });
});

// Animacion para subir al top de la web
$(document).ready(function() {
 
	$("a.topLink").click(function() {
	$("html, body").animate({
	scrollTop: $($(this).attr("href")).offset().top + "px"
	}, {
	duration: 500,
	easing: "swing"
	});
	return false;
	});
 
});

//Borra campos si presiona el icono close de los formularios
function borrarCampos(){
	console.log('OK');
	$("#Subject").val('');
	$("#Content").val('');	
	$("#Link").val('');
}

function borraCamposThread(idthread){
	console.log('OK');
	
	$("#Content_reply"+idthread).val('');	
	$("#link"+idthread).val('');
}


function borrarCamposPost(idpost){
	console.log('OK');
	
	$("#Content_reply_to_post"+idpost).val('');
	$("#link_reply_to_post"+idpost).val('');
}

function getThreads() {
	var url = API_BASE_URL+'/dat/Theme/Videojuegos';
	
	$("#get_thread_number").text('');
	$("#get_post_result").text('');

	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
        	async: false
	}).done(function(data, status, jqxhr) {
				threads = data.threads;

		}).fail(function() {
				$('<div class="alert alert-danger"> <strong>Oh!</strong> Error! </div>').appendTo($("#get_thread_result"));
	});
    
    $.each(threads, function(i, v) {
        var thread = v;
        var url2 = API_BASE_URL+'/dat/Theme/Videojuegos/'+thread.idthread;
	var newPost;

        $.ajax({
            url : url2,
            type : 'GET',
            crossDomain : true,
            dataType : 'json',
	    async: false
        }).done(function(data, status, jqxhr) {
            var posts = data.posts
            $(thread.idthread ).appendTo($('#get_thread_number'));
            $('<div class="panel-heading">'+ thread.subject +'</div>').appendTo($('#get_thread_result'));
            var img=document.createElement('img');
            img.setAttribute("src",thread.imagen);
            img.setAttribute("align","left");
            img.setAttribute("width","168");
            img.setAttribute("height","66");
            img.setAttribute("class","img-thumbnail");
            $(img).appendTo($('#get_thread_result'));
	    
            $('<div class="panel-body">'+ thread.content +'</div>').appendTo($('#get_thread_result'));
            $('<button type="button"  class="btn btn-success" data-toggle="collapse" data-target="#'+thread.idthread+'">Desplegar Thread</button>').appendTo($('#get_thread_result'));
	    $('<button type="button"  class="btn btn-default" id="resp'+thread.idthread+'">Responder thread</button>').appendTo($('#get_thread_result'));
	    $('<div class="collapse " id="'+thread.idthread+'"><div class="panel panel-success" id ="get_post_result'+thread.idthread+'"> </div></div>').appendTo($('#get_thread_result'));


//FORMULARIO RESPONDER THREAD

	   
	   $('<div class="modal fade" id="form_responder_thread'+thread.idthread+'" role="dialog"> <div class="modal-dialog"><div class="modal-content"><div class="modal-header2" style="padding:35px 50px;"> <button type="button" class="close" data-dismiss="modal" onclick=borraCamposThread('+thread.idthread+')  >&times;</button><h4>Responder Thread&nbsp;&nbsp;#'+thread.idthread+'</h4></div><div class="modal-body" style="padding:40px 50px;"><form action="Videojuegos.html"  onsubmit=  reply_to_thread('+thread.idthread+')> <label for="Content_reply">Content:</label><textarea class="form-control" rows="8" id="Content_reply'+thread.idthread+'" required></textarea><label for="link">url de la imagen:</label><input type="url" class="form-control" id="link'+thread.idthread+'"/> <input type="submit" class="btn btn-primary3" value="Responder" /></form></div></div></div></div>').appendTo($('#get_thread_result'));
	     

	   // funcion asociada a cada boton del thread
	  $(document).ready(function(){
           $("#resp"+thread.idthread).click(function(){
            $("#form_responder_thread"+thread.idthread).modal();
           });
           });


	
	    $("#get_post_result"+thread.idthread).text('');
            $.each(posts, function(i, u) {
		  
                   var post = u;
                   if(i==0){
                   }
                   else{		    
                    $('<div class="panel-heading"><a name="'+post.idpost+'"><button type="button" id ="btn_reply_post'+post.idpost+'">#'+ post.idpost +'</button></a></div>').appendTo($("#get_post_result"+thread.idthread));

// CREAMOS FORMULARIO PARA RESPONDER A LOS POSTS


$('<div class="modal fade" id="form_responder_post'+post.idpost+'" role="dialog"> <div class="modal-dialog"><div class="modal-content"><div class="modal-header2" style="padding:35px 50px;"> <button type="button" class="close" data-dismiss="modal" onclick=borrarCamposPost('+post.idpost+')>&times;</button><h4>Responder Post&nbsp;&nbsp;#'+post.idpost+'</h4></div><div class="modal-body" style="padding:40px 50px;"><form action="Videojuegos.html"  onsubmit=reply_to_post('+post.idhilo+','+post.idpost+')> <label for="Content_reply">Content:</label><textarea class="form-control" rows="8" id="Content_reply_to_post'+post.idpost+'"required></textarea><label for="link">url de la imagen:</label><input type="url" class="form-control" id="link_reply_to_post'+post.idpost+'"> <input type="submit" class="btn btn-primary3" value="Responde!" /></form></div></div></div></div>').appendTo($("#get_post_result"+thread.idthread));





 // funcion asociada a cada post
	  $(document).ready(function(){
           $("#btn_reply_post"+post.idpost).click(function(){
            $("#form_responder_post"+post.idpost).modal();
           });
           });
	

		   // console.log(post.imagelink);
		    if(post.imagelink==""){
		    }
		    else{
                    var img=document.createElement('img');
                    img.setAttribute("src",post.imagelink);
                    img.setAttribute("align","left");
                    img.setAttribute("width","168");
                    img.setAttribute("height","66");
                    img.setAttribute("class","img-thumbnail");
                    $(img).appendTo($("#get_post_result"+thread.idthread));
		    }
		    //$('<span id="prueba"></span>').appendTo($("#get_post_result"+thread.idthread));
                    $('<div class="panel-body">'+ post.content +'</div>').appendTo($("#get_post_result"+thread.idthread));
//$('<div class="collapse" id="'+thread.idthread+'"></div>').appendTo($('#get_thread_result')); 
		    $('<div class="collapse " id="'+thread.idthread+'"><div class="panel panel-success" id="get_post_result'+thread.idthread+'">').appendTo($('#get_thread_result')); 
                   }
                    
            });
            

        });

	
	});

}


function createThread(){

	
	var newThread = new Object();
	newThread.idtema = '4';
	newThread.subject = $("#Subject").val();
	newThread.content = $("#Content").val();
	newThread.imagen = $("#Link").val();
	var url = API_BASE_URL+'/dat/thread';
	var data = JSON.stringify(newThread);
	
	$("#create_thread_result").text('');
	
	
	
	





	$.ajax({
		url : url,
		type : 'POST',
		crossDomain : true,
		dataType : 'json',
		contentType : 'application/vnd.dat.api.thread+json',
		data : data,
		async: false
		
		
	}).done(function(data, status, jqxhr) {
		$("#form_crear_thread").modal('hide');
		$('<div class="alert alert-success">Thread creado!</div>').appendTo($("#create_thread_result"));
		//window.location="Videojuegos.html";				
  	}).fail(function() {
		$("#form_crear_thread").modal('hide');
	//prueba para ver si borra texto(debe ir despues de la funcion)
		$("#Subject").val('');
		$("#Content").val('');	
		$("#Link").val('');
		$('<div class="alert alert-success"> OK! </div>').appendTo($("#create_thread_result"));
		//window.location="Videojuegos.html";
		
	});	

}

function reply_to_thread(thread_to_reply){
	
	console.log('ok');
	var newPost = new Object();
	newPost.idthema = '4';
	newPost.idhilo= thread_to_reply;
	newPost.content = $("#Content_reply"+thread_to_reply).val();	
	console.log(newPost.content);
	newPost.imagelink = $("#link"+thread_to_reply).val();

	var url = API_BASE_URL+'/dat/thread/post';
	var data = JSON.stringify(newPost);

	$("#create_thread_result").text('');


	$.ajax({
		url : url,
		type : 'POST',
		crossDomain : true,
		dataType : 'json',
		contentType : 'application/vnd.dat.api.thread+json',
		data : data,
		async: false
		
		
	}).done(function(data, status, jqxhr) {
		$("#form_responder_thread"+thread_to_reply).modal('hide');
		$("#Content_reply"+thread_to_reply).val('');	
		$("#link"+thread_to_reply).val('');
		$('<div class="alert alert-success">Tu respuesta ha sido añadida!</div>').appendTo($("#create_thread_result"));	
		//window.location="Videojuegos.html";			
  	}).fail(function() {
		$("#form_responder_thread"+thread_to_reply).modal('hide');
	//prueba para ver si borra texto(debe ir despues de la funcion)
		
		$("#Content_reply"+thread_to_reply).val('');
		$("#link"+thread_to_reply).val('');
		$('<div class="alert alert-success"> OK! </div>').appendTo($("#create_thread_result"));
		//window.location="Videojuegos.html";
	});
}
function reply_to_post(idthread,idpost){
	var referencia= '<a href ="#'+idpost+'">#'+idpost+'</a>\t\t';
	var content = $("#Content_reply_to_post"+idpost).val();

	//$("#Content_reply_to_post"+idpost).appendTo($('#prueba'));
	console.log($('#prueba').val());
	var newPost = new Object();
	newPost.idthema = '4';
	newPost.idhilo= idthread;
	newPost.content = referencia.concat(content);	
	console.log(newPost.content);
	newPost.imagelink = $("#link_reply_to_post"+idpost).val();

	var url = API_BASE_URL+'/dat/thread/post';
	var data = JSON.stringify(newPost);

	$("#create_thread_result").text('');


	$.ajax({
		url : url,
		type : 'POST',
		crossDomain : true,
		dataType : 'json',
		contentType : 'application/vnd.dat.api.thread+json',
		data : data,
		async: false
		
		
	}).done(function(data, status, jqxhr) {
		$("#form_responder_post"+idpost).modal('hide');
		$("#Content_reply_to_post"+idpost).val('');	
		$("#link_reply_to_post"+idpost).val('');
		$('<div class="alert alert-success">Tu respuesta ha sido añadida!</div>').appendTo($("#create_thread_result"));
		//window.location="Videojuegos.html";				
  	}).fail(function() {
		$("#form_responder_post"+idpost).modal('hide');
	//prueba para ver si borra texto(debe ir despues de la funcion)
		
		$("#Content_reply_to_post"+idpost).val('');
		$("#link_reply_to_post"+idpost).val('');
		$('<div class="alert alert-success"> OK! </div>').appendTo($("#create_thread_result"));
		//window.location="Videojuegos.html";
		
	});
	
	
	
}

function funciona(){

 console.log('OK');
}
