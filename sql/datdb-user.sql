drop user 'dat'@'localhost';
create user 'dat'@'localhost' identified by 'dat';
grant all privileges on datdb.* to 'dat'@'localhost';
flush privileges;