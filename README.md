# DataBase mySQL
user: MainUser;

password: MainPassword;

Host: localhost or IP 127.0.0.1;

Porta: 3306;

# run docker-compose:
````docker-compose up -d````

# stop docker-compose:
````docker-compose down````

# if you want to delete all data then you will use:

````docker-compose down -v````

## start docker without docker-compose

````docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=RootPassword -e MYSQL_DATABASE=Backoffice -e MYSQL_USER=MainUser -e MYSQL_PASSWORD=MainPassword mysql````