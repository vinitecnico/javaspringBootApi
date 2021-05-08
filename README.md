## start docker

```docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=RootPassword -e MYSQL_DATABASE=Backoffice -e MYSQL_USER=MainUser -e MYSQL_PASSWORD=MainPassword mysql```

## Uma Aplicação Acessando o Banco
informações para acessar o banco de dados:
Nome do Banco de Dados: Backoffice;
Usuário: MainUser;
Senha: MainPassword;
Host: localhost ou IP;
Porta: 3306;

# run docker
docker-compose up -d

# stop docker
```docker-compose down```

#if you want to delete all data then you will use

```docker-compose down -v```
