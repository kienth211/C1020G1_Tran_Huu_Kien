drop database if exists e1_primary_key_foreign_key;

create database e1_primary_key_foreign_key;

use e1_primary_key_foreign_key;

CREATE TABLE customers(
   customer_number INT PRIMARY KEY,
   fullname VARCHAR(45),
   address VARCHAR(45),
   email VARCHAR(45),
   phone VARCHAR(11)
);

CREATE TABLE accounts(
   account_number INT PRIMARY KEY,
   account_type VARCHAR(45),
   `date` VARCHAR(45),
   balance VARCHAR(45),
   customer_number int,
   foreign key (customer_number) references customers(customer_number)
);

CREATE TABLE transactions(
   tran_number INT PRIMARY KEY,
   `date` VARCHAR(45),
   amounts VARCHAR(45),
   descriptions VARCHAR(45),
   account_number int,
   foreign key (account_number) references accounts(account_number)
);



