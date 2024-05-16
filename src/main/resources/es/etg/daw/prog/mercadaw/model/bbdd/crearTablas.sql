CREATE TABLE Clientes
(
  cod_postal NUMERIC NOT NULL,
  correo VARCHAR,
  nombre VARCHAR,
  cod_client NUMERIC NOT NULL,
  PRIMARY KEY (cod_client)
);

CREATE TABLE Empleados
(
  cod_emple NUMERIC NOT NULL,
  nombre VARCHAR NOT NULL,
  apellidos VARCHAR NOT NULL,
  categoria VARCHAR NOT NULL,
  PRIMARY KEY (cod_emple)
);

CREATE TABLE Producto
(
  nombre VARCHAR NOT NULL,
  precio NUMERIC NOT NULL,
  marca VARCHAR NOT NULL,
  categoria VARCHAR NOT NULL,
  iva NUMERIC NOT NULL,
  altura NUMERIC NOT NULL,
  anchura NUMERIC NOT NULL,
  peso NUMERIC NOT NULL,
  num_elementos NUMERIC NOT NULL,
  desc VARCHAR NOT NULL,
  cod_produc NUMERIC NOT NULL,
  cod_emple NUMERIC NOT NULL,
  PRIMARY KEY (cod_produc),
  FOREIGN KEY (cod_emple) REFERENCES Empleado(cod_emple)
);

CREATE TABLE Compras
(
  fecha DATE NOT NULL,
  cod_compra NUMERIC NOT NULL,
  cod_produc NUMERIC NOT NULL,
  cod_client NUMERIC NOT NULL,
  PRIMARY KEY (cod_compra),
  FOREIGN KEY (cod_produc) REFERENCES Producto(cod_produc),
  FOREIGN KEY (cod_client) REFERENCES Clientes(cod_client)
);
