/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


$(document).ready(function(){
	var url ='http://147.83.7.156:8080/dat-api/dat/Theme/Motor';
	getThreads(url);
});

$(document).ready(function(){
    $("#Btn_crear_thread").click(function(){
        $("#form_crear_thread").modal();
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

function getThreads() {
	var url ='http://147.83.7.156:8080/dat-api/dat/Theme/Motor';
	
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
        var url2 ='http://147.83.7.156:8080/dat-api/dat/Theme/Motor/'+thread.idthread;

        $.ajax({
            url : url2,
            type : 'GET',
            crossDomain : true,
            dataType : 'json',
	    async: false
        }).done(function(data, status, jqxhr) {
            var posts = data.posts
            $(thread.idthread ).appendTo($('#get_thread_number'));
            $('<div class="panel-heading">'+ thread.subject +'\t'+thread.idthread+'</div>').appendTo($('#get_thread_result'));
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
	   $('<div class="modal fade" id="form_responder_thread'+thread.idthread+'" role="dialog"> <div class="modal-dialog"><div class="modal-content"><div class="modal-header2" style="padding:35px 50px;"> <button type="button" class="close" data-dismiss="modal">&times;</button><h4><span class="glyphicon glyphicon-plus-sign"></span>Responder Thread&nbsp;&nbsp;#'+thread.idthread+'</h4></div><div class="modal-body" style="padding:40px 50px;"><form role="form"> <div class="form-group"><label for="Subject">Content:</label><textarea class="form-control" rows="8" id="Content"></textarea></div><div class="form-group"><label for="link">url de la imagen:</label><input type="url" class="form-control" id="link"></div></form> <button type="submit" class="btn btn-primary3">Responde!</button></form></div></div></div></div>').appendTo($('#get_thread_result'));
	     

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
                    $('<div class="panel-heading">'+ post.idpost +'</div>').appendTo($("#get_post_result"+thread.idthread));
                    var img=document.createElement('img');
                    img.setAttribute("src",post.imagelink);
                    img.setAttribute("align","left");
                    img.setAttribute("width","168");
                    img.setAttribute("height","66");
                    img.setAttribute("class","img-thumbnail");
                    $(img).appendTo($("#get_post_result"+thread.idthread));
                    $('<div class="panel-body">'+ post.content +'</div>').appendTo($("#get_post_result"+thread.idthread));
//$('<div class="collapse" id="'+thread.idthread+'"></div>').appendTo($('#get_thread_result')); 
		    $('<div class="collapse " id="'+thread.idthread+'"><div class="panel panel-success" id="get_post_result'+thread.idthread+'">').appendTo($('#get_thread_result')); 
                   }
                    
            });
            

        });

	
	});

}
