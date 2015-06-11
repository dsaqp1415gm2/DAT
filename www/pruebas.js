/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


$(document).ready(function(){
	var url ='http://147.83.7.156:8080/dat-api/dat/Theme/Motor';
	getThreads(url);
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
	$("#get_threads").text('');

	

	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
	}).done(function(data, status, jqxhr) {
				var threads = data.threads;
				
		$.each(threads, function(i, v) {
				var thread = v;
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
//añadir post al thread correspondiente
	var url2 ='http://147.83.7.156:8080/dat-api/dat/Theme/Motor/'+thread.idthread;
	
	
	$.ajax({
		url : url2,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
	}).done(function(data, status, jqxhr) {
				var posts = data.posts

		$.each(posts, function(i, u) {
				var post = u;
				if(i==0){

				}
				else{
				$('<div class="collapse " id="'+thread.idthread+'"><div class="panel panel-success id="get_post_result>\n</div>\n</div>').appendTo($('#get_thread_result'));
				$('<div class="panel-heading">'+ post.idhilo +'</div>').appendTo($('#get_thread_result'));
				var img=document.createElement('img');
				img.setAttribute("src",post.imagelink);
				img.setAttribute("align","left");
				img.setAttribute("width","168");
				img.setAttribute("height","66");
				img.setAttribute("class","img-thumbnail");
				$(img).appendTo($('#get_thread_result'));
				$('<div class="panel-body">'+ post.content +'</div>').appendTo($('#get_thread_result'));
				
				}
				
		});
		

		});

	
		});

$('#get_thread_result').appendTo($('#get_threads'));
				
		}).fail(function() {
				$('<div class="alert alert-danger"> <strong>Oh!</strong> Error! </div>').appendTo($("#get_thread_result"));

	});

}
