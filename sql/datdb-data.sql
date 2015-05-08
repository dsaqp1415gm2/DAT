source datdb-schema.sql;

insert into theme(idtheme,nametheme,image_link) values (1,'Tecnologia','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (2,'Deportes','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (3,'Motor','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into theme(idtheme,nametheme,image_link) values (4,'Videojuegos','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');

insert into thread(idtema,idthread,subject,content) values (1,1,'Thread1Tecno','Test1');
insert into thread(idtema,idthread,subject,content) values (1,2,'Thread2Tecno','Test2');
insert into thread(idtema,idthread,subject,content) values (1,3,'Thread3Tecno','Test3');
insert into thread(idtema,idthread,subject,content) values (2,1,'Thread1Dep','Test1');
insert into thread(idtema,idthread,subject,content) values (2,2,'Thread2Dep','Test2');
insert into thread(idtema,idthread,subject,content) values (2,3,'Thread3Dep','Test3');
insert into thread(idtema,idthread,subject,content) values (3,1,'Thread1Motor','Test1');
insert into thread(idtema,idthread,subject,content) values (3,2,'Thread2Motor','Test2');
insert into thread(idtema,idthread,subject,content) values (3,3,'Thread3Motor','Test3');
insert into thread(idtema,idthread,subject,content) values (4,1,'Thread1Video','Test1');
insert into thread(idtema,idthread,subject,content) values (4,2,'Thread2Video','Test2');
insert into thread(idtema,idthread,subject,content) values (4,3,'Thread3Video','Test3');

insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,1,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,2,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (1,3,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,1,'prueba BD1','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
insert into post(idthema,idhilo,idpost,content,image_link) values (2,1,2,'prueba BD2','http://www.bookofjoe.com/images/2007/03/22/pict0002hbhb_2.jpg');
