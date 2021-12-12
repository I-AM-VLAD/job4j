create table rules (
	id serial primary key,
	name varchar(2000)
);
create table role (
	id serial primary key,
	name varchar(2000)
);
create table role_rules (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);
create table users(
	id serial primary key,
	name varchar(2000),
	role_id int references role(id)
);
create table category(
	id serial primary key,
	name varchar(2000)
);
create table state(
	id serial primary key,
	name varchar(2000)
);
create table item(
	id serial primary key,
	name varchar(2000),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);
create table attaches(
	id serial primary key,
	name varchar(2000),
	item_id int references item(id)
);
create table comments(
	id serial primary key,
	name varchar(2000),
	item_id int references item(id)
);
insert into rules(name) values ('rule'); 
insert into role(name) values ('role'); 
insert into role_rules(role_id, rules_id) values (1, 1);
insert into users(name, role_id) values ('user', 1);
insert into category(name) values ('category');
insert into state(name) values ('state');
insert into item(name, users_id, category_id, state_id) values ('item', 1, 1, 1);
insert into attaches(name, item_id) values ('attach', 1);
insert into comments(name, item_id) values ('comment', 1);
select * from item;