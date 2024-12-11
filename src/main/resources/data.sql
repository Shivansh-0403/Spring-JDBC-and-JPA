create table person(
	id integer primary key AUTO_INCREMENT,
	name varchar(50) not null,
	location varchar(255),
	birth_date timestamp
);


insert into person (id, name, location, birth_date) values(1001, 'Shivansh', 'Varanasi', current_timestamp());
insert into person (id, name, location, birth_date) values(1002, 'Vibhor', 'Jabalpur', current_timestamp());
insert into person (id, name, location, birth_date) values(1003, 'Sabir', 'Delhi', current_timestamp());
insert into person (id, name, location, birth_date) values(1004, 'Rishitosh', 'Patna', current_timestamp());
