# acervo
-O projeto foi moldado na arquitetura mvc, no padrão de projeto Rest API.
-Utilizei o framework Spring boot para construir um CRUD em que seus endpoints foram moldados em cima de duas principais entidades: Livro e Autor.
Ambos possuem os métodos POST, GET, PUT e DELETE, especificados no pacote do controller e seguindo as regras de negócio pedidas e desenvolvidas no pacote da service. 
Além disso, foram feitos tratamentos de possíveis exceções com classes definidas para cada Exception e um retorno adequado para cada uma através de um ExceptionHandle.
-O banco relacional utilizado para armazenar os dados da API foi o MySQL.
-API foi containerizada para economizar recursos e fácil execução do projeto. Foi usado o Docker para esse processo.
Para iniciar o projeto: basta entrar na pasta raiz (acervo) e dar o comando "docker-compose up".
É necessário ter a porta 3306 e 8080 liberadas para execução no banco de dados e da aplicação.
Necessário também ter o docker instalado na máquina.
