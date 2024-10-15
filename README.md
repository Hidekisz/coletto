# Coletto para agendamento de coleta de lixo recíclavel

## Descrição

Este projeto é uma aplicação para gerenciar dados de agendamentos de coleta de lixo reciclável. 
Foi desenvolvida utilizando **Java Spring Boot**, com o banco de dados 
**MongoDB**. A aplicação foi containerizada usando **Docker** e orquestrada com 
**Docker Compose** . Além disso, implementamos um pipeline de 
**CI/CD** utilizando **GitHub Actions**, 
com deploy automático nos ambientes de **homologacao** e **produção**.

---

## Índice

- [Descrição](#descrição)
- [Pré-requisitos](#pré-requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar o Projeto](#como-executar-o-projeto)
    - [1. Clonar o Repositório](#1-clonar-o-repositório)
    - [2. Configurar Variáveis de Ambiente](#2-configurar-variáveis-de-ambiente)
    - [3. Construir e Executar a Aplicação](#3-construir-e-executar-a-aplicação)
        - [3.1. Usando Docker](#31-usando-docker)
        - [3.2. Usando Docker Compose](#32-usando-docker-compose)
    - [4. Acessar a Aplicação](#4-acessar-a-aplicação)
- [Pipeline de CI/CD](#pipeline-de-cicd)
- [Estratégia de Containerização](#estratégia-de-containerização)
- [Orquestração com Docker Compose ou Kubernetes](#orquestração-com-docker-compose-ou-kubernetes)
- [Documentação Adicional](#documentação-adicional)
- [Autores](#autores)
- [Licença](#licença)

---

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- **Git**
- **Java JDK 17** 
- **Maven**
- **Docker**
- **Docker Compose**
- **IDE** de sua preferência (IntelliJ, Visual Studio Code, etc.)

---

## Estrutura do Projeto

- **/src**: Código-fonte da aplicação.
- **/Dockerfile**: Arquivo para construção da imagem Docker da aplicação.
- **/docker-compose.yml**: Arquivo para orquestração dos serviços com Docker Compose.
- **/.github/workflows/ci-cd.yml**: Pipeline de CI/CD configurado com GitHub Actions.
- **/README.md**: Instruções e informações sobre o projeto.
- **/pom.xml**: Arquivo de configuração do projeto.

---

## Como Executar o Projeto

### 1. Clonar o Repositório

Clone o repositório para sua máquina local usando o seguinte comando:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```
Entre no diretório do projeto
```bash
cd seu-repositorio
```

### 2. Configurar Variáveis de Ambiente
A aplicação utiliza a variável de ambiente MONGO_URI para se conectar ao banco de dados MongoDB. 
Certifique-se de configurá-la corretamente.

No Docker Compose, a variável já está definida:
```
environment:
  - MONGO_URI=mongodb://mongodb:27017/nome_do_banco
```
### 3. Construir e Executar a Aplicação
#### 3.1. Usando Docker
- Passo 1: Construir a imagem Docker da aplicação.
```bash
docker build -t hidekisz/atividadespring .
```
- Passo 2: Executar o contêiner da aplicação.
```bash
docker run -d -p 8080:8080 --name app
```
- Passo 3: Executar o contêiner do MongoDB.
```bash
docker-compose up -d
```

## Pipeline de CI/CD
Implementamos um pipeline de CI/CD usando GitHub Actions localizado em /.github/workflows/ci-cd.yml.
Funcionalidades:
- Integração contínua (CI):
  - Build automático da aplicação a cada push na branch main**
  - Execução de testes automáticos
  - Construção da imagem Docker e push para o Docker Hub

- Deploy contínuo (CD):
    - Deploy automático para o ambiente de homologação após build bem-sucedido
    - Deploy manual para o ambiente de produção via acionamento manual (workflow_dispatch)


