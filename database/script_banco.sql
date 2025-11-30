CREATE DATABASE IF NOT EXISTS agenda_db;
USE agenda_db;

CREATE TABLE IF NOT EXISTS contato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    telefone VARCHAR(50),
    email VARCHAR(255),
    
    empresa VARCHAR(100),
    cargo VARCHAR(100),
    
    aniversario DATE,
    endereco VARCHAR(255)
);

delete from contato where id = 'null'

-- select * from contato