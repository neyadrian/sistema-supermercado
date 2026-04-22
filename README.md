# 🛒 Sistema de Consulta de Produtos (TCP e UDP)

## 📌 Contexto do Sistema
Este projeto consiste em uma aplicação cliente-servidor desenvolvida em Java que permite a consulta de preços de produtos utilizando dois protocolos de comunicação em rede: TCP e UDP.

O sistema simula um servidor central que mantém um catálogo fixo de produtos e responde às requisições feitas pelos clientes.

---

## 🧱 Estrutura do Projeto

```

src/
└── src/
├── Main.java
├── ServidorTCP.java
└── ServidorUDP.java

```

---

## ⚙️ Funcionalidades

- Consulta de produtos via protocolo TCP  
- Consulta de produtos via protocolo UDP  
- Servidor central com catálogo de produtos  
- Retorno automático do preço do produto  
- Tratamento de produtos inexistentes  
- Comunicação baseada em sockets  
- Uso de threads para múltiplas conexões  

---

## 🧩 Componentes do Sistema

### 🔹 Main.java (Servidor)
- Responsável por iniciar o sistema
- Inicia:
  - Servidor TCP na porta 12000
  - Servidor UDP na porta 12001
- Mantém um catálogo de produtos utilizando `HashMap`
- Gerencia requisições dos clientes

---

### 🔹 ServidorTCP.java (Cliente TCP)
- Solicita ao usuário o nome de um produto
- Estabelece conexão com o servidor via TCP
- Envia a requisição
- Recebe e exibe o preço retornado

---

### 🔹 ServidorUDP.java (Cliente UDP)
- Solicita ao usuário o nome de um produto
- Envia requisição ao servidor via UDP
- Aguarda resposta com timeout de 2 segundos
- Exibe o preço ou mensagem de erro

---

## 🔄 Fluxo de Funcionamento

1. O servidor é iniciado (TCP e UDP simultaneamente)  
2. O cliente envia o nome de um produto  
3. O servidor busca no catálogo  
4. Retorna:
   - Preço do produto (se existir)
   - Mensagem de erro (se não encontrado)  

---

## 🌐 Protocolos Utilizados

### 🔵 TCP (Transmission Control Protocol)
- Orientado à conexão  
- Confiável (garante entrega)  
- Comunicação contínua entre cliente e servidor  

### 🟢 UDP (User Datagram Protocol)
- Não orientado à conexão  
- Mais rápido, porém sem garantia de entrega  
- Uso de timeout para controle de resposta  

---

## 🔐 Regras de Negócio

- O catálogo de produtos é fixo  
- A busca é feita pelo nome do produto  
- Caso o produto não exista, o sistema retorna uma mensagem apropriada  
- No UDP, caso não haja resposta, o cliente informa timeout  

---

## 🧠 Estruturas Utilizadas

- HashMap (armazenamento de produtos)  
- Sockets TCP e UDP  
- Threads  
- Scanner  

---

## 📚 Tecnologias Utilizadas

- Java  
- Java Networking (Sockets)  

---

## 👨‍💻 Autor
Ney Adrian

---
Projeto desenvolvido para fins acadêmicos.
