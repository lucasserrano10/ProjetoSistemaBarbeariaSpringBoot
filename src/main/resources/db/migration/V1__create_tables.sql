CREATE TABLE endereco (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    logradouro VARCHAR(120) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(60),
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(80) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL
);

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    endereco_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE barbeiro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    especialidade VARCHAR(60) NOT NULL,
    endereco_id BIGINT NOT NULL,
    CONSTRAINT fk_barbeiro_endereco FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE atendimento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora DATETIME NOT NULL,
    servico ENUM('CORTE', 'BARBA', 'SOBRANCELHA', 'CORTE_E_BARBA') NOT NULL,
    cliente_id BIGINT NOT NULL,
    barbeiro_id BIGINT NOT NULL,
    CONSTRAINT fk_atendimento_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id),
    CONSTRAINT fk_atendimento_barbeiro FOREIGN KEY (barbeiro_id) REFERENCES barbeiro(id)
);