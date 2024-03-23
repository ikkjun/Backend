create database chap14 default character set utf8mb4;

create user 'jspexam'@'localhost' IDENTIFIED BY 'jsppw';
grant all privileges on chap14.* to 'jspexam'@'localhost';

create user 'jspexam'@'%'identified by 'jsppw';
grant all privileges on chap14.* to 'jspexam'@'%';

