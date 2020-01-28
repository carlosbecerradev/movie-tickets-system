-- use test;
-- drop database bd_cinewolke;
use bd_cinewolke;
------------------------
-- select * from roles;
insert into roles(tipo) values ('MARKETERO');
insert into roles(tipo) values ('ADMINISTRADOR');
------------------------
-- select * from usuarios;
insert into usuarios(username, contrasenia, id_rol, estado) values ('marketero', '123', 1,1);
insert into usuarios(username, contrasenia, id_rol, estado) values ('admin', '123', 2,1);
------------------------
update usuarios set contrasenia = '$2y$12$.QpqIDiTIyPG.CDtGJqjyO/OBNGXGg.r5X.ywD7dP7AALRgryaJai' where id = 1;
update usuarios set contrasenia = '$2y$12$.QpqIDiTIyPG.CDtGJqjyO/OBNGXGg.r5X.ywD7dP7AALRgryaJai' where id = 2;
------------------------
-- select * from generos;
insert into generos(nombre) values ('Terror');
insert into generos(nombre) values ('Comedia');
insert into generos(nombre) values ('Acción');
--------------
-- select * from salas;
--------------
-- select * from butacas;
-----------------------------
-- select * from proyecciones;
-- select * from butacas where id_sala = 2;
-- select * from reserva_butaca where id_proyeccion = 1;
-- select * from boletos;
-- select * from clientes;
-- select * from detalle_boleto;

select * from boletos b where b.fecha = '2020-01-26';

