# DataBase mySQL
user: MainUser;

password: MainPassword;

Host: localhost or IP 127.0.0.1;

Porta: 3306;

# run docker-compose:
````
docker-compose up -d
````

# stop docker-compose:
````
docker-compose down
````

# if you want to delete all data then you will use:

````
docker-compose down -v
````

# Access database workspace

````open link: http://localhost/index.php?route=/````
````
Server: database 
Username: root
Password: RootPassword
````

## if start docker without docker-compose

````
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=RootPassword -e MYSQL_DATABASE=Backoffice -e MYSQL_USER=MainUser -e MYSQL_PASSWORD=MainPassword mysql
````

## Swagger doc

```` http://localhost:8080/swagger-ui.html````

## RUN project with maven

```` mvn spring-boot:run ````

## RUN test

```` mvn test ````