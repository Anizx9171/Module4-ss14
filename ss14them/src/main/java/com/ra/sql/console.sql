CREATE TABLE category(
                         id int primary key auto_increment,
                         name varchar(100) NOT NULL UNIQUE,
                         status bit(1) DEFAULT 1
);

CREATE TABLE product(
                        id int primary key auto_increment,
                        name varchar(200) NOT NULL ,
                        price double NOT NULL ,
                        category_id int NOT NULL,
                        foreign key (category_id) references category(id)
);

delimiter //
create procedure proc_show_list_category()
begin
    select * from category;
end //

delimiter //
create procedure  proc_add_category(in cName varchar(50), cStatus bit(1))
begin
    insert into category(name, status) values (cName, cStatus);
end //

delimiter //
create procedure proc_update_category(in cName varchar(50), cStatus bit(1), cId int)
begin
    update category set name = cName, status = cStatus where id = cId;
end //

delimiter //
create procedure proc_delete_customer(in cId int)
begin
    delete from category where id = cId;
end //

delimiter //
create procedure proc_find_by_id(in cId int)
begin
    select *from category where id = cId;
end //

delimiter //
create procedure proc_find_by_name(in cName varchar(50))
begin
    select * from category where name like concat('%',cName,'%');
end //