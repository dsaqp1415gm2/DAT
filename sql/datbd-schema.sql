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
	nametheme	varchar(20) not null,
	image_link	varchar(500) not null	
);

create table thread (
	idtema		int not null,
	idthread	int not null auto_increment primary key,
	subject		varchar(100) not null,
	content		varchar(500) not null,
	foreign key(idtema) references theme(idtheme) on delete cascade	
);


create table post (
	idthema		int not null,
	idhilo		int not null,
	idpost		int not null auto_increment primary key,
	content		varchar(1000) not null,
	image_link	varchar(500) not null,
	foreign key(idthema) references thread(idtheme) on delete cascade,
	foreign key(idhilo) references thread(idthread) on delete cascade
);
