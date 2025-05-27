# Problema e Solução:
As queimadas afetam áreas regiões, estados e municípios, por isso pensamos em criar uma API que pode tanto listar todos os dados contidos no banco, para quesitos de relatório, como também contém uma filtragem por município, podendo gerar relatórios específicos para cada região do Brasil

# Arquitetura:
Usando do método restful criamos um código que consiste de 6 pacotes:
-Config: Usado para classes de configuração básica da API;
-Controllers: Usado para classes que controlaram a interação com o usuário;
-Entities: Pacote usado para as classes objetos da API;
-Repositories: Cuida das relações transacionais do código com o banco de dados;
-Security: Toda a estrutura de segurança e autenticação da API;
-Services: A parte que cuida de gerar os métodos usados pela API para busca e criação de dados no banco. 

# Instruções:
- Ter o Java baixado no pc;
- Fazer o download da branch master;
- Usar a IDE InteliJ;
- Entrar no código e clicar o botão de play no topo do direito do InteliJ;
- Observar o console, após ele finalizar de rodar tudo;
- Usar os links abaixo no app do postman para poder rodar certas seções da API;

# Links para usar no postman:
## POST:
- Geração do token: http://localhost:8080/v1/auth/login?username=sudo&password=12345
- Adição de novos dados: http://localhost:8080/v1/dados
## Get:
- Listagem dos dados geral: http://localhost:8080/v1/dados
- Listagem dos dados por municipio: http://localhost:8080/v1/dados/municipio=<municipio desejado>
