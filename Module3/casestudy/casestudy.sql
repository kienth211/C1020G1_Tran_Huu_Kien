drop database if exists casestudy;

create database casestudy;

use casestudy;

create table vi_tri(
id_vi_tri int primary key,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int primary key,
trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int primary key,
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int primary key,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmtnd varchar(45),
luong decimal(9.2),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key (id_trinh_do) references trinh_do(id_trinh_do),
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key,
ten_dich_vu_di_kem varchar(45),
gia decimal(6,2),
don_vi varchar(45),
trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

create table loai_khach(
id_loai_khach int primary key,
ten_loai_khach varchar(45)
);

create table khach_hang(
id_khach_hang int primary key,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
id_kieu_thue varchar(45) primary key,
ten_kieu_thue varchar(45),
gia decimal(6,2)
);

create table dich_vu(
id_dich_vu int primary key,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue decimal(6,2),
id_kieu_thue varchar(45),
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue)
);

create table hop_dong(
id_hop_dong int primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong varchar(45),
ngay_ket_thuc varchar(45),
tien_dat_coc int,
tong_tien decimal(9,2),
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_hop_dong_chi_tiet(
id_hop_dong int,
id_hop_dong_chi_tiet int,
primary key (id_hop_dong, id_hop_dong_chi_tiet),
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key (id_hop_dong_chi_tiet) references hop_dong_chi_tiet(id_hop_dong_chi_tiet)
);

-- data vi tri:

insert  into `vi_tri`(`id_vi_tri`,`ten_vi_tri`) values 

(1,'le_tan'),

(2,'phuc_vu'),

(3,'chuyen_vien'),

(4,'giam_sat'),

(5,'quan_ly'),

(6,'giam_doc');

-- data trinh_do:

insert  into `trinh_do`(`id_trinh_do`,`trinh_do`) values 

(1,'trung_cap'),

(2,'cao_dang'),

(3,'dai_hoc'),

(4,'sau_dai_hoc');

-- data bo_phan:

insert  into `bo_phan`(`id_bo_phan`,`ten_bo_phan`) values 

(1,'sale_marketing'),

(2,'hanh_chinh'),

(3,'phuc_vu'),

(4,'quan_ly');

-- data nhan_vien:

insert  into `nhan_vien`(`id_nhan_vien`,`ho_ten`,`id_vi_tri`,`id_trinh_do`,`id_bo_phan`,`ngay_sinh`,`so_cmtnd`,`luong`,`sdt`,`email`,`dia_chi`) values 

(1,'tuan',5,4,4,'1995-12-12',0123456789,1000,0123456789,'tuan@tuan.tuan','tuan'),

(2,'kien',4,3,2,'1991-2-2',0123456789,500,0123456789,'kien@kien.kien','kien'),

(3,'son',3,2,1,'1996-3-3',0321456789,700,0321456789,'son@son.son','son'),

(4,'thanh',6,4,4,'1993-4-4',0123654789,2000,0123654789,'thanh@thanh.thanh','thanh'),

(5,'cao',1,1,1,'2000-1-1',0123456987,3000,0123456987,'cao@cao.cao','cao');

-- data loai_khach:

insert  into `loai_khach`(`id_loai_khach`,`ten_loai_khach`) values 

(1,'diamond'),

(2,'platinium'),

(3,'gold'),

(4,'silver'),

(5,'member');

-- data khach_hang:

insert  into `khach_hang`(`id_khach_hang`,`id_loai_khach`,`ho_ten`,`ngay_sinh`,`so_cmtnd`,`sdt`,`email`,`dia_chi`) values 

(1,1,'Dũng','1996-1-1',0123456789,0123456789,'dung@dung.dung','Vinh'),

(2,2,'Thịnh','1997-2-2',0321456789,0321456789,'thinh@thinh.thinh','thinh'),

(3,1,'Phin','1998-3-3',0123654789,0123654789,'phin@phin.phin','Vinh'),

(4,4,'Hân','1999-4-4',0123456987,0123456987,'han@han.han','han'),

(5,1,'Hải','2000-5-5',0123789456,0123789456,'hai@hai.hai','Quảng Ngãi'),

(6,1,'Tuấn','1998-3-3',0123654789,0123654789,'phin@phin.phin','Quảng Ngãi'),

(7,4,'Tùng','1980-2-2',0123654789,0123654789,'tung@tung.tung','tung'),

(8,2,'Cao','1990-2-2',0123654789,0123654789,'tung@tung.tung','tung'),

(9,2,'Long','1991-2-2',0123654789,0123654789,'tung@tung.tung','tung');

-- data loai_dich_vu:

insert  into `loai_dich_vu`(`id_loai_dich_vu`,`ten_loai_dich_vu`) values 

(1,'villa'),
(2,'house'),
(3,'room');

-- data kieu_thue:

insert  into `kieu_thue`(`id_kieu_thue`,`ten_kieu_thue`,`gia`) values 

(1,'nam',100),
(2,'thang',200),
(3,'ngay',300),
(4,'gio',400);

-- data dich_vu:

insert  into `dich_vu`(`id_dich_vu`,`ten_dich_vu`,`dien_tich`,`so_tang`,`so_nguoi_toi_da`,`chi_phi_thue`,`id_kieu_thue`,`id_loai_dich_vu`,`trang_thai`) values 

(1,'xanh',60,2,10,500,1,1,'dang su dung'),
(2,'trang',70,3,11,400,2,2,'dang su dung'),
(3,'do',80,4,12,300,3,3,'chua su dung'),
(4,'hong',90,3,9,600,4,2,'chua su dung'),
(5,'vang',50,4,15,700,1,3,'dang su dung');

-- data dich_vu_di_kem:

insert  into `dich_vu_di_kem`(`id_dich_vu_di_kem`,`ten_dich_vu_di_kem`,`gia`,`don_vi`,`trang_thai_kha_dung`) values 

(1,'massage',10,'dollar','dang kha dung'),
(2,'karaoke',20,'dollar','dang kha dung'),
(3,'thuc an',30,'dollar','dang kha dung'),
(4,'nuoc uong',40,'dollar','dang kha dung'),
(5,'xe',50,'dollar','dang kha dung');

-- data hop_dong_chi_tiet:

insert  into `hop_dong_chi_tiet`(`id_hop_dong_chi_tiet`,`id_hop_dong`,`id_dich_vu_di_kem`,`so_luong`) values 

(1,1,1,2),
(2,2,2,3),
(3,3,3,4),
(4,4,4,5),
(5,5,5,6),
(6,4,2,5),
(7,3,4,6);

-- data hop_dong:

insert  into `hop_dong`(`id_hop_dong`,`id_nhan_vien`,`id_khach_hang`,`id_dich_vu`,`ngay_lam_hop_dong`,`ngay_ket_thuc`,`tien_dat_coc`,`tong_tien`) values 

(1,1,1,1,'2020-1-8','2020-1-21',1000,2000),
(2,2,2,2,'2020-2-11','2020-2-21',2000,3000),
(3,3,3,3,'2020-3-12','2020-3-21',3000,4000),
(4,4,4,4,'2020-4-11','2020-4-21',4000,5000),
(5,5,5,5,'2021-5-12','2021-5-21',5000,6000),
(6,5,6,4,'2021-6-12','2021-6-15',5000,7000),
(7,5,6,3,'2021-7-17','2021-7-20',5000,8000),
(8,5,6,4,'2021-8-12','2021-8-15',5000,7000),
(9,3,2,1,'2021-9-12','2021-9-15',5000,7000),
(10,3,8,1,'2021-9-12','2021-9-15',5000,7000),
(11,3,8,2,'2021-9-12','2021-9-15',5000,7000);

-- task 2: 

select *
from nhan_vien
where ho_ten like 'K%' or ho_ten like 's%';

-- task 3: 

select *
from khach_hang
where year(now()) - year(ngay_sinh) > 22 and (dia_chi = 'phin' or dia_chi = 'thinh');

-- task 4: 

select khach_hang.id_khach_hang, ho_ten, count(hop_dong.id_khach_hang)
from khach_hang
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1
group by ho_ten;

-- task 5: 

select khach_hang.id_khach_hang, ho_ten, loai_khach.ten_loai_khach, hop_dong.id_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, 
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) as tong_tien
from khach_hang
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong.id_hop_dong;

-- task 6: 

select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
where not exists (
select hop_dong.id_dich_vu
from hop_dong
where (hop_dong.ngay_lam_hop_dong between '2020-11-1' and '2020-11-30') and hop_dong.id_dich_vu = dich_vu.id_dich_vu);

-- task 7: 

select dich_vu.id_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da, dich_vu.so_nguoi_toi_da, loai_dich_vu.ten_loai_dich_vu
from dich_vu
inner join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
where exists (
select hop_dong.id_hop_dong
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2020' and hop_dong.id_dich_vu = dich_vu.id_dich_vu)
and not exists (
select hop_dong.id_hop_dong
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2021' and hop_dong.id_dich_vu = dich_vu.id_dich_vu);

-- task 8: 

select distinct khach_hang.ho_ten
from khach_hang;

select  khach_hang.ho_ten
from khach_hang
group by khach_hang.ho_ten;

select  khach_hang.ho_ten
from khach_hang
union select  khach_hang.ho_ten
from khach_hang;

-- task 9: 

select temp.month, count(hop_dong.ngay_lam_hop_dong) as so_khach_hang_dang_ky, sum(hop_dong.tong_tien) as tong_tien_1 from
(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as temp
left join hop_dong on month(hop_dong.ngay_lam_hop_dong) = temp.month
where year(hop_dong.ngay_lam_hop_dong) = '2020' or month(hop_dong.ngay_lam_hop_dong) is null
group by temp.month;

-- task 10: 

select hop_dong.id_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc, 
count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_luong_dich_vu_di_kem
from hop_dong
inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by hop_dong.id_hop_dong;

-- task 11:

select khach_hang.ho_ten, loai_khach.ten_loai_khach, khach_hang.dia_chi, dich_vu_di_kem.ten_dich_vu_di_kem
from khach_hang
left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
inner join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
where loai_khach.ten_loai_khach = 'diamond' and (khach_hang.dia_chi = 'Quảng Ngãi' or khach_hang.dia_chi = 'Vinh')
group by khach_hang.id_khach_hang;

-- task 12: 

select hop_dong.id_hop_dong, nhan_vien.ho_ten 'tenNhanVien', khach_hang.ho_ten 'tenKhachHang', khach_hang.sdt 'sdtKhachHang', dich_vu.ten_dich_vu,
hop_dong_chi_tiet.so_luong, hop_dong.tien_dat_coc
from hop_dong
left join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join nhan_vien on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
where (month(hop_dong.ngay_lam_hop_dong) in (10,11,12)) and (month(hop_dong.ngay_lam_hop_dong) not in (1,2,3,4,5,6))
group by hop_dong.id_hop_dong;

-- task 13: 

create temporary table temp
select dich_vu_di_kem.ten_dich_vu_di_kem as ten_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet
inner join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by dich_vu_di_kem.ten_dich_vu_di_kem;

-- select *
-- from temp;

create temporary table temp_1
select max(temp.so_lan_su_dung) as max_so_lan_su_dung
from temp;

-- select *
-- from temp_1;

select temp.ten_dich_vu_di_kem, temp.so_lan_su_dung
from temp
inner join temp_1 on temp.so_lan_su_dung = temp_1.max_so_lan_su_dung;

drop table temp;
drop table temp_1;

-- task 14

select nhan_vien.id_nhan_vien, loai_dich_vu.ten_loai_dich_vu, dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.id_dich_vu_di_kem) as so_lan_su_dung
from dich_vu_di_kem
left join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
left join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
group by dich_vu_di_kem.id_dich_vu_di_kem
having so_lan_su_dung = 1;

-- task 15

select nhan_vien.id_nhan_vien, nhan_vien.ho_ten, trinh_do.trinh_do, bo_phan.ten_bo_phan, nhan_vien.sdt, nhan_vien.dia_chi
from nhan_vien
left join trinh_do on nhan_vien.id_trinh_do = trinh_do.id_trinh_do
inner join bo_phan on nhan_vien.id_bo_phan = bo_phan.id_bo_phan
inner join hop_dong on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
where month(hop_dong.ngay_lam_hop_dong) between 1 and 3;

-- task 16:

create temporary table temp_table 
select hop_dong.id_nhan_vien as id_nhan_vien
from hop_dong
where hop_dong.ngay_lam_hop_dong < '2021-01-01'
group by hop_dong.id_nhan_vien;

DELETE FROM hop_dong 
WHERE hop_dong.id_nhan_vien in (
select temp_table.id_nhan_vien
from temp_table);

delete from nhan_vien
where nhan_vien.id_nhan_vien in (
select temp_table.id_nhan_vien
from temp_table);

drop temporary table temp_table;

-- task 17:

drop temporary table temp;

create temporary table temp
select khach_hang.id_khach_hang, sum(hop_dong.tong_tien)
from khach_hang
left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
inner join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
where loai_khach.ten_loai_khach = 'platinium'
group by hop_dong.id_khach_hang
having sum(hop_dong.tong_tien) > 10000;

update khach_hang
set khach_hang.id_loai_khach = 1
where khach_hang.id_khach_hang in (
select temp.id_khach_hang
from temp);

-- task 18:

create temporary table temp 
select hop_dong.id_khach_hang
from hop_dong
where hop_dong.ngay_lam_hop_dong < '2021-01-01'
group by hop_dong.id_khach_hang;

DELETE FROM hop_dong 
WHERE hop_dong.id_khach_hang in (
select temp.id_khach_hang
from temp);

delete from khach_hang
where khach_hang.id_khach_hang in (
select temp.id_khach_hang
from temp);

-- task 19:

create temporary table temp
select dich_vu_di_kem.ten_dich_vu_di_kem, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan_su_dung
from hop_dong_chi_tiet
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having count(hop_dong_chi_tiet.id_dich_vu_di_kem) > 1;

update dich_vu_di_kem
set gia = gia * 2
where dich_vu_di_kem.ten_dich_vu_di_kem in (
select temp.ten_dich_vu_di_kem
from temp);

-- task 20:

select id_nhan_vien as id, ho_ten, email, sdt, ngay_sinh, dia_chi
from nhan_vien
union all
select id_khach_hang as id, ho_ten, email, sdt, ngay_sinh, dia_chi
from khach_hang;







