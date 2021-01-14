drop database if exists e1_index;

create database e1_index;

use e1_index;

create table Products (
id int primary key,
productCode varchar(50),
productName varchar(50),
productPrice double(10,2),
productAmount int,
productDescription varchar(50),
productStatus varchar(50)
);

insert into Products (`id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) values 
(1, 'A05', 'Xanh', 60, 6, 'Màu xanh', 'Khả dụng'),
(2, 'A04', 'Hồng', 70, 7, 'Màu hồng', 'Khả dụng'),
(3, 'A03', 'Đỏ', 80, 8, 'Màu đỏ', 'Khả dụng'),
(4, 'A02', 'Vàng', 40, 4, 'Màu vàng', 'Khả dụng'),
(5, 'A01', 'Tím', 50, 5, 'Màu tím', 'Khả dụng');


select * 
from products
where productCode = 'A03';

explain
select * 
from products
where productCode = 'A03';

ALTER TABLE Products ADD unique INDEX idx_productCode(productCode);

ALTER TABLE Products ADD INDEX idx_namePrice(productName, productPrice);

explain
select * 
from products
where productCode = 'A03';

CREATE VIEW products_view AS

SELECT productCode, productName, productPrice, productStatus 

FROM  products;

select *

from products_view;

CREATE or replace VIEW products_view AS

SELECT productCode, productName, productPrice, productStatus, productDescription

FROM  products;

select *

from products_view;

drop view products_view;

DELIMITER //

CREATE PROCEDURE findAllProducts()

BEGIN

  SELECT * FROM products;

END 

// DELIMITER ;

call findAllProducts();

DELIMITER //

CREATE PROCEDURE insertProducts(id int,
productCode varchar(50),
productName varchar(50),
productPrice double(10,2),
productAmount int,
productDescription varchar(50),
productStatus varchar(50)
)

BEGIN

  insert into Products (`id`, `productCode`, `productName`, `productPrice`, `productAmount`, `productDescription`, `productStatus`) values 
(id, productCode, productName, productPrice, productAmount, productDescription, productStatus);

END 

// DELIMITER ;

call insertProducts(6, 'A06', 'Cam', 100, 9, 'Màu cam', 'Không khả dụng');

-- update

DELIMITER //

CREATE PROCEDURE updateProducts(productsName varchar(50), productsRepName varchar(50))

BEGIN

update products
SET 
    productName = productsRepName
where productName = productsName;
END

// DELIMITER ;

call updateProducts('Xanh','Xanh Dương');

select *
from products;

drop PROCEDURE updateProducts;

-- delete 

DELIMITER //

CREATE PROCEDURE deleteProducts(idRep int)

BEGIN

DELETE FROM Products 
WHERE id = idRep;
END

// DELIMITER ;

call deleteProducts(2);

select *
from products;

drop PROCEDURE deleteProducts;



