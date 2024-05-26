drop database if exists portfolio ;
create database portfolio;
use portfolio;

CREATE TABLE personas (
	id_persona int not null auto_increment,
    nombre varchar(100),
    apellidos varchar(150),
    sobremi varchar (500),
    email varchar(150),
    
    primary key (id_persona)
);

CREATE TABLE lenguajes (
	id_lenguaje int not null auto_increment,
    nombre varchar(100),
    nivel int,
    id_persona int not null,
    
    primary key (id_lenguaje),
    foreign key (id_persona) references personas(id_persona)    
);

CREATE TABLE proyectos (
	id_proyecto int not null auto_increment,
    nombre varchar(100),
    descripcion varchar(500),
    imagen varchar(100),
    url varchar(100),
    id_persona int not null,
    
    primary key (id_proyecto),
    foreign key (id_persona) references personas(id_persona)    
);

CREATE TABLE relacion (
	id_relacion int not null auto_increment,
    id_lenguaje int,
    id_proyecto int,
    id_persona int,
    
    primary key (id_relacion),
    foreign key (id_lenguaje) references lenguajes(id_lenguaje),
    foreign key (id_proyecto) references proyectos(id_proyecto),
    foreign key (id_persona) references personas(id_persona)    
);

CREATE TABLE mensaje (
	id_mensaje int not null auto_increment,
    email varchar(200),
    asunto varchar(200),
    cuerpo varchar(800),
    id_persona int,
    
    primary key (id_mensaje),    
    foreign key (id_persona) references personas(id_persona)  
);

insert into personas
values(1, "Miguel", "Reguero Rodriguez", "sobremi1","miguel@gmail.com");

insert into personas
values(2, "Ruben", "Cardin Ducher", "sobremi2","ruben@gmail.com");

insert into lenguajes values(1, "Java", 3, 1);
insert into lenguajes values(2, "Html", 2, 1);
insert into lenguajes values(3, "CSS", 1, 1);

insert into lenguajes values(4, "Java", 3, 2);
insert into lenguajes values(5, "C++", 3, 2);
insert into lenguajes values(6, "Kotlin", 2, 2);

insert into proyectos
values (1, "Api spring", "Api rest creada con java spring", "1api.png", "www.google.com", 1);
insert into relacion values(1, 1, 1, 1);
insert into relacion values(2, 2, 1, 1);
insert into relacion values(3, 3, 1, 1);

insert into proyectos
values (2, "Aplicacion android", "Aplicacion basica para android hecha con kotlin", "2app.png", "www.google.com", 2);
insert into relacion values(4, 6, 2, 2);

insert into proyectos
values(3, "Comando Las", "Comando ls extendido y personalizable", "3las.png", "www.google.com", 2);
insert into relacion values(5, 5, 3, 2);

insert into proyectos
values (4, "Hilos", "Aplicacion de hilos con semaforos en java", "4hilos.png", "wwww.google.com", 2);
insert into relacion values(6, 4, 4, 2);

insert into proyectos
values (5, "Servidor TCP", "Servidor tcp desarollado en Java", "5servidor.png", "www.google.com", 1);
insert into relacion values (7, 1, 5, 1);
