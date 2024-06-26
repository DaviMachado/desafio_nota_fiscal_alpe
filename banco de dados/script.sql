----------------
----------------
----------------

-- Criando a tabela CLIENTE
CREATE TABLE CLIENTE (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    NOME NVARCHAR(100),
    CPF NVARCHAR(11),
    EMAIL NVARCHAR(100),
    SENHA NVARCHAR(100)
);


-- Criando a tabela NOTA_FISCAL
CREATE TABLE NOTA_FISCAL (
    ID INT IDENTITY(1,1) PRIMARY KEY,
    NUMERO_NOTA INT,
    DATA_NOTA DATETIME,
    FORMA_PAGAMENTO NVARCHAR(50),
    CLIENTE_ID INT,
    FOREIGN KEY (CLIENTE_ID) REFERENCES CLIENTE(ID)
);


-- Insert necessario do cliente
INSERT INTO CLIENTE (NOME, CPF, EMAIL, SENHA)
VALUES ('davi', '82272683070', 'davi@gmail.com', '123');


--DROP TABLE NOTA_FISCAL;
--DROP TABLE CLIENTE;






