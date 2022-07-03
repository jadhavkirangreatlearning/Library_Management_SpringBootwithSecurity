# Library_Management_SpringBootwithSecurity

Spring Boot with Spring Security | Project Lombok 

Library_Management

Security- BCrypt- https://bcrypt-generator.com/

Project Lombok

Spring Boot Features-

1. Inbuild Tomcat Server
2. No XML Configuration
3. With in Second will create Production Ready Application
4. Dont need to restart application after some changes- DevTool Dependency
5. Lightweight
6. Development Faster
7. Good Performance

-------------------------------------------------

entity

repository

service

controller

security

Database- Library_Management

UI- 
1. 403.jsp
2. Book-form.jsp
3. list-Books.jsp



-------------------------------------------------

DB Info-

CREATE DATABASE Library_Management

USE Library_Management

SHOW TABLES

SELECT * FROM book;

SELECT * FROM roles;

INSERT INTO roles VALUES(1, 'ADMIN');
INSERT INTO roles VALUES(2, 'USER');

SELECT * FROM users;
UPDATE users SET PASSWORD='$2a$12$DGUhJVUibS7NIc4vC/0TvuMknbyD0jVSFVqEHRVuplYuHDOXMcSZi' WHERE user_id=1
INSERT INTO users VALUES(1, '$2a$12$pcNbDt7zZBBN60w7ofpX9uJWCOmIfWOzoofcvrbcMNnLxw8U6eNS2', 'user1');
INSERT INTO users VALUES(2, '$2a$12$pcNbDt7zZBBN60w7ofpX9uJWCOmIfWOzoofcvrbcMNnLxw8U6eNS2', 'user2');

SELECT * FROM users_roles;

INSERT INTO users_roles VALUES(1, 1);
INSERT INTO users_roles VALUES(2, 2);










