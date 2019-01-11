
-- password =123456
INSERT INTO users(name,username,password,email) VALUES('admin','admin','$2a$10$VybjPIHHgFhDqZ7IERv7M.o4dwxr7A15CUECok.gzZoamj7JUbN3O','admin@a.com');
INSERT INTO users(name,username,password,email) VALUES('user','user','$2a$10$VybjPIHHgFhDqZ7IERv7M.o4dwxr7A15CUECok.gzZoamj7JUbN3O','user@a.com');

insert into user_roles (user_id,role_id) values (select id from users where username='admin',
select id from roles where name='ROLE_ADMIN' );

insert into user_roles (user_id,role_id) values (select id from users where username='user',
select id from roles where name='ROLE_USER' );