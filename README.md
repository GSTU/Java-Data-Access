java-database-access
================

Здесь собраны различные примеры для подключения к базе данных с помощью java технологий

В программе используется база данный PostgreSQL 9.2 в которой есть таблица <code>users</code>

Создается следующим запросом:

```
CREATE TABLE users
(
  id serial NOT NULL,
  username character varying(100),
  userlogin character varying(255),
  userpassword character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
```

================
JDBCSpringTemplateExample - пример использования шаблонов Spring Framework для упрощения доступа к данным с использованием JDBC

JDBC-example - пример подключения к БД с использованием чистого JDBC
