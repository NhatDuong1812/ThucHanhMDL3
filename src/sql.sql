drop database product;
create database product;
use product;
create table productlist(id int primary key auto_increment,name varchar(255),prime varchar(255),quantity varchar(255),color varchar(255), status varchar(255));
#
# -- Add new product
# DROP  PROCEDURE IF EXISTS addNewProduct;
# delimiter //
# create procedure addNewProduct(in _id varchar(30), in _name varchar(30), in _prime varchar(255),in _quantity varchar(255), in _color varchar(255),in _status varchar(255))
# begin
#     insert into productlist (id, name, prime, quantity,color, status)
#         VALUES (_id, _name, _prime, _quantity, _color, _status);
# end //
# //
# delimiter ;
# -- End
#
# -- Edit Product
# DROP  PROCEDURE IF EXISTS editProduct;
# delimiter //
# create procedure editProduct(in _id varchar(30), in _name varchar(30), in _prime varchar(255),in _quantity varchar(255), in _color varchar(255),in _status varchar(255))
# begin
#     update productlist set
#                        name = _name,
#                        prime = _prime,
#                        quantity = _quantity,
#                        color = _color,
#                        status = _status
#     where id = _id;
# end //
# //
# delimiter ;
# -- End
#
# -- Delete Product
# DROP  PROCEDURE IF EXISTS deleteProduct;
# delimiter //
# create procedure deleteProduct(in _id int)
# begin
#     delete from productlist where id = _id;
# end //
# //
# delimiter ;
# -- End