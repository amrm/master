insert into department (name) VALUES ('IT'),('CS'),('DS'),('IS');

insert into employee (name,email,department_id,salary)
values('amr','amr@a.com',(select id from department where name='CS'),20000),
('ali','ali@a.com',(select id from department where name='IS'),10000),
('mohamed','mh@a.com',(select id from department where name='CS'),7500),
('ahmed','ahmed@a.com',select id from department where name='IT',3000),
('yasser','yasser@a.com',select id from department where name='CS',15000),
('khalid','kh@a.com',select id from department where name='IT',30000),
('mostafa','ms@a.com',select id from department where name='CS',50000),
('ayman','ay@a.com',select id from department where name='CS',8000),
('aya','aya@a.com',select id from department where name='CS',25000),
('hadeer','hd@a.com',select id from department where name='IT',22000),
('shima','shima@a.com',select id from department where name='IT',5000),
('sara','sara@a.com',select id from department where name='DS',15000),
('amany','amany@a.com',select id from department where name='IT',5000),
('hend','hend@a.com',select id from department where name='DS',25000),
('esraa','esraa@a.com',select id from department where name='IS',5000),
('amira','amira@a.com',select id from department where name='IS',5000)

;