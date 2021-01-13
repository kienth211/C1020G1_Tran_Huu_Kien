create database cac_ham_thong_dung;
use cac_ham_thong_dung;
CREATE TABLE student (
    id INT,
    ten VARCHAR(45),
    tuoi INT,
    khoahoc VARCHAR(4),
    sotien INT
);

insert into student
value
(1,'Hoang',21,'CNTT',400000),
(2,'Viet',19,'DTVT',320000),
(3,'Thanh',18,'KTDN',400000),
(4,'Nhan',19,'CK',450000),
(5,'Huong',20,'TCNH',500000),
(5,'Huong',20,'TCNH',200000);

SELECT 
    *
FROM
    student
WHERE
    ten = 'Huong';

SELECT 
    ten, SUM(sotien)
FROM
    student
WHERE
    ten = 'Huong'
GROUP BY ten;

SELECT DISTINCT
    *
FROM
    student
ORDER BY sotien;

SELECT 
    tuoi, ten
FROM
    student 
UNION SELECT 
    tuoi, ten
FROM
    student