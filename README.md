🛒 Sistema de Consulta de Produtos (TCP e UDP)

Este projeto é uma aplicação simples em Java que implementa comunicação cliente-servidor utilizando dois protocolos de rede:

🔵 TCP (Transmission Control Protocol)
🟢 UDP (User Datagram Protocol)

O sistema permite consultar o preço de produtos a partir de um servidor central.

📌 Funcionalidades
Consulta de produtos via TCP
Consulta de produtos via UDP
Servidor com lista fixa de produtos
Resposta automática com o preço ou mensagem de erro
🧱 Estrutura do Projeto

O projeto é composto por 3 classes principais:

🔹 Main.java

Responsável por iniciar o servidor:

Inicia o servidor TCP na porta 12000
Inicia o servidor UDP na porta 12001
Mantém um catálogo de produtos com preços
🔹 ServidorTCP.java

Cliente TCP:

Solicita ao usuário o nome de um produto
Envia a requisição ao servidor via TCP
Exibe o preço retornado
🔹 ServidorUDP.java

Cliente UDP:

Solicita ao usuário o nome de um produto
Envia a requisição ao servidor via UDP
Aguarda resposta com timeout de 2 segundos
🛍️ Produtos Disponíveis
Produto	Preço (R$)
ARROZ	25.00
CAFE	16.50
LEITE	6.00
🚀 Como Executar
1️⃣ Compile os arquivos
javac Main.java ServidorTCP.java ServidorUDP.java
2️⃣ Inicie o servidor
java Main

Você verá:

Servidor TCP iniciado na porta 12000.
Servidor UDP iniciado na porta 12001.
3️⃣ Execute o cliente TCP
java ServidorTCP

Digite um produto:

Digite o produto (TCP): arroz
Preço: 25.00
4️⃣ Execute o cliente UDP
java ServidorUDP

Digite um produto:

Digite o produto (UDP): cafe
Preço: 16.50
⚠️ Observações
Os nomes dos produtos não são sensíveis a maiúsculas/minúsculas
Caso o produto não exista, o sistema retorna:
Não encontrado.
No UDP, pode ocorrer timeout:
Resposta não recebida.
📚 Conceitos Aplicados
Programação em Java
Sockets de rede
Comunicação TCP vs UDP
Threads
Estruturas de dados (HashMap)
