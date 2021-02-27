-- usuariogrupo
create table usuariogrupo
(
    id integer auto_increment,
    tipo varchar(20) not null,
    descricao varchar(20) null,
    constraint grupo_pk	primary key (id)
);

insert into agondb.usuariogrupo (tipo, descricao)
values
('ADMIN', 'ADMIN'),
('CONVIDADO', 'CONVIDADO'),
('EMPRESA', 'EMPRESA'),
('PROFISSIONAL', 'PROFISSIONAL');


-- usuario
create table usuario
(
    id int auto_increment,
    login varchar(20) not null,
    senha varchar(10) not null,
    email varchar(50) not null,
    grupo_id int not null,
    status_usr int not null,
    criacao_dt datetime not null,
    acesso_dt datetime null,
    update_dt datetime null,
    constraint usuario_email_uindex
        unique (email),
    constraint usuario_login_uindex
        unique (login),
    constraint usuario_pk primary key (id),
    constraint grupo_fk foreign key (grupo_id) references usuariogrupo (id)
);


-- telefone
create table telefone
(
    id int auto_increment,
    ddd varchar(2)  not null,
    numero varchar(9)  not null,
    tipo varchar(12) not null,
    constraint telefone_pk primary key (id),
    constraint telefone_numero_uindex unique (numero)
);


-- estado
create table estado
(
    id int auto_increment,
    nome varchar(20) not null,
    sigla varchar(2) not null,
    regiao varchar(12) not null,
    constraint estado_pk primary key (id),
    constraint estado_nome_uindex unique (nome)
);


-- cidade
create table cidade
(
    id integer auto_increment,
    nome varchar(50) not null,
    codigo varchar(10) not null,
    estado_id integer not null,
    constraint cidade_pk primary key (id),
    constraint cidade_estado_fk foreign key (estado_id) references estado (id)
);
create unique index cidade_codigo_uindex
    on cidade (codigo);


-- endereco
create table endereco
(
    id int auto_increment,
    cidade_id int not null,
    logradouro varchar(20) not null,
    moradia varchar(20) not null,
    complemento varchar(20) null,
    numero int not null,
    bairro varchar(30) not null,
    setor varchar(15) null,
    cep varchar(8) not null,
    referencia varchar(75) null,
    bloco varchar(4) null,
    andar int null,
    aptonro int null,
    constraint endereco_pk primary key (id),
    constraint endereco_cidade_fk foreign key (cidade_id) references cidade (id)
);


-- empresa
create table empresa
(
    id int auto_increment,
    nomefantasia varchar(50) not null,
    rzsocial varchar(50) null,
    cnpj varchar(15) not null,
    email varchar(30) null,
    cnae varchar(10) null,
    endereco_id int not null,
    telefone_id int not null,
    constraint empresa_pk primary key (id),
    constraint empresa_endereco_fk
        foreign key (endereco_id) references endereco (id) on update cascade on delete cascade,
    constraint empresa_telefone_fk
        foreign key (telefone_id) references telefone (id) on update cascade on delete cascade
);


-- cargo
create table cargo
(
    id int auto_increment,
    nome varchar(20) not null,
    funcao varchar(20) null,
    setor varchar(20) null,
    referencia varchar(20) null,
    descricao varchar(50) null,
    constraint cargo_pk primary key (id)
);


-- cargo_empresa
create table cargoempresa
(
    id integer auto_increment,
    cargo_id integer not null,
    empresa_id integer not null,
    constraint cargoempresa_pk primary key (id),
    constraint cargoempresa_cargo_fk
        foreign key (cargo_id) references cargo (id) on update cascade on delete cascade,
    constraint cargoempresa_empresa_fk
        foreign key (empresa_id) references empresa (id) on update cascade on delete cascade
);


-- funcionario
create table funcionario
(
    id int auto_increment,
    cargo_id int not null,
    matricula varchar(15) not null,
    nome varchar(30) not null,
    sobrenome varchar(50) not null,
    maenome varchar(30) not null,
    maesobrenome varchar(50) not null,
    estadocivil varchar(12) not null,
    sexo varchar(9) not null,
    idade int not null,
    nascimento_dt datetime not null,
    endereco_id int not null,
    telefone_id int not null,
    rgdoc varchar(15) not null,
    cpf varchar(15) not null,
    ctps varchar(15) not null,
    titulo varchar(20) not null,
    pis varchar(20) null,
    cnh varchar(20) null,
    reservista varchar(20) null,
    passaporte varchar(30) null,
    certidao_csnt varchar(40) null,
    admissao_dt datetime not null,
    demissao_dt datetime null,
    constraint funcionario_documento_certidaoCasa_uindex
        unique (certidao_csnt),
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
    constraint funcionario_pk primary key (id),
    constraint funcionario_cargo_fk
        foreign key (cargo_id) references cargo (id) on update cascade,
    constraint funcionario_endereco_fk
        foreign key (endereco_id) references endereco (id) on update cascade,
    constraint funcionario_telefone_fk
        foreign key (telefone_id) references telefone (id) on update cascade
);


-- funcionariodependente
create table funcionariodependente
(
    id int auto_increment,
    funcionario_id int not null,
    nome varchar(30) not null,
    sobrenome varchar(50) not null,
    sexo varchar(9)  not null,
    idade int not null,
    filiacao varchar(7)  not null,
    rgdoc varchar(15) null,
    cpf varchar(11) null,
    nascimento_crt varchar(20) null,
    vacinacart varchar(20) null,
    constraint funcionariodependente_pk primary key (id),
    constraint funcionariodependente_funcionario_fk
        foreign key (funcionario_id) references funcionario (id)
);


-- fabricante
create table fabricante
(
    id int auto_increment,
    nome varchar(20) null,
    codigo varchar(20) null,
    referencia varchar(20) null,
    descricao varchar(50) null,
    adicao_dt datetime not null,
    alteracao_dt datetime null,
    constraint fabricante_pk primary key (id),
    constraint fabricante_nome_uindex unique (nome)
);


-- equipamento
create table equipamento
(
    id int auto_increment,
    fabricante_id int not null,
    nome varchar(20) not null,
    marca varchar(20) null,
    modelo varchar(20) null,
    descricao varchar(50) null,
    referencia varchar(20) null,
    nroserie varchar(20) null,
    spec varchar(20) null,
    localfab varchar(20) null,
    paisfab varchar(20) null,
    fabricacao_dt datetime null,
    estrutura varchar(20) null,
    internomat varchar(20) null,
    externomat varchar(20) null,
    acabamento varchar(20) null,
    cor varchar(20) null,
    tamanho varchar(20) null,
    comprimento varchar(20) null,
    embalagem varchar(20) null,
    constraint equipamento_pk primary key (id),
    constraint equipamento_fabricante_fk
        foreign key (fabricante_id) references fabricante (id)
);


-- epi
create table epi
(
    id int auto_increment,
    nome varchar(30) not null,
    caepi varchar(30) null,
    equipamento_id int not null,
    funcionario_id int not null,
    constraint epi_pk primary key (id),
    constraint epi_fk_equipamento
        foreign key (equipamento_id) references equipamento (id),
    constraint epi_fk_funcionario
        foreign key (funcionario_id) references funcionario (id)
);


-- profissional
create table profissional
(
    id int auto_increment,
    usuario_id int not null,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    area varchar(30) not null,
    tipo varchar(30) not null,
    drt varchar(15) not null,
    sesmt int not null,
    crm varchar(15) null,
    crea varchar(15) null,
    coren varchar(15) null,
    telefone_id int null,
    constraint profissional_pk primary key (id),
    constraint profissional_usuario_fk
        foreign key (usuario_id) references usuario (id),
    constraint profissional_telefone_fk
        foreign key (telefone_id) references telefone (id)
);


-- arquivos
create table arquivo
(
    id int auto_increment,
    tipo varchar(20) not null,
    hash varchar(255) null,
    nome varchar(150) not null,
    extensao varchar(4) not null,
    tamanho integer not null,
    localizacao varchar(100) not null,
    inclusao_dt datetime not null,
    constraint arquivo_pk primary key (id)
);

-- tabela de operacoes para usuarios

