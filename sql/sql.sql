drop table MClient;
CREATE TABLE MClient (
    ID int primary key,
    clientName varchar(255),
    address varchar(255),
    email varchar(255),
    age int,
    money int
);

insert into MClient values(1, "Client1", "Adddress", "asda", 20, 20000);
insert into MClient values(2, "Client2", "add", "asda", 20, 20000);
insert into MClient values(3, "Client3", "Adddress", "asda", 20, 20000);
insert into MClient values(4, "Client4", "add", "asda", 20, 20000);
insert into MClient values(5, "Client5", "Adddress", "asda", 20, 20000);
insert into MClient values(6, "Client6", "add", "asda", 20, 20000);
insert into MClient values(7, "Client7", "Adddress", "asda", 20, 20000);
insert into MClient values(8, "Client9", "add", "asda", 20, 20000);

drop table MProduct;
CREATE TABLE MProduct (
    ID int primary key,
    productName varchar(255),
    quantity int,
    price int
);

insert into MProduct values(1, "Bread", 2, 3);
insert into MProduct values(2, "Sugar", 3, 5);
insert into MProduct values(3, "Bread", 20, 3);
insert into MProduct values(4, "Milk", 13, 5);
insert into MProduct values(5, "Meal", 14, 3);
insert into MProduct values(6, "Chicken", 2, 5);
insert into MProduct values(7, "Potato", 52, 3);
insert into MProduct values(8, "Tomato", 55, 5);

drop table MOrder;
CREATE TABLE MOrder (
    ID int primary key,
    clientID int,
    productID int,
    quantity int,
    totalPrice int
);
