drop database if exists datdb;
create database datdb;
use datdb;

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
	foreign key(idtema) references theme(idtheme)
);
create table post (
	idthema		int not null,
	idhilo		int not null,
	idpost		int not null primary key,
	content		varchar(1000) not null,
	image_link	varchar(500) not null,
	foreign key(idthema) references theme(idtheme),
	foreign key(idhilo) references thread(idthread)
);


insert into theme(idtheme,nametheme,image_link) values (1,'Tecnologia','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (2,'Deportes','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (3,'Motor','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (4,'Videojuegos','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');

insert into thread(idtema,idthread,subject,content) values (1,1,'Thread1Tecno','Test1');
insert into thread(idtema,idthread,subject,content) values (1,2,'Thread2Tecno','Test2');
insert into thread(idtema,idthread,subject,content) values (1,3,'Thread3Tecno','Test3');
insert into thread(idtema,idthread,subject,content) values (2,4,'Thread1Dep','Test1');
insert into thread(idtema,idthread,subject,content) values (2,5,'Thread2Dep','Test2');
insert into thread(idtema,idthread,subject,content) values (2,6,'Thread3Dep','Test3');
insert into thread(idtema,idthread,subject,content) values (3,7,'Thread1Motor','Test1');
insert into thread(idtema,idthread,subject,content) values (3,8,'Thread2Motor','Test2');
insert into thread(idtema,idthread,subject,content) values (3,9,'Thread3Motor','Test3');
insert into thread(idtema,idthread,subject,content) values (4,10,'Thread1Video','Test1');
insert into thread(idtema,idthread,subject,content) values (4,11,'Thread2Video','Test2');
insert into thread(idtema,idthread,subject,content) values (4,12,'Thread3Video','Test3');

insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,3,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,4,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,5,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,6,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,7,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,8,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
