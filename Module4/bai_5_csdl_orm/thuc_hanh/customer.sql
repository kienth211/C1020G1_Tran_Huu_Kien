drop database if exists customer;

create database customer;

use customer;

create table customer(
id int primary key auto_increment,
`name` varchar(45) not null,
age int not null
);

insert into customer(`name`, age) values
('Kiên', 11),
('Cao', 22),
('Thanh', 33),
('Thanh', 44),
('Dũng', 55);