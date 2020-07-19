-- tabela grupo_usr
create table grupo
(
	id integer auto_increment,
	tipo varchar(20) not null,
	descricao varchar(20) null,
	constraint sec_grupo_pk
		primary key (id)
);

insert into agondb.grupo (tipo, descricao)
	values
	('ADMIN', 'ADMIN'),
	('CONVIDADO', 'CONVIDADO'),
	('EMPRESA', 'EMPRESA'),
	('PROFISSIONAL', 'PROFISSIONAL');


-- tabela usuario
create table usuario
(
	idd integer auto_increment,
	login varchar(20) not null,
	senha varchar(10) not null,
	email varchar(50) not null,
	grupo_id integer not null,
	status_usr int not null,
	criacao_dt datetime not null,
	acesso_dt datetime not null,
	update_dt datetime null,
	constraint usuario_pk
		primary key (idd)
);

create unique index usuario_email_uindex
	on usuario (email);

create unique index usuario_login_uindex
	on usuario (login);





-- tabela telefone
create table telefone
(
    id     int auto_increment primary key,
    ddd    varchar(2)  not null,
    numero varchar(9)  not null,
    tipo   varchar(12) not null
);


-- tabela estado
create table estado
(
    id     int auto_increment
        primary key,
    nome   varchar(20) not null,
    sigla  varchar(2)  not null,
    regiao varchar(12) not null,
    constraint estado_nome_uindex
        unique (nome),
    constraint estado_regiao_uindex
        unique (regiao),
    constraint estado_sigla_uindex
        unique (sigla)
);


-- tabela cidade
create table cidade
(
    id        int auto_increment
        primary key,
    nome      varchar(150) not null,
    codigo    varchar(7)   null,
    estado_id char(2)      not null,
    constraint cidade_codigo_uindex
        unique (codigo),
    constraint estado_fk
        foreign key (estado_id) references estado (sigla)
);


-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

