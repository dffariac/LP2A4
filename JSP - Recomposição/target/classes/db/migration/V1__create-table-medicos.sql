CREATE TABLE clientes (

id bigint not null auto_increment,
nome varchar(100) not null,
sobrenome varchar(100) not null unique,
cpf varchar(6) not null unique,
email varchar(100) not null,

primary key(id)

);

