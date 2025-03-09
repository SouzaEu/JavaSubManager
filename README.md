# 📁 Java Subscription Manager

## 📌 Descrição

O **Java Subscription Manager** é uma aplicação desenvolvida em **Java** para gerenciamento de usuários e assinaturas. O projeto implementa **Domain-Driven Design (DDD)**, **REST API**, e persistência de dados com **Oracle SQL**.

## ✨ Funcionalidades

### 👤 Gerenciamento de Usuários
- Cadastro de novos usuários
- Autenticação via e-mail e senha
- Atualização e remoção de dados do usuário

### 📄 Gerenciamento de Assinaturas
- Cadastro de assinaturas vinculadas aos usuários
- Atualização e exclusão de assinaturas

### 🌐 API REST
- Endpoints para todas as operações CRUD
- Configuração CORS para permitir requisições externas

### 💾 Banco de Dados
- Persistência de dados utilizando **Oracle SQL**
- Relacionamento entre tabelas **Users** e **Subscriptions**

## 🛠 Tecnologias Utilizadas

- **Linguagem:** Java
- **Frameworks e Bibliotecas:**
  - Jersey (para API REST)
  - Grizzly (servidor HTTP)
- **Banco de Dados:** Oracle SQL
- **Padrões e Arquitetura:** Domain-Driven Design (DDD)

## 🚀 Configuração do Projeto

### 1. Clonar o repositório
```sh
git clone https://github.com/SouzaEu/JavaSubManager.git
cd JavaSubManager
```

### 2. Configurar o Banco de Dados
1. Certifique-se de que o Oracle SQL esteja instalado.
2. Configure as credenciais no arquivo `application.properties`.

### 3. Executar a Aplicação
```sh
mvn clean install
java -jar target/JavaSubManager.jar
```

## 📌 Contribuição
Contribuições são bem-vindas! Siga estes passos:
1. Faça um fork do projeto
2. Crie um branch para sua feature (`git checkout -b minha-feature`)
3. Commit suas modificações (`git commit -m 'Adicionando nova funcionalidade'`)
4. Envie para o branch principal (`git push origin minha-feature`)
5. Abra um Pull Request

## 📄 Licença
Este projeto é distribuído sob a Licença MIT. Para mais detalhes, consulte o arquivo `LICENSE`.

