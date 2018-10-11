Bank-poc. Aplicação que simula um banco, permite o cadastro de clientes, depósitos, saque, tranferência, consulta de saldo e extrato da conta. Foi 
utilizada a linguagem Java para o desenvolvimento do codigo, Postgre para o gerenciamento do banco de dados local, Maven para o gerenciamento das dependências e a inicializaçõa é feita com o Spring boot.

ENDPOINTS:

GET "localhost:8080/clients" retorna todos os clientes cadastrados.

GET "localhost:8080/searchClient/2" retorna o cliente de acordo com o id passado na url.

PUT "localhost:8080/client/update/2" edita o cliente de acordo com o id passado na url e os parâmetros passados em JSON no body na requisição.
Modelo body da requisição: { "accountId": 2, "name": "Maria Ferreira", "cpf": "333.333.555-98", "date_creation": "2018-09-30T00:00:00.000+0000"}

POST "localhost:8080/client/new" cadastra um novo cliente de acordo com os parâmetros passados em JSON no body na requisição.
Modelo body da requisição: { "name": "Maria Ferreira", "cpf": "333.333.555-98", "date_creation": "2018-09-30T00:00:00.000+0000"}

POST "localhost:8080/transfer" permite a tranferencia de valores entre as contas dos clientes de acordo com os parâmetros passados em JSON no body na requisição. Modelo body da requisição: { "idRecipient": 11, "idDeposit": 12, "value": 100.00 }

POST "localhost:8080/deposit" permite o deposito para o cliente de acordo com os parâmetros passados em JSON no body na requisição.
Modelo body da requisição: { "idClient": 11, "value": 200 }
 
GET "localhost:8080/balance/11" retorna o saldo na conta do cliente de acordo com o id passado na url.

POST "localhost:8080/cashOut" permite o saque na conta do cliente de acordo com o id passado na url e os parâmetros passados em JSON no body na requisição. Modelo body da requisição: { "idClient": 12, "value": -500 }

GET "localhost:8080/accountStatement/12" retorna o extrato da conta do cliente de acordo com o id passado na url.
