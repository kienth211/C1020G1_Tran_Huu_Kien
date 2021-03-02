drop database if exists product;

create database product;

use product;

create table product(
id int primary key auto_increment,
`name` varchar(45) not null,
price double not null
);

insert into product(`name`, price) values
('Kiên', 1),
('Cao', 2),
('Thanh', 3),
('Thanh', 4),
('Dũng', 5);