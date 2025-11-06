-- Inserindo endereços
INSERT INTO endereco (logradouro, numero, complemento, bairro, cidade, estado, cep)
VALUES
('Rua das Palmeiras', '123', 'Casa 1', 'Centro', 'São Paulo', 'SP', '01000-000'),
('Av. Brasil', '456', 'Sala 202', 'Jardim América', 'São Paulo', 'SP', '01400-000'),
('Rua do Sol', '789', NULL, 'Boa Vista', 'Recife', 'PE', '50030-000');

-- Inserindo clientes
INSERT INTO cliente (nome, email, telefone, endereco_id)
VALUES
('Lucas Serrano', 'lucas.serrano@email.com', '(11) 99999-1111', 1),
('Marcos Almeida', 'marcos.almeida@email.com', '(11) 98888-2222', 2);

-- Inserindo barbeiros
INSERT INTO barbeiro (nome, email, telefone, especialidade, endereco_id)
VALUES
('Carlos Barber', 'carlos.barbeiro@email.com', '(11) 97777-3333', 'Cortes Clássicos', 3),
('Pedro Fade', 'pedro.fade@email.com', '(11) 96666-4444', 'Cortes Modernos', 2);

-- Inserindo atendimentos
INSERT INTO atendimento (data_hora, servico, cliente_id, barbeiro_id)
VALUES
('2025-11-07 10:00:00', 'CORTE', 1, 1),
('2025-11-07 11:00:00', 'BARBA', 2, 2),
('2025-11-07 12:00:00', 'CORTE_E_BARBA', 1, 2);
