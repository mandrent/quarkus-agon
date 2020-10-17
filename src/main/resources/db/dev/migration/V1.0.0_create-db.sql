-- grupousuario
create table grupousuario
(
	idgrp integer auto_increment,
	tipo varchar(20) not null,
	descricao varchar(20) null,
	constraint sec_grupo_pk	primary key (idgrp)
);

insert into agondb.grupousuario (tipo, descricao)
	values
	('ADMIN', 'ADMIN'),
	('CONVIDADO', 'CONVIDADO'),
	('EMPRESA', 'EMPRESA'),
	('PROFISSIONAL', 'PROFISSIONAL');


-- usuario
create table usuario
(
	idusr integer auto_increment,
	login varchar(20) not null,
	senha varchar(10) not null,
	email varchar(50) not null,
	grupo_id integer not null,
	status_usr int not null,
	criacao_dt datetime not null,
	acesso_dt datetime not null,
	update_dt datetime null,
	constraint usuario_pk
		primary key (idusr)
);
create unique index usuario_email_uindex
	on usuario (email);
create unique index usuario_login_uindex
	on usuario (login);


-- telefone
create table telefone
(
    idtel  int auto_increment primary key,
    ddd    varchar(2)  not null,
    numero varchar(9)  not null,
    tipo   varchar(12) not null,
    constraint telefone_numero_uindex unique (numero)
);


-- estado
create table estado
(
    idstd  int auto_increment primary key,
    nome   varchar(20) not null,
    sigla  varchar(2)  not null,
    regiao varchar(12) not null,
    constraint estado_nome_uindex unique (nome)
);


-- cidade
create table cidade
(
	idcdd integer auto_increment,
	nome varchar(50) not null,
	codigo varchar(10) not null,
	estado_id integer not null,
	constraint cidade_pk primary key (idcdd),
	constraint cidade_fk_estado foreign key (estado_id) references estado (idstd)
);
create unique index cidade_codigo_uindex
	on cidade (codigo);


-- endereco
create table endereco
(
    iddrc          int auto_increment primary key,
    logradouro     int         not null,
    numero         int         not null,
    complemento_id int         not null,
    bairro         varchar(30) not null,
    setor          varchar(15) null,
    cep            varchar(8)  not null,
    cidade_id      int         not null,
    constraint fk_cidade foreign key (cidade_id) references cidade (idcdd)
);


-- enderecocomplemento
create table enderecocomplemento
(
    iddrcmpt int auto_increment primary key,
    endereco_id       int not null,
    localidade        varchar(10) not null,
    logradouro_cmpt   varchar(10) not null,
    moradia           varchar(12) null,
    referencia        varchar(75) null,
    bloco             varchar(4)  null,
    andar             int         null,
    numero            int         null,
    constraint fk_endereco foreign key (endereco_id) references endereco (iddrc)
        on update cascade on delete cascade
);


-- empresa
create table empresa
(
    idemp int auto_increment primary key,
    nomefantasia varchar(50) not null,
    rzsocial     varchar(50) null,
    cnpj         varchar(15) not null,
    email        varchar(30) null,
    cnae         varchar(10) null,
    endereco_id  int not null,
    telefone_id  int not null,
    constraint empresa_fk_endereco
        foreign key (endereco_id) references endereco (iddrc)
            on update cascade on delete cascade,
    constraint empresa_fk_telefone
        foreign key (telefone_id) references telefone (idtel)
            on update cascade on delete cascade
);


-- setorempresa
create table setorempresa
(
	idstremp integer auto_increment,
	empresa_id integer not null,
	nome varchar(20) not null,
	descricao varchar(50) null,
	constraint setorempresa_pk primary key (idstremp),
	constraint setorempresa_fk_empresa
	    foreign key (empresa_id) references empresa (idemp)
	        on update cascade on delete cascade
);


-- cargo
create table cargo
(
    idcrg int auto_increment primary key,
    setor_id   int not null,
    nome       varchar(20) not null,
    funcao     varchar(20) null,
    referencia varchar(20) null,
    descricao  varchar(50) null,
    constraint crg_fk_setor foreign key (setor_id) references setorempresa (idstremp)
);


-- funcionario
create table funcionario
(
    idfnc int auto_increment primary key,
    endereco_id int         not null,
    telefone_id int         not null,
    cargo_id    int         not null,
    matricula   varchar(15) not null,
    admissao_dt datetime    not null,
    demissao_dt datetime    null,
    constraint funcionario_fk_cargo
        foreign key (cargo_id) references cargo (idcrg)
            on update cascade,
    constraint funcionario_fk_endereco
        foreign key (endereco_id) references endereco (iddrc)
            on update cascade,
    constraint funcionario_fk_telefone
        foreign key (telefone_id) references telefone (idtel)
            on update cascade
);


-- funcionariodependente
create table funcionariodependente
(
    id  int auto_increment primary key,
    funcionario_id int not null,
    nome           varchar(30) not null,
    sobre_nome     varchar(50) not null,
    sexo           varchar(9)  not null,
    idade          int  not null,
    filiacao       varchar(7)  not null,
    rgdoc          varchar(15) null,
    cpf            varchar(11) null,
    nasc_crt       varchar(20) not null,
    casa_crt       varchar(20) null,
    vacina_crt    varchar(20) null,
    constraint funcdpnt_fk_funcionario
        foreign key (funcionario_id) references funcionario (idfnc)
);


-- funcionariodocumento
create table funcionariodocumento
(
    id int auto_increment primary key,
    funcionario_id int not null,
    nome           varchar(30) not null,
    sobrenome     varchar(50) not null,
    maenome      varchar(30) not null,
    maesobrenome    varchar(50) not null,
    estado_cvl     varchar(12) not null,
    sexo           varchar(9)  not null,
    idade          int not null,
    nascimento_dt  datetime not null,
    rgdoc          varchar(15) not null,
    cpf            varchar(15) not null,
    ctps           varchar(15) not null,
    titulo         varchar(20) not null,
    pis            varchar(20) null,
    cnh            varchar(20) null,
    reservista     varchar(20) null,
    passaporte     varchar(30) null,
    certidao_csmnt varchar(40) null,
    constraint funcionario_documento_certidaoCasa_uindex
        unique (certidao_csmnt),
    constraint funcionario_documento_cnh_uindex
        unique (cnh),
    constraint funcionario_documento_cpf_uindex
        unique (cpf),
    constraint funcionario_documento_ctps_uindex
        unique (ctps),
    constraint funcionario_documento_passaporte_uindex
        unique (passaporte),
    constraint funcionario_documento_pis_uindex
        unique (pis),
    constraint funcionario_documento_reservista_uindex
        unique (reservista),
    constraint funcionario_documento_rgdoc_uindex
        unique (rgdoc),
    constraint funcionario_documento_titulo_uindex
        unique (titulo),
    constraint funcdoc_fk_funcionario
        foreign key (funcionario_id) references funcionario (idfnc)
);


-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

-- tabela de operacoes para usuarios

