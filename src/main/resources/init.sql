create table if not exists users (id bigint primary key auto_increment, name varchar(255), last_name varchar(255), age tinyint, username varchar(255), password varchar(255));
create table if not exists roles (id bigint primary key auto_increment, name varchar(255));
create table if not exists users_roles(user_id bigint , role_id bigint, primary key (user_id, role_id));
insert into users(id, name, last_name, age,username, password) values (1 ,'admin', 'admin', 10,'admin', '$2a$10$8i2bec8tv8X5Vh/4dObEiOOaJvp/p.JpXfOtEVdsDM7qG6DPJsgzm');
insert into roles(id, name) VALUES (1, 'ROLE_USER');
insert into roles(id, name) VALUES (2, 'ROLE_ADMIN');
insert into users_roles(user_id, role_id) VALUES (1, 2)
-- Логин и пароль admin
