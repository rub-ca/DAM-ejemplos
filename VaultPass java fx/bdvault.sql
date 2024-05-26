drop database vault;
create database vault;
use vault;

create table registroPass (
	id int not null auto_increment,
    nombre varchar(255) default 'name',
    sitio varchar(400) default 'sitio',
    contraCif varchar(1000) default 'no se ha guardado ninguna contraseña',
    
    primary key(id)
)