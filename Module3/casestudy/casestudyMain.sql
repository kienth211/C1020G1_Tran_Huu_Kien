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
employee_id int primary key,
employee_name varchar(45) not null,
position_id int,
education_degree_id int,
division_id int,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
user_username varchar(45),
foreign key (position_id) references `position`(position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (user_username) references `user`(user_username)
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