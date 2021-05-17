drop database if exists rest1;
create database rest1;
 use rest1;
   create table cliente(idCliente int primary key auto_increment,
   nome varchar (50), email varchar (50) unique);
   insert into cliente values (null,'diego','diego@gmail.com');
   insert into cliente values (null,'jhon','jhon@gmail.com');
   insert into cliente values (null,'tahlita pug','thalitapug@gmail.com');
   insert into cliente values (null,'loide','loide@gmail.com');

 select * from cliente;

 
