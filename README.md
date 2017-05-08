# OAuth2Spring
OAuth 2.0 backend sample for mobile applicaitons

## Usage

Configure MySQL and create a database and user:

> CREATE DATABASE oauth2spring CHARACTER SET utf8 COLLATE utf8_general_ci;
>
> CREATE USER 'oauth2spring'@'%' IDENTIFIED BY 'oauth2spring';
>
> GRANT ALL PRIVILEGES ON oauth2spring.* TO 'oauth2spring'@'%' WITH GRANT OPTION;
>
> FLUSH PRIVILEGES;


Open terminal at root and complie project with following command:

`$mvn clean install`

and than run:

`$mvn flyway:migrate`

`$mvn spring-boot:run`

Your application will be started at http://localhost:8080. You can check it with health route: http://localhost:8080/health.
