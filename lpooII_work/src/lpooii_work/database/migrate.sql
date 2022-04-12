/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  leonardozanotti
 * Created: Feb 26, 2022
 */

DROP DATABASE IF EXISTS lpooii;

CREATE DATABASE lpooii;

\c lpooii;

CREATE TABLE tb_conta (
    id_conta serial PRIMARY KEY,
    saldo_conta DOUBLE PRECISION,
    deposito_inicial_conta DOUBLE PRECISION,
    deposito_minimo_conta DOUBLE PRECISION,
    limite_conta DOUBLE PRECISION,
    montante_minimo_conta DOUBLE PRECISION,
    tipo_conta SMALLINT NOT NULL
);

CREATE TABLE tb_cliente (
    id_cliente serial PRIMARY KEY,
    nome_cliente VARCHAR(50) NOT NULL,
    sobrenome_cliente VARCHAR(50) NOT NULL,
    rg_cliente VARCHAR(15) NOT NULL,
    cpf_cliente VARCHAR(15) NOT NULL,
    endereco_cliente VARCHAR(100),
    id_conta INT,
    CONSTRAINT fk_conta FOREIGN KEY(id_conta) REFERENCES tb_conta(id_conta)
);

INSERT INTO tb_conta(deposito_inicial_conta, limite_conta, tipo_conta)
VALUES (150.0, 2500.0, 1);

INSERT INTO tb_conta(saldo_conta, deposito_minimo_conta, montante_minimo_conta, tipo_conta)
VALUES (655.25, 10.0, 300.0, 2);

INSERT INTO tb_cliente(nome_cliente, sobrenome_cliente, rg_cliente, cpf_cliente, endereco_cliente, id_conta)
VALUES ('cliente 1', 'sobrenome 1', '00001', '100000', 'endereco 1', 1);

INSERT INTO tb_cliente(nome_cliente, sobrenome_cliente, rg_cliente, cpf_cliente, endereco_cliente, id_conta)
VALUES ('cliente 2', 'sobrenome 2', '00002', '200000', 'endereco 2', 2);

INSERT INTO tb_cliente(nome_cliente, sobrenome_cliente, rg_cliente, cpf_cliente, endereco_cliente, id_conta)
VALUES ('cliente 3', 'sobrenome 3', '00003', '300000', 'endereco 3', null);