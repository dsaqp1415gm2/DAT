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
	imagen		varchar(1000) not null,
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

insert into thread(idtema,idthread,subject,content,imagen) values (1,1,'Thread1Tecno','Test1','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,2,'Thread2Tecno','Test2','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,3,'Thread3Tecno','Test3','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,4,'Thread4Tecno','Test4','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,5,'Thread5Tecno','Test5','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,6,'Thread6Tecno','Test6','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,7,'Thread7Tecno','Test7','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,8,'Thread8Tecno','Test8','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,9,'Thread9Tecno','Test9','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (1,10,'Thread10Tecno','Test10','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,11,'Thread1Dep','Test1','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,12,'Thread2Dep','Test2','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,13,'Thread3Dep','Test3','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,14,'Thread4Dep','Test4','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,15,'Thread5Dep','Test5','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,16,'Thread6Dep','Test6','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,17,'Thread7Dep','Test7','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,18,'Thread8Dep','Test8','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,19,'Thread9Dep','Test9','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (2,20,'Thread10Dep','Test10','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,21,'Thread1Motor','Test1','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,22,'Thread2Motor','Test2','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,23,'Thread3Motor','Test3','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,24,'Thread4Motor','Test4','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,25,'Thread5Motor','Test5','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,26,'Thread6Motor','Test6','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,27,'Thread7Motor','Test7','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,28,'Thread8Motor','Test8','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,29,'Thread9Motor','Test9','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (3,30,'Thread10Motor','Test10','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,31,'Thread1Video','Test1','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,32,'Thread2Video','Test2','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,33,'Thread3Video','Test3','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,34,'Thread4Video','Test4','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,35,'Thread5Video','Test5','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,36,'Thread6Video','Test6','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,37,'Thread7Video','Test7','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,38,'Thread8Video','Test8','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,39,'Thread9Video','Test9','http://www.matrallune.com/images/imagen_corporativa.jpg');
insert into thread(idtema,idthread,subject,content,imagen) values (4,40,'Thread10Video','Test10','http://www.matrallune.com/images/imagen_corporativa.jpg');

insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,3,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,4,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,5,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,6,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,7,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,8,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
