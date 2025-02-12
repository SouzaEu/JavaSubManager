# 📁 Gerenciador de Assinaturas

## 📝 Descrição

Este projeto é uma aplicação em Java para gerenciamento de usuários e assinaturas. Utiliza conceitos de Domain Driven Design (DDD), API REST e manipulação de banco de dados. A aplicação permite o cadastro, autenticação e gerenciamento de usuários e assinaturas.

## 🌟 Funcionalidades

### 👤 Usuários:
- Cadastro de novos usuários
- Autenticação com email e senha
- Atualização e exclusão de dados de usuário

### 📄 Assinaturas:
- Registro de assinaturas vinculadas a usuários
- Atualização e exclusão de assinaturas

### 🌐 API REST:
- Endpoints para todas as operações de CRUD
- Configuração de CORS para permitir requisições externas

### 💾 Banco de Dados:
- Persistência de dados utilizando Oracle
- Relacionamento entre as tabelas de Usuários e Assinaturas

## 🛠 Tecnologias Utilizadas

- **Linguagem:** Java
- **Frameworks/Bibliotecas:**
  - Jersey (para API REST)
  - Grizzly (servidor HTTP)
- **Banco de Dados:** Oracle SQL
- **Padrões e Arquitetura:** Domain Driven Design (DDD)

## 🚀 Configuração do Projeto

1. **Clone o repositório:**
   bash
   git clone <(https://github.com/SouzaEu/EcoEnergy/)>
   

2. **Instale as dependências:**
   bash
   mvn install
   

3. **Configure o banco de dados:**
   - Crie as tabelas no Oracle conforme o diagrama relacional incluído no projeto.
   - Ajuste as credenciais de conexão no arquivo `ConnectionFactory`.

4. **Execute o servidor:**
   - Compile o projeto e inicie o servidor HTTP via classe `Main`.

## 📂 Estrutura de Pacotes

- `br.com.fiap.bo`: Contém a lógica de negócio do sistema, como validações e interações entre DAO e recursos.
- `br.com.fiap.dao`: Responsável pela comunicação com o banco de dados.
- `br.com.fiap.model`: Classes que representam as entidades do sistema (Usuário, Assinatura).
- `br.com.fiap.resource`: Endpoints expostos via API REST.
- `br.com.fiap.util`: Utilitários como conexão com o banco de dados e filtros.

