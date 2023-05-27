drop database if exists order_management_database;
create database if not exists order_management_database;

USE order_management_database;


drop table if exists client;
drop table if exists product;
drop table if exists orderTable;

create table client(
	clientId int not null auto_increment,
    clientName varchar(50) not null,
    clientEmail varchar(50) not null,
    primary key (clientId)
);


create table product(
	productId int not null auto_increment,
    productName varchar(50) not null,
    productStock int,
    productPrice double not null,
    primary key (productId)
);

create table orderTable(
orderTableId int not null auto_increment,
clientId int not null,
productId int not null,
quantity int not null,
primary key (orderTableId),
foreign key (clientId) references client(clientId),
foreign key (productId) references product(productId)
);

#alter table orderTable add foreign key(clientId) references client(clientId) on delete cascade;
#alter table orderTable add foreign key(productId) references product(productId) on delete cascade;

insert  into client( clientName, clientEmail) values ("Alex Rus", "alex.rus111111@gmail.com");
insert  into client( clientName, clientEmail) values ("Matei Rus", "matei.rus111111@gmail.com");
insert  into client( clientName, clientEmail) values ("Bront Andrei", "nasuA@gmail.com");
insert  into client( clientName, clientEmail) values ("Constantin  Andrei", "andrei.qnay@gmail.com");
insert  into client( clientName, clientEmail) values ("Onica Andrei", "onica420@gmail.com");
insert  into client( clientName, clientEmail) values ("Daria Buzle", "piti@gmail.com");

insert into product( productName,productStock, productPrice) values("pisica",2,200.3);
insert into product( productName,productStock, productPrice) values("hrana pisici",3,55.80);
insert into product( productName,productStock, productPrice) values("caine",7,500.99);
insert into product( productName,productStock, productPrice) values("cusca",8,200.50);
insert into product( productName,productStock, productPrice) values("copacel",10,90.99);

insert into orderTable( clientId, productId, quantity) values (1,1,4);
insert into orderTable( clientId, productId, quantity) values (2,3,3);
insert into orderTable( clientId, productId, quantity) values (2,2,1);
insert into orderTable( clientId, productId, quantity) values (4,4,2);
insert into orderTable( clientId, productId, quantity) values (5,5,5);
insert into orderTable( clientId, productId, quantity) values (6,2,1);
