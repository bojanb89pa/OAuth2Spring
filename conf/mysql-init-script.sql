CREATE DATABASE oauth2spring CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'oauth2spring'@'%' IDENTIFIED BY 'oauth2spring';
GRANT ALL PRIVILEGES ON `oauth2spring`.* TO 'oauth2spring'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;