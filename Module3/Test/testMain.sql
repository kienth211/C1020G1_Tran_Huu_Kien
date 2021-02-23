drop database if exists testMain;

create database testMain;

use testMain;

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_address varchar(45) not null
);

create table customer(
customer_id int primary key auto_increment,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_phone varchar(45) not null,
customer_address varchar(45) not null,
customer_email varchar(45) not null
);

create table contract_type(
contract_type_id int primary key auto_increment,
contract_type_name varchar(45) not null
);

-- create table product(
-- product_id int primary key auto_increment,
-- product_name varchar(45) not null,
-- product_price double not null,
-- product_discount double not null,
-- product_not_sold int not null,
-- contract_id int,
-- foreign key (contract_id) references contract(contract_id)
-- );

create table contract(
contract_id int primary key auto_increment,
contract_date_summit date not null,
contract_date_give date not null,
contract_address varchar(45) not null,
contract_type_id int,
employee_id int,
customer_id int,
foreign key (contract_type_id) references contract_type(contract_type_id),
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id)
);

create table product(
product_id int primary key auto_increment,
product_name varchar(45) not null,
product_price double not null,
product_discount double not null,
product_not_sold int not null
);

create table product_contract(
product_id int,
contract_id int,
primary key (product_id, contract_id),
foreign key (product_id) references product(product_id),
foreign key (contract_id) references contract(contract_id)
);

insert into employee(employee_id, employee_name, employee_birthday, employee_address) values
(1, 'Kiên Trần', '2000-01-01', 'Nghệ An'),
(2, 'Cao Thanh', '2001-01-01', 'Huế'),
(3, 'Thanh Hồng', '2002-01-01', 'Quảng Nam'),
(4, 'Dũng Mạnh', '2003-01-01', 'Nghệ An'),
(5, 'Dũng Việt', '2004-01-01', 'Đà Nẵng'),
(6, 'Tùng Thanh', '2005-01-01', 'Đà Nẵng'),
(7, 'Hân Trần', '2006-01-01', 'Quảng Ngãi'),
(8, 'Sơn Phạm', '2007-01-01', 'Tây Ninh'),
(9, 'Thịnh Trần', '2008-01-01', 'Hội An'),
(10, 'Phin Nguyễn', '2009-01-01', 'Quảng Nam');

insert into customer(customer_id, customer_name, customer_birthday, customer_phone, 
customer_address, customer_email) values
(1, 'Kiên Trần', '2000-01-01', '0123456789', 'Nghệ An', 'kien@kien.kien'),
(2, 'Cao Thanh', '2001-01-01', '0123456789','Huế' , 'cao@cao.cao'),
(3, 'Thanh Hồng', '2002-01-01', '0123456789','Quảng Nam', 'thanh@thanh.thanh'),
(4, 'Dũng Mạnh', '2003-01-01', '0123456789','Nghệ An', 'dung@dung.dung'),
(5, 'Dũng Việt', '2004-01-01', '0123456789','Đà Nẵng', 'dung@dung.dung'),
(6, 'Tùng Thanh', '2005-01-01', '0123456789','Đà Nẵng', 'tung@tung.tung'),
(7, 'Hân Trần', '2006-01-01', '0123456789','Quảng Ngãi', 'tung@tung.tung'),
(8, 'Sơn Phạm', '2007-01-01', '0123456789','Tây Ninh', 'son@son.son'),
(9, 'Thịnh Trần', '2008-01-01', '0123456789','Hội An', 'thinh@thinh.thinh'),
(10, 'Phin Nguyễn', '2009-01-01', '0123456789','Quảng Nam', 'phin@phin.phin');

insert into contract_type(contract_type_id, contract_type_name) values
(1, 'Atm'),
(2, 'Cod'),
(3, 'Master/Visa'),
(4, 'Truc tiep');

insert into contract(contract_id, contract_date_summit, contract_date_give, contract_address, 
contract_type_id, employee_id, customer_id) values
(1, '2000-01-01', '2000-01-02', 'Nghệ An', 1, 1, 1),
(2, '2001-01-01', '2001-01-02', 'Huế' , 2, 2, 2),
(3, '2002-01-01', '2002-01-02', 'Quảng Nam' , 3, 3, 3),
(4, '2003-01-01', '2003-01-02', 'Nghệ An', 4, 4, 4),
(5, '2004-01-01', '2004-01-02', 'Đà Nẵng' , 1, 5, 5),
(6, '2005-01-01', '2005-01-02', 'Đà Nẵng', 2, 6, 6),
(7, '2006-01-01', '2006-01-02', 'Quảng Ngãi', 3, 7, 7),
(8, '2007-01-01', '2007-01-02', 'Tây Ninh', 4, 8, 8),
(9, '2008-01-01', '2008-01-02', 'Hội An', 1, 9, 9),
(10, '2009-01-01', '2009-01-02', 'Quảng Nam', 2, 10, 10);

insert into product(product_id, product_name, product_price, product_discount, 
product_not_sold) values
(1, 'Xanh', 1000, 5, 1),
(2, 'Do', 2000, 10, 2),
(3, 'Tim', 3000, 15, 3),
(4, 'Vang', 4000, 20, 4),
(5, 'Den', 5000, 5, 5),
(6, 'Trang', 6000, 10, 6),
(7, 'Hong', 7000, 15, 7),
(8, 'Nau', 8000, 20, 8),
(9, 'Cam', 9000, 5, 9),
(10, 'Xanh Duong', 10000, 10, 10);

insert into product_contract(product_id, contract_id) values
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(5, 6),
(5, 7),
(6, 6),
(7, 7),
(8, 8),
(7, 9),
(8, 9),
(9, 9),
(10, 9),
(10, 10);

select contract.contract_id, product.product_id, product.product_name
from contract
left join product_contract on contract.contract_id = product_contract.contract_id
left join product on product_contract.product_id = product.product_id
order by product_contract.contract_id;



