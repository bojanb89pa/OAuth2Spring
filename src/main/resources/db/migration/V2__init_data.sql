
USE `oauth2spring`;

--------------------------------------------------
-- SPRING OAUTH 2 DATA TABLES:
--------------------------------------------------
--
-- Init oauth 2 client
--
LOCK TABLES `oauth_client_details` WRITE;
-- password = abc123
INSERT INTO `oauth_client_details` VALUES (1, 0, 'test_client','', '$2a$06$DDotKSp9gYImvFpxeJjNy.sjfm0VOpwojgxuhcZZ3Xx5dztqdI6QC', 'read, write, trust', 'password,refresh_token', '', '', 60, NULL, '{}', '');
UNLOCK TABLES;