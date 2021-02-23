drop database if exists casestudyMain;

create database casestudyMain;

use casestudyMain;

create table `position`(
position_id int primary key,
position_name varchar(45)
);
create table education_degree(
education_degree_id int primary key,
education_degree_name varchar(45)
);
create table division(
division_id int primary key,
division_name varchar(45)
);
create table `user`(
user_username varchar(45) primary key,
user_password varchar(45)
);
create table `role`(
role_id int primary key,
role_name varchar(45)
);
create table user_role(
role_id int,
user_username varchar(45),
primary key (role_id, user_username),
foreign key (role_id) references `role`(role_id),
foreign key (user_username) references `user`(user_username)
);
create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
user_username varchar(45),
position_id int,
education_degree_id int,
division_id int,
foreign key (position_id) references `position`(position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (user_username) references `user`(user_username) 
-- on delete cascade
);
create table customer_type(
customer_type_id int primary key,
customer_type_name varchar(45)
);
create table customer(
customer_id int primary key,
customer_type_id int,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references customer_type(customer_type_id)
);
create table service_type(
service_type_id int primary key,
service_type_name varchar(45)
);
create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45),
rent_type_cost double
);
create table service(
service_id int primary key,
service_name varchar(45) not null,
service_area int,
service_max_people int,
service_cost double not null,
rent_type_id int,
service_type_id int,
service_standard_room varchar(45),
service_description_room varchar(45),
service_pool_area double,
service_number_of_floors double,
foreign key (service_type_id) references service_type(service_type_id),
foreign key (rent_type_id) references rent_type(rent_type_id)
);
create table attach_service(
attach_service_id int primary key,
attach_service_name varchar(45) not null,
attach_service_cost double not null,
attach_service_unit varchar(45) not null,
attach_service_status varchar(45)
);
create table contract(
contract_id int primary key,
employee_id int,
customer_id int,
service_id int,
contract_start_date varchar(45) not null,
contract_end_date varchar(45) not null,
contract_deposit int not null,
contract_total_money double not null,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (service_id) references service(service_id)
);
create table contract_detail(
contract_detail_id int primary key,
contract_id int,
attach_service_id int,
contract_detail_quantity int not null,
foreign key (attach_service_id) references attach_service(attach_service_id),
foreign key (contract_id) references contract(contract_id)
);

insert into `position`(position_id, position_name) values
(1, 'Receptionist'),
(2, 'Server'),
(3, 'Expert'),
(4, 'Supervisor'),
(5, 'Manager'),
(6, 'President'),
(7, 'Other');

insert into education_degree(education_degree_id, education_degree_name) values
(1, 'Intermediate'),
(2, 'Colleges'),
(3, 'University'),
(4, 'After University'),
(5, 'Other');

insert into division(division_id, division_name) values
(1, 'Sale Marketing'),
(2, 'Server'),
(3, 'Manager'),
(4, 'Administration'),
(5, 'Other');

insert into `user`(user_username, user_password) values
('kien221091', '123456878'),
('son241097', '123456878'),
('cao070696', '123456878'),
('dung250197', '123456878'),
('thanh221294', '123456878');

insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
employee_email, employee_address, user_username, position_id, education_degree_id, division_id) values
('Kiên', '1991-10-22', '123456879', 5000.0, '0123456879', 'kien@kien.kien', 'Nghệ An', 'kien221091', 1, 1, 1),
('Sơn', '1997-10-24', '123456879', 5000.0, '0123456879', 'son@son.son', 'Tây Ninh', 'son241097', 2, 2, 2),
('Cao', '1996-06-07', '123456879', 5000.0, '0123456879', 'cao@cao.cao', 'Huế', 'cao070696', 3, 3, 3),
('Dũng', '1997-01-25', '123456879', 5000.0, '0123456879', 'dung@dung.dung', 'Nghệ An', 'dung250197', 4, 4, 4),
('Thanh', '1994-12-22', '123456879', 5000.0, '0123456879', 'thanh@thanh.thanh', 'Quảng Nam', 'thanh221294', 5, 5, 5);

-- delimiter //

-- create procedure employee_view()
-- begin
-- select employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
-- employee_email, employee_address, user_username, position_name, education_degree_name, division_name
-- from  employee
-- left join `position` on employee.position_id = `position`.position_id
-- left join education_degree on employee.education_degree_id = education_degree.education_degree_id
-- left join division on employee.division_id = division.division_id;
-- end

-- // delimiter ;

-- call employee_view();

drop procedure employee_view;

create trigger add_username before insert on employee
for each row
insert into `user`(user_username)
values (new.user_username);

drop trigger add_username;

create trigger delete_username after delete on employee
for each row
delete from `user`
where old.user_username = `user`.user_username;

drop trigger delete_username;

delete from `user`
where user_username = 'son241097';

create trigger delete_employee before delete on `user`
for each row
delete from employee
where old.user_username = employee.user_username;

