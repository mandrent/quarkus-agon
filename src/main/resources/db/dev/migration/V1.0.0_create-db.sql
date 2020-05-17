-- tabela usuario
create table sec_usuario
(
    id         int auto_increment primary key,
    login      varchar(20) not null,
    senha      varchar(20) not null,
    email      varchar(50) not null,
    grupo_id   int         not null,
    status_usr int         not null,
    criacao_dt datetime    not null,
    acesso_dt  datetime    not null,
    update_dt  datetime    null,
    constraint sec_usuario_login_uindex
        unique (login)
);


-- tabela grupo | usuarios
create table sec_grupo
(
    id         int auto_increment primary key,
    descricao  varchar(15) not null,
    usuario_id int not null,
    constraint sec_usuario_fk
        foreign key (id) references sec_usuario (id)
);


-- tabela acesso
create table sec_acesso
(
    id         int auto_increment primary key,
    usuario_id int           not null,
    grupo_id   int           not null,
    adc        int default 1 not null,
    edt        int default 1 not null,
    rmv        int default 1 not null,
    vis        int default 1 not null,
    spc        int default 1 null,
    constraint sec_grp_fk
        foreign key (id) references sec_grupo (id),
    constraint sec_usr_fk
        foreign key (id) references sec_usuario (id)
);


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

