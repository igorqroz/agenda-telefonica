# 🚀 Projeto: Sistema de Gerenciamento de Contatos (POO)

Este repositório documenta o desenvolvimento do segundo trabalho da disciplina de Programação Orientada a Objetos. O objetivo principal é expandir o Sistema de Gerenciamento de Contatos, desenvolvido na primeira etapa, adicionando persistência de dados com um banco de dados **MySQL** e uma **Interface Gráfica**.

---

## 🎯 Objetivo

Aplicar os conceitos de Programação Orientada a Objetos (POO), JDBC (Java Database Connectivity) e desenvolvimento de GUI (Graphical User Interface) para criar um sistema de agenda completo e funcional.

Este projeto visa implementar as seguintes funcionalidades:
* **Herança e Polimorfismo:** Diferenciar Contatos Pessoais de Profissionais.
* **Persistência de Dados:** Conectar a um banco de dados MySQL para salvar, editar, buscar e excluir contatos.
* **Interface Gráfica:** Substituir o console por uma interface amigável (Swing ou JavaFX) para o usuário interagir com o sistema.

---

## ✨ Funcionalidades (Requisitos)

O sistema deve permitir ao usuário realizar as seguintes operações através da interface gráfica:

* **Adicionar Contato:** Permitir o cadastro de `ContatoPessoal` e `ContatoProfissional`, salvando no banco.
* **Remover Contato:** Permitir a remoção de um contato existente do banco de dados.
* **Listar Contatos:** Exibir todos os contatos armazenados em uma tabela ou lista.
* **Buscar Contato:** Oferecer uma funcionalidade de busca (por nome, telefone, etc.) que filtra e exibe os resultados.
* **Atualizar Contato:** Permitir a edição das informações de um contato já existente.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **IDE:** Apache NetBeans
* **Banco de Dados:** MySQL
* **Driver de Conexão:** JDBC (MySQL Connector/J)
* **Interface Gráfica:** Java Swing (via NetBeans GUI Builder)