SQL> CREATE TABLESPACE daffarahmatul_07027
  2  DATAFILE 'E:\DAFFA\ITATS\tugas semester 4\Basis Data\modul1\daffarahmatul_07027.dbf'
  3  SIZE 30M;
SQL> CREATE USER daffarahmatul_07027
  2  IDENTIFIED BY daffa
  3  DEFAULT TABLESPACE daffarahmatul_07027
  4  QUOTA 30M ON daffarahmatul_07027;
SQL> CREATE TABLE pegawai_07027
  2  (
  3  Id_pegawai INTEGER not null,
  4  Nama_pegawai VARCHAR2(20),
  5  Password VARCHAR2(15),
  6  Alamat VARCHAR2(100),
  7  No_telp NUMBER(12),
  8  constraint PK_pegawai primary key (Id_pegawai)
  9  );
SQL> CREATE TABLE baju_07027
  2  (
  3  Id_baju INTEGER not null,
  4  Merk VARCHAR2(20),
  5  constraint PK_baju primary key (Id_baju)
  6  );
SQL> CREATE TABLE beli_07027
  2  (
  3  Id_beli INTEGER not null,
  4  Id_baju INTEGER,
  5  Id_pegawai INTEGER,
  6  Harga_beli INTEGER,
  7  constraint PK_beli primary key (Id_beli)
  8  );
SQL> CREATE TABLE jual_07027
  2  (
  3  Id_jual INTEGER not null,
  4  Id_beli INTEGER,
  5  Id_pegawai INTEGER,
  6  Harga_jual INTEGER,
  7  constraint PK_jual primary key (Id_jual)
  8  ); 
SQL> CREATE TABLE laporan_07027
  2  (
  3  Id_laporan INTEGER not null,
  4  Id_pegawai INTEGER,
  5  Id_jual INTEGER,
  6  Keuntungan INTEGER,
  7  constraint PK_laporan primary key (Id_laporan)
  8  );
SQL> alter table jual_07027
  2  add constraint FK_Id_pegawai FOREIGN KEY (Id_pegawai)
  3  references pegawai_07027(Id_pegawai)
  4  add constraint FK_Id_beli FOREIGN KEY (Id_beli)
  5  references beli_07027(Id_beli);
SQL> create sequence Id_pegawai
  2  minvalue 1
  3  maxvalue 9999
  4  start with 1
  5  increment by 1
  6  cache 20;
SQL> alter table pegawai_07027
  2  add constraint no_pegawai UNIQUE (No_telp);
SQL> alter table pegawai_07027 modify(No_telp char(12));
SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (1,'adi','tes1','surabaya','123456789');SQL> insert all
  2  into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (3,'cici','tes3','surabaya','345678912')
  3  into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (4,'daffa','tes4','surabaya','456789123')
  4  into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (5,'edi','tes5','malang','567891234')
  5  select 1 from dual;
SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (id_pegawai.nextval,'fai','test6','sidoarjo','678912345');

SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (id_pegawai.NEXTVAL,'gani','test7','pacet','789123456');

SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (id_pegawai.NEXTVAL,'ham','test8','surabaya','891234567');

SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (id_pegawai.NEXTVAL,'ismi','test9','surabaya','912345678');

SQL> insert into pegawai_07027 (id_pegawai,nama_pegawai,password,alamat,no_telp)values (id_pegawai.NEXTVAL,'joko','test10','semarang','0123456789');
SQL> insert into baju_07027 (id_baju,merk)values (1,'Ada');
SQL> insert into baju_07027 (id_baju,merk)values (2,'Bukan');
SQL> insert all
  2  into baju_07027 (id_baju,merk)values (3,'Ciw')
  3  into baju_07027 (id_baju,merk)values (4,'daf')
  4  into baju_07027 (id_baju,merk)values (5,'elf')
  5  select 1 from dual;
SQL> insert into baju_07027 (id_baju,merk)values (id_baju.nextval,'foot');
SQL> insert into baju_07027 (id_baju,merk)values (id_baju.nextval,'gajah');
SQL> insert into baju_07027 (id_baju,merk)values (id_baju.nextval,'haus');
SQL> insert into baju_07027 (id_baju,merk)values (id_baju.nextval,'ikan');
SQL> insert into baju_07027 (id_baju,merk)values (id_baju.nextval,'jam');
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (1,1,1,NULL,'100000');
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (2,2,2,NULL,'200000');
SQL> insert all
  2  into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (3,3,3,NULL,'300000')
  3  into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (4,4,4,NULL,'400000')
  4  into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (5,5,5,NULL,'500000')
  5  select 1 from dual;
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (id_beli.nextval,26,6,NULL,600000);
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (id_beli.nextval,27,7,NULL,700000);
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (id_beli.nextval,28,8,NULL,800000);
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (id_beli.nextval,29,9,NULL,900000);
SQL> insert into beli_07027 (id_beli,id_baju,id_pegawai,id_jual,harga_beli)values (id_beli.nextval,30,10,NULL,1000000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (1,1,1,200000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (2,2,2,300000);
SQL> insert all
  2  into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (3,3,3,400000)
  3  into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (4,4,4,500000)
  4  into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (5,5,5,600000)
  5  select 1 from dual;
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (id_jual.nextval,29,20,700000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (id_jual.nextval,31,21,800000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (id_jual.nextval,32,22,900000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (id_jual.nextval,33,23,1000000);
SQL> insert into jual_07027 (id_jual,id_beli,id_pegawai,harga_jual)values (id_jual.nextval,34,24,1100000);
SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (1,1,1,'100000');
SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (2,2,2,'200000');
SQL> insert all
  2  into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (3,3,3,'300000')
  3  into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (4,4,4,'400000')
  4  into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (5,5,5,'500000')
  5  select 1 from dual;

SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (id_laporan.nextval,20,21,'100000');
SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (id_laporan.nextval,21,22,'100000');
SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (id_laporan.nextval,22,23,'100000');
SQL> insert into laporan_07027 (id_laporan,id_pegawai,id_jual,keuntungan)values (id_laporan.nextval,23,24,'100000');

SQL> update pegawai_07027 set password = 'abc';
SQL> update beli_07027 set id_jual=1 where id_beli=1;
SQL> update beli_07027 set id_jual=2 where id_beli=2;
SQL> update beli_07027 set id_jual=3 where id_beli=3;
SQL> update beli_07027 set id_jual=4 where id_beli=4;
SQL> update beli_07027 set id_jual=5 where id_beli=5;
SQL> update pegawai_07027 set nama_pegawai = 'septiadi' where nama_pegawai like 'a%';
SQL> update pegawai_07027 set nama_pegawai = 'bagus' where nama_pegawai like 'b%';
SQL> update pegawai_07027 set nama_pegawai = 'caca' where nama_pegawai like 'c%';
SQL> update pegawai_07027 set nama_pegawai = 'devi' where nama_pegawai like 'd%';
SQL> update jual_07027 set harga_jual = 2100000 where (id_jual = 1 or id_beli = 1) and id_pegawai = 1;
SQL> update jual_07027 set harga_jual = 3100000 where (id_jual = 2 or id_beli = 2) and id_pegawai = 2;
SQL> update jual_07027 set harga_jual = 4100000 where (id_jual = 3 or id_beli = 3) and id_pegawai = 3;
SQL> update jual_07027 set harga_jual = 5100000 where (id_jual = 4 or id_beli = 4) and id_pegawai = 4;
SQL> update jual_07027 set harga_jual = 6100000 where (id_jual = 5 or id_beli = 5) and id_pegawai = 5;
SQL> update pegawai_07027 set nama_pegawai = 'eka' where nama_pegawai like 'e%';

SQL> DELETE FROM laporan_07027 WHERE id_jual = 5 OR KEUNTUNGAN = 100000;
SQL> DELETE FROM laporan_07027 WHERE keuntungan < 300000 AND id_jual BETWEEN 2 AND 3;
SQL> DELETE FROM laporan_07027 WHERE id_jual < 4 AND Keuntungan LIKE '%3%';

SQL> savepoint savepoint_1;
SQL> commit;
SQL> rollback to savepoint_1
  2  ;

SQL> select * from baju_07027 order by merk desc;

SQL> select merk from baju_07027 group by merk;

SQL> INSERT ALL
  2  into pegawai_07027 values(11,'bagas','tes11','surabaya','888888888')
  3  into pegawai_07027 values (12,'ciwit','tes12','surabaya','999999999')
  4  into pegawai_07027 values (13,'dwi','tes13','makasar','111111111')
  5  into pegawai_07027 values (14,'eva','tes14','madura','222222222222')
  6  into pegawai_07027 values (15,'faja','tes15','malang','333333333')
  7  select 1 from dual;

SQL> INSERT ALL
  2  into baju_07027 values(11,'lama')
  3  into baju_07027 values(12,'jupuk')
  4  into baju_07027 values(13,'kata')
  5  into baju_07027 values(14,'coba')
  6  into baju_07027 values(15,'waaw')
  7  select 1 from dual;

SQL> INSERT ALL
  2  into beli_07027 values (11,11,11,'11000000',NULL)
  3  into beli_07027 values (12,12,12,'12000000',NULL)
  4  into beli_07027 values (13,13,13,'13000000',NULL)
  5  into beli_07027 values (14,14,14,'14000000',NULL)
  6  into beli_07027 values (15,15,15,'15000000',NULL)
  7  select 1 from dual;

SQL> INSERT ALL
  2  into jual_07027 values (11,11,11,'12000000')
  3  into jual_07027 values (12,12,12,'13000000')
  4  into jual_07027 values (13,13,13,'14000000')
  5  into jual_07027 values (14,14,14,'15000000')
  6  into jual_07027 values (15,15,15,'16000000')
  7  select 1 from dual;

SQL> insert into jual_07027 values (id_laporan.nextval,11,11,'2000');
SQL> insert into jual_07027 values (id_laporan.nextval,12,12,'3000');
SQL> insert into jual_07027 values (id_laporan.nextval,13,13,'4000');
SQL> insert into jual_07027 values (id_laporan.nextval,14,14,'5000');
SQL> insert into jual_07027 values (id_laporan.nextval,12,12,'70000');

SQL> SELECT id_jual, MAX(harga_jual) AS TERBANYAK, MIN(harga_jual) AS TERENDAH FROM jual_07027 GROUP BY id_jual;

SQL> select alamat,count (alamat) as jumlah_pegawai
  2  from pegawai_07027 where id_pegawai between 1 and 15 and password is not null
  3  group by alamat;

SQL> select id_pegawai, sum (harga_jual) as jumlah_transaksi
  2  from jual_07027 group by id_pegawai;

SQL> select avg (harga_jual) as rata_rata_transaksi
  2  from jual_07027 ;

SQL> select id_jual as termahal_dan_termurah
  2  from jual_07027 where id_jual = (select id_jual from jual_07027 where harga_jual =(select max(harga_jual)from jual_07027))
  3  or id_jual = (select id_jual
  4  from jual_07027 where harga_jual = (select min(harga_jual) from jual_07027));

SQL> select nama_pegawai,(select count(id_jual)
  2  from jual_07027 where jual_07027.id_pegawai=pegawai_07027.id_pegawai and jual_07027.id_pegawai between 1 and 24) as jumlah_transaksi
  3  from pegawai_07027;

SQL> select nama_pegawai,(select sum (harga_jual)
  2  from jual_07027 where jual_07027.id_pegawai=pegawai_07027.id_pegawai and jual_07027.id_pegawai between 1 and 24) as jumlah_harga
  3  from pegawai_07027 where id_pegawai=12;

SQL> select nama_pegawai,(select avg (harga_jual)
  2  from jual_07027 where jual_07027.id_pegawai=pegawai_07027.id_pegawai and jual_07027.id_pegawai between 1 and 24) as rata_rata_harga
  3  from pegawai_07027 where id_pegawai=12;

SQL> select id_pegawai as id_pegawai_bawah_rata2
  2  from jual_07027
  3  where harga_jual < (select avg (harga_jual) from jual_07027)
  4  group by id_pegawai;

SQL> select id_jual , (select min (harga_jual)
  2  from jual_07027) as harga_jual
  3  from jual_07027 where id_jual=(select id_jual
  4  from jual_07027 where harga_jual=(select min (harga_jual)
  5  from jual_07027));

SQL> select id_jual as termahal_dan_termurah
  2  from jual_07027 where id_jual = (select id_jual from jual_07027 where harga_jual =(select max(harga_jual)from jual_07027))
  3  or id_jual = (select id_jual
  4  from jual_07027 where harga_jual = (select min(harga_jual) from jual_07027));

SQL> insert into baju_07027 (Id_baju,Merk)values (6,'viu');
SQL> insert into baju_07027 (Id_baju,Merk)values (7,'zara');
SQL> insert into baju_07027 (Id_baju,Merk)values (8,'iwak');
SQL> insert into baju_07027 (Id_baju,Merk)values (9,'lala');
SQL> insert into baju_07027 (Id_baju,Merk)values (10,'jaco');

SQL> insert into Pegawai_07027 (Id_pegawai,Nama_pegawai,Password,Alamat,No_telp)values (6,'lala','tes1','surabaya','1234571821');
SQL> insert into Pegawai_07027 (Id_pegawai,Nama_pegawai,Password,Alamat,No_telp)values (7,'mansur','tes1','sidoarjo','8238749111');
SQL> insert into Pegawai_07027 (Id_pegawai,Nama_pegawai,Password,Alamat,No_telp)values (8,'nana','tes1','malang','08238749111');
SQL> insert into Pegawai_07027 (Id_pegawai,Nama_pegawai,Password,Alamat,No_telp)values (9,'ote','tes1','mojokerto','08296449111');
SQL> insert into Pegawai_07027 (Id_pegawai,Nama_pegawai,Password,Alamat,No_telp)values (10,'pari','tes1','jombang','08123567111');

SQL> insert all
  2  into beli_07027 (Id_beli,id_baju,Id_pegawai,Harga_beli,id_jual)values (6,6,6,'120000',null)
  3  into beli_07027 (Id_beli,id_baju,Id_pegawai,Harga_beli,id_jual)values (7,7,7,'130000',null)
  4  into beli_07027 (Id_beli,id_baju,Id_pegawai,Harga_beli,id_jual)values (8,8,8,'140000',null)
  5  into beli_07027 (Id_beli,id_baju,Id_pegawai,Harga_beli,id_jual)values (9,9,9,'150000',null)
  6  into beli_07027 (Id_beli,id_baju,Id_pegawai,Harga_beli,id_jual)values (10,10,10,'160000',null)
  7  select 1 from dual;
SQL> insert all
  2  into jual_07027 (Id_beli,Id_pegawai,Harga_jual,id_jual)values (6,6,'130000',6)
  3  into jual_07027 (Id_beli,Id_pegawai,Harga_jual,id_jual)values (7,7,'140000',7)
  4  into jual_07027 (Id_beli,Id_pegawai,Harga_jual,id_jual)values (8,8,'150000',8)
  5  into jual_07027 (Id_beli,Id_pegawai,Harga_jual,id_jual)values (9,9,'160000',9)
  6  into jual_07027 (Id_beli,Id_pegawai,Harga_jual,id_jual)values (10,10,'170000',10)
  7  select 1 from dual;
SQL> insert into laporan_07027 (Id_laporan,Id_jual,Id_pegawai,keuntungan)values (1,1,1,'200000');
SQL> insert into laporan_07027 (Id_laporan,Id_jual,Id_pegawai,keuntungan)values (2,2,2,'300000');
SQL> insert into laporan_07027 (Id_laporan,Id_jual,Id_pegawai,keuntungan)values (3,3,3,'400000');
SQL> insert into laporan_07027 (Id_laporan,Id_jual,Id_pegawai,keuntungan)values (5,5,5,'500000');
SQL> insert into laporan_07027 (Id_laporan,Id_jual,Id_pegawai,keuntungan)values (6,6,6,'600000');

SQL> select a.id_pegawai,b.id_laporan
  2  from pegawai_07027 a join
  3  laporan_07027 b
  4  on a.id_pegawai = b.id_pegawai
  5  where rownum <=10;

SQL> select a.nama_pegawai,b.harga_beli,c.harga_jual, (select count(*) from pegawai_07027) as jumlah_pegawai
  2  from pegawai_07027 a
  3  join beli_07027 b on a.id_pegawai = b.id_pegawai
  4  left join jual_07027 c on b.id_pegawai = c.id_pegawai;
SQL> select a.merk as nama_baju_dibeli,
  2  count(b.id_pegawai) as jumlah_transaksi,c.nama_pegawai as pegawai_yang_beli
  3  from baju_07027 a
  4  right join beli_07027 b
  5  on a.id_baju=b.id_baju
  6  right join pegawai_07027 c
  7  on b.id_pegawai = c.id_pegawai
  8  where not c.nama_pegawai like '%a%' and not c.nama_pegawai like '%i%'
  9  group by a.merk,c.nama_pegawai;
SQL> create view list_baju
  2  as select id_baju,merk
  3  from baju_07027;
SQL> create view list_laporan
  2  as select a.id_pegawai,b.id_laporan
  3  from pegawai_07027 a join
  4  laporan_07027 b
  5  on a.id_pegawai = b.id_pegawai
  6  where rownum <=10;
SQL> create view list_jumlah_pegawai
  2  as select a.nama_pegawai,b.harga_beli,c.harga_jual, (select count(*) from pegawai_07027) as banyak_pegawai
  3  from pegawai_07027 a
  4  join beli_07027 b on a.id_pegawai = b.id_pegawai
  5  left join jual_07027 c on b.id_pegawai = c.id_pegawai;
SQL> create view list_pegawai_beli
  2  as select a.merk as nama_baju_dibeli,
  3  count(b.id_pegawai) as jumlah_transaksi,c.nama_pegawai as pegawai_yang_beli
  4  from baju_07027 a
  5  right join beli_07027 b
  6  on a.id_baju=b.id_baju
  7  right join pegawai_07027 c
  8  on b.id_pegawai = c.id_pegawai
  9  where not c.nama_pegawai like '%a%' and not c.nama_pegawai like '%i%'
 10  group by a.merk,c.nama_pegawai;



