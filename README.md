docker build -t backoffice-db .

docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=RootPassword -e MYSQL_DATABASE=Backoffice -e MYSQL_USER=MainUser -e MYSQL_PASSWORD=MainPassword backoffice-db

Acesso Manual ao Banco
Para acessar o banco de dados, após ter executado o container é necessário executar os comandos.
$ docker exec -it container_id bash
root@container_id:/# mysql -uroot -p
Enter password: RootPassword

##Uma Aplicação Acessando o Banco
informações para acessar o banco de dados:
Nome do Banco de Dados: Backoffice;
Usuário: MainUser;
Senha: MainPassword;
Host: localhost ou IP;
Porta: 3306;


docker-compose up