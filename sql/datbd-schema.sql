drop database if exists datbd;
create database datbd;

use datbd;

create table users (
	
	username	varchar(20) not null primary key,
	userpass	varchar(20),
	mail		varchar(50)
);

create table user_roles (
	username			varchar(20) not null,
	rolename 			varchar(20) not null,
	foreign key(username) references users(username) on delete cascade,
	primary key (username, rolename)
);

create table theme (
	idtheme		int not null auto_increment primary key,
	image_link	varchar(500) not null	
);

create table thread (
	idthread	int not null auto_increment primary key,
	user_default	varchar(20) not null,
	subject		varchar(100) not null,
	foreign key(idthread) references theme(idtheme) on delete cascade	
);


create table post (
	idpost		int not null auto_increment primary key,
	user_default	varchar(20) not null,
	content		varchar(1000) not null,
	image_link	varchar(500) ,
	foreign key(idpost) references thread(idthread) on delete cascade
);










insert into theme(idtheme,image_link) values (NULL,'http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into thread(idthread,user_default,subject) values (NULL,'Anonymous','Test');
insert into post(idpost,user_default,content,image_link) values (NULL,'Anonymous','prueba BD','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');




