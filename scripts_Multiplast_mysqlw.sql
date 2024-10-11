use multiplast;

create table cliente(
    dni INT PRIMARY KEY,
    apenom VARCHAR(80),
    direccion VARCHAR(100),
    email VARCHAR(50),
    nrotel VARCHAR(15)
);

create table planta_produccion(
	nroplanta INT PRIMARY KEY,
    encargado VARCHAR(50)
);

create table pedido(
	nroPedido INT PRIMARY KEY AUTO_INCREMENT,
    dniCliente INT,
    nroPlanta INT,
    fecha DATE,
    descripcion VARCHAR(200),
    estado VARCHAR(25),
    tipoEntrega VARCHAR(50),
    importe DOUBLE default 0,
    FOREIGN KEY(dniCliente) REFERENCES cliente(dni),
    FOREIGN KEY(nroPlanta) REFERENCES planta_produccion(nroPlanta)
);


create table producto(
	codProducto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    descripcion VARCHAR(100),
    costoUnitario DOUBLE
      
);

create table materiaPrima(
	codMp INT PRIMARY KEY AUTO_INCREMENT,
    codProducto INT,
    nombre VARCHAR(50),
    descripcion VARCHAR(100),
    costoUnitario DOUBLE,
    cantidadDisponible INT,
    
    FOREIGN KEY(codProducto) REFERENCES producto(codProducto)
);

create table detalle_pedido(
	idDetalle INT PRIMARY KEY AUTO_INCREMENT,
    codProducto INT,
    nroPedido INT,
    cantidad INT,
    precioUnitario DOUBLE,
    
    FOREIGN KEY(codProducto) REFERENCES producto(codProducto),
    FOREIGN KEY(nroPedido) REFERENCES pedido(nroPedido)
    
);

create table domicilio(
	titular VARCHAR(100) PRIMARY KEY
);

create table sucursal(
	nroSucursal INT PRIMARY KEY UNIQUE,
    nombre VARCHAR(50)
);

create table despacho(
	nroPedido INT PRIMARY KEY,
    direccion VARCHAR(80),
    nroSucursal INT,
    titular VARCHAR(100),
    
    CONSTRAINT fk_sucursal FOREIGN KEY(nroPedido) REFERENCES sucursal(nroSucursal),
    CONSTRAINT fk_domicilio FOREIGN KEY(titular) REFERENCES domicilio(titular)
);


-- INSERCCION DE REGISTROS DE CLIENTES --
INSERT INTO cliente(dni,apenom,direccion,email,nrotel) 
VALUES(25487522,'Velazques Jose','Maria De Los Luceros 243','vj24@gmail.com',3777582555);

INSERT INTO cliente(dni,apenom,direccion,email,nrotel) 
VALUES(38487522,'Gomez Juana','Avenida Maipú 1244','gjuanita@gmail.com',3794472856);


-- INSERCCION DE REGISTROS DE PLANTAS DE PRODUCCION --
INSERT INTO planta_produccion(nroplanta,encargado)
VALUES(1,'Martinez Briant');

-- INSERCCION DE REGISTROS DE PRODUCTO --
INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('tacho contenedor de residuos','240 litros con ruedas',150000);

INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('Sanitarios Portatiles','Sanitarios portatiles para eventos',40000);

INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('Bolsas de consorcio 80 x 100 x 12 unidades','Bolsas de consorcio reforzadas',13200);

INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('piletas embutidas 3 x 6','piletas de verano para patio',480000);

INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('tubos pvc caño rigido','20mm 3/4 x 100 tiras',10000);

INSERT INTO producto(nombre,descripcion,costoUnitario)
VALUES('containers de basura','1100 litros',800000);

-- INSERCCION DE REGISTROS DE PEDIDOS --
INSERT INTO pedido(dniCliente,nroPlanta,fecha,descripcion,estado,tipoEntrega)
VALUES(25487522,1,'2024-10-04','pedido de containers de basura','pendiente','sucursal');
select * from producto;

-- INSERCCION DE REGISTROS DE DETALLES DE PEDIDOS --
INSERT INTO detalle_pedido(codProducto,nroPedido,cantidad,precioUnitario)
VALUES(7,2,2,800000);

select pedido.nroPedido,pedido.dniCliente,pedido.estado,pedido.nroPlanta,detalle_pedido.cantidad,detalle_pedido.precioUnitario
FROM pedido
INNER JOIN detalle_pedido ON pedido.nroPedido; 

SELECT * FROM pedido;
