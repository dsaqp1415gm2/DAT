/*!
 * Bootstrap v3.3.4 (http://getbootstrap.com)
 * Copyright 2011-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */


$(document).ready(function(){
	var url ='http://147.83.7.156:8080/dat-api/dat/Theme/Tecnologia';
	getThread(url);
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

function getThread(repository_name) {
	var url ='http://147.83.7.156:8080/dat-api/dat/Theme/Tecnologia';
	$("#get_thread_result").text('');
	

	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
	}).done(function(data, status, jqxhr) {
				var threads = data.threads;
				
		$.each(threads, function(i, v) {
				var thread = v;
				$('<strong> Subject: ' + thread.subject + '<br>').appendTo($('#get_thread_result'));
				$('<strong> Content: </strong> ' + thread.content + '<br>').appendTo($('#get_thread_result'));
				var img=document.createElement('img');
				img.setAttribute("src",thread.imagen);
				img.setAttribute("width","168");
				img.setAttribute("height","66");
				img.setAttribute("class","img-thumbnail");
				$(img).appendTo($('#get_thread_result'));
 				$('<br>').appendTo($('#get_thread_result'));
				});
				

			}).fail(function() {
				$('<div class="alert alert-danger"> <strong>Oh!</strong> Repository not found </div>').appendTo($("#get_thread_result"));
	});


}
