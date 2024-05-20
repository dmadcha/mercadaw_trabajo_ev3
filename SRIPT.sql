-- CLIENTES
INSERT INTO CLIENTES (cod_client, cod_postal, correo, nombre) 
VALUES(1, 28001, 'cliente1@example.com', 'Juan Perez');
INSERT INTO CLIENTES (cod_client, cod_postal, correo, nombre) 
VALUES (2, 28002, 'cliente2@example.com', 'Maria Lopez');
INSERT INTO CLIENTES (cod_client, cod_postal, correo, nombre) 
VALUES (3, 28003, 'cliente3@example.com', 'Carlos Sanchez');


-- EMPLEADOS
INSERT INTO EMPLEADOS (cod_emple, nombre, apellidos, categoria, fecha_inic) VALUES 
(1, 'Luis', 'Martinez', 'EMPLEADO', TO_DATE('2020-01-15', 'YYYY-MM-DD'));
INSERT INTO EMPLEADOS (cod_emple, nombre, apellidos, categoria, fecha_inic) VALUES 
(2, 'Ana', 'Gomez', 'REPONEDOR', TO_DATE('2019-03-22', 'YYYY-MM-DD'));
INSERT INTO EMPLEADOS (cod_emple, nombre, apellidos, categoria, fecha_inic) VALUES 
(3, 'Pedro', 'Fernandez', 'CAJERO', TO_DATE('2012-06-20', 'YYYY-MM-DD'));
INSERT INTO EMPLEADOS (cod_emple, nombre, apellidos, categoria, fecha_inic) VALUES 
(4, 'Lucia', 'Hernandez', 'ENCARGADO', TO_DATE('2018-02-21', 'YYYY-MM-DD'));

-- PRODUCTOS
INSERT INTO PRODUCTOS (cod_product, nombre, precio, marca, categoria, altura, anchura, peso, num_elementos, descr, stock) VALUES 
(1, 'Tomates', 1.00, 'MercaDAW', 'ALIMENTACION', 10.0, 5.0, 0.5, 100, 'tomates rojos', 50);
INSERT INTO PRODUCTOS (cod_product, nombre, precio, marca, categoria, altura, anchura, peso, num_elementos, descr, stock) VALUES 
(2, 'Jabón', 2.00, 'MercaDAW', 'DROGUERIA', 20.0, 10.0, 1.0, 200, 'Jabón de manos', 30);
INSERT INTO PRODUCTOS (cod_product, nombre, precio, marca, categoria, altura, anchura, peso, num_elementos, descr, stock) VALUES 
(3, 'Crema Facial', 3.00, 'MercaDAW', 'COSMETICA', 30.0, 15.0, 1.5, 300, 'Crema hidratante', 20);

-- COMPRAS
INSERT INTO COMPRAS (cod_compra, fecha, cod_product, cod_client) VALUES 
(1, TO_DATE('2023-02-22', 'YYYY-MM-DD'), 1, 1);
INSERT INTO COMPRAS (cod_compra, fecha, cod_product, cod_client) VALUES 
(2, TO_DATE('2024-05-20', 'YYYY-MM-DD'), 2, 2);
INSERT INTO COMPRAS (cod_compra, fecha, cod_product, cod_client) VALUES 
(3, TO_DATE('2005-05-14', 'YYYY-MM-DD'), 3, 3);
