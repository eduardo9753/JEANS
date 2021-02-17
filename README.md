# VENTA DE ROPA JEANS 
Desarrollo de una Pagina Web para la venta de pantalones jeans 

------------

HERRAMIENTAS :
- Base de Datos: Oracle 11g.
- Estilos: CSS3 y Bootstrap 4.
- Lenguaje : Lenguaje Java.

## Arquitectura MVC
1. MODELO: representación de los datos que maneja el sistema, su lógica de negocio, y sus mecanismos de persistencia.
2. VISTA: Información que se envía al cliente y los mecanismos interacción con éste.
3. CONTROLADOR: intermediario entre el Modelo y la Vista, gestionando el flujo de información entre ellos y las transformaciones para adaptar los datos a las necesidades de cada uno.

## Imagenes
PARTE CLIENTE:
- 1
![1](https://user-images.githubusercontent.com/68178186/101989463-6bf1a600-3c6e-11eb-8f93-1933d4b267ab.PNG)
- 2
![2](https://user-images.githubusercontent.com/68178186/101989461-6a27e280-3c6e-11eb-95ea-4d4f5a806b53.PNG)
- 3
![3](https://user-images.githubusercontent.com/68178186/101989460-685e1f00-3c6e-11eb-92be-1953ba39a320.PNG)
- 4
![4](https://user-images.githubusercontent.com/68178186/101989458-65fbc500-3c6e-11eb-942d-2e9e9ded6c4f.PNG)
- 5
![5](https://user-images.githubusercontent.com/68178186/101989457-63996b00-3c6e-11eb-8e77-35773af8014d.PNG)
- 6
![6](https://user-images.githubusercontent.com/68178186/101989455-61cfa780-3c6e-11eb-83e1-f1447e383f50.PNG)

PARTE SISTEMA
- 1 
![login](https://user-images.githubusercontent.com/68178186/101989451-5f6d4d80-3c6e-11eb-9e96-9911091c6211.PNG)
- 2
![sis1](https://user-images.githubusercontent.com/68178186/101989450-5da38a00-3c6e-11eb-9f5a-c3a91eb83cf0.PNG)
- 3
![sys2](https://user-images.githubusercontent.com/68178186/101989449-5b413000-3c6e-11eb-9d1d-d2ca95f125d7.PNG)
- 4
![sys3](https://user-images.githubusercontent.com/68178186/101989447-59776c80-3c6e-11eb-97a2-0e68dc06f2d5.PNG)
- 5
![sys4](https://user-images.githubusercontent.com/68178186/101989446-57ada900-3c6e-11eb-8b38-72d9ab5f9f16.PNG)

### SCRIPT DE LA BASE DE DATOS
```sql
------------------------------------------CREACION DE TABLAS--------------------------------------------------
CREATE TABLE administrador(
  idAdmin int PRIMARY KEY NOT NULL,
  nombre varchar2(40) NOT NULL,
  primerApellido varchar2(40) NOT NULL,
  nombreAdmin varchar2(40) NOT NULL,
  correo varchar2(100) NOT NULL,
  idrol int NOT NULL,--FORANEA tabla rol
  estado_admin int NOT NULL
);


--TABLA ROL
CREATE TABLE rol(
  idrol int PRIMARY KEY NOT NULL,
  nombreRol varchar2(30) NOT NULL
);
--UN ADMIN PUEDE TENER UN ROL Y UN ROL VARIOS ADMIN(2)


--TABLA CLIENTE
CREATE TABLE cliente (
  Dni varchar2(8) PRIMARY KEY NOT NULL,
  Nombre varchar2(255) NOT NULL,
  PrimerApellido varchar2(40) NOT NULL,
  Direccion varchar2(255) NOT NULL,
  Email varchar2(255) NOT NULL,
  Celular  int NOT NULL,
  idsector char(2) NOT NULL,--foranea tabla sector
  estado_cliente int NOT NULL
);


--TABLA RECLAMOS
CREATE TABLE libroReclamos(
  idlibroReclamos int PRIMARY KEY NOT NULL,
  Dni_cliente varchar2(8) NOT NULL,--foranea cliente
  Email varchar2(255) NOT NULL,
  Celular  int NOT NULL,
  reclamo varchar2(255) NOT NULL,
  Fecha DATE NOT NULL,
  estado_libro int NOT NULL
);

--TABLA SECTOR
CREATE TABLE sector(
  idsector char(2) PRIMARY KEY NOT NULL,
  sector varchar2(20) NOT NULL
);

--TABLA COMPRAS
CREATE TABLE compras (
  idCompras int PRIMARY KEY NOT NULL,
  Dni varchar2(8)  NOT NULL,--foranea
  FechaCompras VARCHAR2(20) NOT NULL,
  Monto number(6,2),
  Estado varchar2(50) NOT NULL,
  estado_compras int NOT NULL
);

--TABLA PRODUCTOS
CREATE TABLE producto (
  idProducto int PRIMARY KEY NOT NULL,
  Nombres varchar2(255) NOT NULL,
  imagen varchar2(50),
  Descripcion varchar2(255) NOT NULL,
  Precio number(6,2) ,
  Stock int  NOT NULL,
  idcategoria int NOT NULL,--foranea tabla categoria
  idestado int NOT NULL--foranea tabla estado
);

 --TABLA DETALLE-COMPRAS
CREATE TABLE detalle_compras (
  idDetalle int PRIMARY KEY NOT NULL,
  idProducto int NOT NULL,--foranea tabla productos
  idCompras int NOT NULL,--foranea tabla compras
  Cantidad int NOT NULL,
  PrecioCompra float NOT NULL 
);

--TABLA CATEGORIA
CREATE TABLE categoria (
  idcategoria int PRIMARY KEY NOT NULL,
  categoria varchar2(50) NOT NULL
);

--TABLA ESTADO
CREATE TABLE estado (
  idestado int PRIMARY KEY NOT NULL,
  estado varchar2(50) NOT NULL
);
-------------------------------------------------------------------------------------------------------------------



-------------------------------------------AUTO INCREMENT----------------------------------------------------------
--AUTOINCREMNET ADMINISTRADOR
CREATE SEQUENCE idAdmin_admin
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idAdmin
BEFORE INSERT ON administrador
FOR EACH ROW
BEGIN
SELECT idAdmin_admin.NEXTVAL INTO :NEW.idAdmin FROM DUAL;
END;


--AUTOINCREMNET ROL
CREATE SEQUENCE idrol_rol
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idrol
BEFORE INSERT ON rol
FOR EACH ROW
BEGIN
SELECT idrol_rol.NEXTVAL INTO :NEW.idrol FROM DUAL;
END;


--AUTOINCREMNET libroReclamos
CREATE SEQUENCE libro_idlibroReclamos
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idlibroReclamos
BEFORE INSERT ON libroReclamos
FOR EACH ROW
BEGIN
SELECT libro_idlibroReclamos.NEXTVAL INTO :NEW.idlibroReclamos FROM DUAL;
END;


--AUTOINCREMNET COMPRAS
CREATE SEQUENCE idCompras_compras
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idCompras
BEFORE INSERT ON compras
FOR EACH ROW
BEGIN
SELECT idCompras_compras.NEXTVAL INTO :NEW.idCompras FROM DUAL;
END;


--AUTOINCREMNET PRODUCTOS
CREATE SEQUENCE id_producto
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idproducto
BEFORE INSERT ON producto
FOR EACH ROW
BEGIN
SELECT id_producto.NEXTVAL INTO :NEW.idProducto FROM DUAL;
END;


--AUTOINCREMNET DETALLE COMPRA
CREATE SEQUENCE idDetalle_detalle_compra
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idDetalle
BEFORE INSERT ON detalle_compras
FOR EACH ROW
BEGIN
SELECT idDetalle_detalle_compra.NEXTVAL INTO :NEW.idDetalle FROM DUAL;
END;


--AUTOINCREMNET CATEGORIA
CREATE SEQUENCE idcategoria_categoria
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idcategoria
BEFORE INSERT ON categoria
FOR EACH ROW
BEGIN
SELECT idcategoria_categoria.NEXTVAL INTO :NEW.idcategoria FROM DUAL;
END;


--AUTOINCREMNET ESTADO
CREATE SEQUENCE idestado_estado
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER tr_idestado
BEFORE INSERT ON estado
FOR EACH ROW
BEGIN
SELECT idestado_estado.NEXTVAL INTO :NEW.idestado FROM DUAL;
END;
-------------------------------------------------------------------------------------------------------------------



-------------------------------------------LLAVES FORANES----------------------------------------------------------
--cliente con Compras
ALTER TABLE compras 
   ADD CONSTRAINT FK_DNICliente FOREIGN KEY (Dni)
      REFERENCES cliente (Dni)
;


--cliente con sector
ALTER TABLE cliente 
   ADD CONSTRAINT FK_idsector FOREIGN KEY (idsector)
      REFERENCES sector (idsector)
;
--libroReclamos con clientes
ALTER TABLE libroReclamos 
   ADD CONSTRAINT FK_Dni_cliente FOREIGN KEY (Dni_cliente)
      REFERENCES cliente (Dni)
;
--Detalle-compras con Productos
ALTER TABLE detalle_compras 
   ADD CONSTRAINT FK_idProducto FOREIGN KEY (idProducto)
      REFERENCES producto (idProducto)
;
--Detalle-compras con Compras
ALTER TABLE detalle_compras 
   ADD CONSTRAINT FK_idCompras FOREIGN KEY (idCompras)
      REFERENCES compras (idCompras)
;


--Productos con Categoria
ALTER TABLE producto 
   ADD CONSTRAINT FK_idcategoria FOREIGN KEY (idcategoria)
      REFERENCES categoria (idcategoria)
;
--Productos con Estado
ALTER TABLE producto 
   ADD CONSTRAINT FK_idestado FOREIGN KEY (idestado)
      REFERENCES estado (idestado)
;
--ADMIN con ROL
ALTER TABLE administrador 
   ADD CONSTRAINT FK_idrol FOREIGN KEY (idrol)
      REFERENCES rol (idrol)
;
-------------------------------------------------------------------------------------------------------------------



-------------------------------------------	INSERT DE TABLAS-------------------------------------------------------


--INSERT ROL
INSERT INTO rol (nombreRol) VALUES('Admin');
INSERT INTO rol (nombreRol) VALUES('Trabajador');

--INSERT ADMIN
INSERT INTO administrador (nombre,primerApellido,nombreAdmin,correo,idrol,estado_admin)
VALUES('anthony','nuñez','anthony123','anthony.anec@gmail.com',1,1);

INSERT INTO administrador (nombre,primerApellido,nombreAdmin,correo,idrol,estado_admin)
VALUES('mabell','nuñez','maby','maby.anec@gmail.com',1,1);

--INSERT SECTOR
INSERT INTO sector  VALUES('CA','CARABAYLLO');
INSERT INTO sector  VALUES('CH','CHORRILLOS');
INSERT INTO sector  VALUES('MG','MAGDALENA');
INSERT INTO sector  VALUES('SI','SAN ISIDRO');
INSERT INTO sector  VALUES('MF','MIRA FLORES');
INSERT INTO sector  VALUES('CL','CENTRO DE LIMA');
INSERT INTO sector  VALUES('CM','COMAS');
INSERT INTO sector  VALUES('LM','LA MOLINA');
INSERT INTO sector  VALUES('CT','CAQUETA');
INSERT INTO sector  VALUES('CO','COLLIQUE');


--INSERT CLIENTE
INSERT INTO cliente(Dni,Nombre,PrimerApellido,Direccion,Email,Celular,idsector,estado_cliente)
VALUES('1234567','Juan Carlos','Valdez','Av los Pinos San Isidro','juan@gmail.com',989898981,'SI',1);

--INSERT COMPRAS
INSERT INTO compras(Dni,FechaCompras,Monto,Estado,estado_compras) VALUES('1234567','24-11-2020',400,'comprado',1);

--INSERT LIBRO RECLAMOS
INSERT INTO libroReclamos(Dni_cliente,Email,Celular,reclamo,Fecha,estado_libro) VALUES('1234567','juan@gmail.com',989898981,'hubo un error de la compra','24-11-2020',1);


--INSERT DE TABLA DE CATEGORIA
INSERT INTO categoria (categoria) VALUES('pantalon Jeans'); 
INSERT INTO categoria (categoria) VALUES('Casaca Jeans');

--INSERT DE TABLA DE ESTADO
INSERT INTO estado (estado) VALUES('Nuevo'); 
INSERT INTO estado (estado) VALUES('Agotado'); 



--INSERT DE TABLA DE PRODUCTOS
INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean1.jpg','Jeans fabricado con algodon de nilon, resistente',35.99,10,1,1);

INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean2.jpg','Jeans fabricado con algodon pyma, lijero',45.99,10,1,1);

INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean3.jpg','Jeans fabricado liga estirable, resistente',30.99,10,1,1);

INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean4.jpg','Jeans ochentero, resistente',50.99,10,1,1);

INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean5.jpg','Jeans junevil, full estacion',53.99,10,1,1);

INSERT INTO producto (Nombres,imagen,Descripcion,Precio,Stock,idcategoria,idestado)
VALUES('Pantalon Jean','jean6.jpg','Jeans junevil, full estacion',50.99,10,1,1);
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------	SELECT DE TABLAS-------------------------------------------------------
--SELECT DE TABLAS
 SELECT idProducto,Nombres,
         imagen,Descripcion,Precio,
		 Stock FROM producto;

 SELECT categoria , idcategoria FROM categoria;
 SELECT estado , idestado FROM estado;
 SELECT idrol, nombreRol FROM rol;

 SELECT nombre,nombreAdmin,correo,estado_admin FROM administrador
       WHERE correo = 'maby.anec@gmail.com' AND nombreAdmin = 'maby';
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------	UPDATE TABLA COMPRAS--------------------------------------------------
UPDATE compras SET Dni = '1234567',
         FechaCompras = '24/11/20',
		 Monto = 400,
		 Estado = 'Comprado',
		 estado_compras = 0 WHERE idCompras = 4;

SELECT * FROM compras;
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------	UPDATE TABLA PRODUCTO--------------------------------------------------
UPDATE producto SET Nombres = 'jjj',
         imagen = 'una.jpg',
		 Descripcion = 'nnnnn',
		 Precio = 55,
		 Stock = 10,
		 idcategoria = 1,
		 idestado = 1
		 WHERE idProducto = 8;
-------------------------------------------------------------------------------------------------------------------


-----------------------------------------------UPDATE TABLA ADMIN--------------------------------------------------
UPDATE administrador SET nombre = 'ac',
		 primerApellido = 'ac',
		 nombreAdmin = 'ac',
		 correo = 'ac@gmail.com',
         idrol = 1,
         estado_admin = 0 WHERE idAdmin = 5;

SELECT * FROM administrador;
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------	DELETE TABLA ADMIN--------------------------------------------------
DELETE FROM administrador WHERE idAdmin = 1;
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------	DELETE TABLA PRODUCTO--------------------------------------------------
DELETE FROM producto WHERE idProducto = 9;
-------------------------------------------------------------------------------------------------------------------


-------------------------------------------	UPDATE TABLA CLIENTE---------------------------------------------------
UPDATE cliente SET Nombre = 'rocky',
                   PrimerApellido = 'Vales',
                   Direccion = 'collique 3zn Comas',
                   Email = 'roky@gmail.com',
                   Celular = 998876688,
                   idsector = 'SI',
                   estado_cliente = 1 WHERE Dni = '7878655';
    
    SELECT * FROM  cliente;             
-------------------------------------------------------------------------------------------------------------------

--------------------------------------------DELETE TABLA CLIENTE--------------------------------------------------
DELETE FROM cliente WHERE Dni = 1234567;
-------------------------------------------------------------------------------------------------------------------

-------------------------------------------CREACION DE VISTAS TABLA PRODUCTO---------------------------------------
CREATE OR REPLACE VIEW View_Produtos
AS
SELECT P.idProducto, P.Descripcion, P.imagen ,P.Nombres ,P.Precio ,P.Stock,
       C.categoria,C.idcategoria,E.idestado,E.estado
       FROM producto  P

	   INNER JOIN categoria  C 
	   ON C.idcategoria = P.idcategoria

	   INNER JOIN estado  E
	   ON C.idcategoria = E.idestado;
--------------------------------------------------------------------------------------------------------------------

------------------------------------------CREACION DE VISTAS TABLA ADMIN ROL----------------------------------------
CREATE OR REPLACE VIEW View_Admi_Rol
AS
SELECT Ad.idAdmin, Ad.nombre, Ad.primerApellido, ad.correo, Ad.nombreAdmin,Ad.idrol,Ad.estado_admin,
       R.nombreRol
       FROM administrador Ad
	   INNER JOIN rol R 
	   ON R.idrol = Ad.idrol;
--------------------------------------------------------------------------------------------------------------------


-------------------------------------------ULTIMO VALOR INSERTADO---------------------------------------------------
SELECT MAX(idCompras) FROM compras;  
--------------------------------------------------------------------------------------------------------------------


-------------------------------------------CREACION DE VISTAS TABLA SECTOR------------------------------------------
CREATE OR REPLACE VIEW View_Sector
AS SELECT idsector , sector 
   FROM sector;
--------------------------------------------------------------------------------------------------------------------

-------------------------------------------CREACION DE VISTAS TABLA CATEGORIA---------------------------------------
CREATE OR REPLACE VIEW View_Categoria
AS SELECT categoria , idcategoria 
   FROM categoria;
--------------------------------------------------------------------------------------------------------------------


-------------------------------------------CREACION DE VISTAS TABLA ESTADO------------------------------------------
CREATE OR REPLACE VIEW View_Estado
AS SELECT estado , idestado
   FROM estado;
--------------------------------------------------------------------------------------------------------------------


-------------------------------------------CREACION DE VISTAS TABLA COMPRAS-----------------------------------------
CREATE OR REPLACE VIEW View_Compras
AS SELECT idCompras, Dni, FechaCompras,
          Monto, Estado, estado_compras
          FROM compras;
--------------------------------------------------------------------------------------------------------------------          

-------------------------------------------CREACION DE VISTAS TABLA CLIENTE-----------------------------------------  
CREATE OR REPLACE VIEW View_Cliente 
AS
SELECT Dni,Nombre,PrimerApellido,Direccion,
       Email,Celular,idsector,estado_cliente
       FROM cliente;
---------------------------------------------------------------------------------------------------------------------


-----------------------------------------------VISTA CLIENTE-COMPRAS-------------------------------------------------
CREATE OR REPLACE VIEW FACTURA_CLIENTE
AS
SELECT cli.dni,cli.nombre,cli.primerapellido,cli.direccion ,cli.email,cli.celular,
        compra.fechacompras,compra.monto,compra.estado
        
        FROM cliente cli
        INNER JOIN compras compra
        ON  compra.dni = cli.dni;
--------------------------------------------------------------------------------------------------------------------


SELECT * FROM View_Admi_Rol WHERE estado_admin=1;
SELECT * FROM View_Cliente WHERE estado_cliente=1;
SELECT * FROM View_Sector;
SELECT * FROM View_Categoria;
SELECT * FROM View_Estado;
SELECT * FROM View_Produtos;
SELECT * FROM View_Compras WHERE estado_compras =1;
SELECT * FROM FACTURA_CLIENTE  WHERE dni = '1234567' AND fechacompras = '24-11-2020';


------------------------------------------STORE PROCEDURE INSERT COMPRAS--------------------------------------------
CREATE OR REPLACE PROCEDURE SP_INSERT_COMPRAS
(
  SP_Dni_compras IN compras.Dni%TYPE,
  SP_Fecha_compras IN compras.FechaCompras%TYPE,
  SP_Monto_compras IN compras.Monto%TYPE,
  SP_Estado_compras  IN compras.Estado%TYPE,
  SP_estadocompra_compras IN  compras.estado_compras%TYPE
)
IS 
  BEGIN
  INSERT INTO compras(Dni,
                      FechaCompras,
                      Monto,
                      Estado,
                      estado_compras)
              VALUES(SP_Dni_compras,
                     SP_Fecha_compras,
                     SP_Monto_compras,
                     SP_Estado_compras,
                     SP_estadocompra_compras);
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA INSERT DE LA COMPRA');
END;

--EJECUCION DEL PROCEDIMEINTO INSERT COMPRA
BEGIN 
  SP_INSERT_COMPRAS('1234567','24-11-20',500,'comprado',3);
END;
--------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE UPDATE COMPRAS--------------------------------------------
CREATE OR REPLACE PROCEDURE SP_UPDATE_COMPRAS
(
  SP_Dni_compras IN compras.Dni%TYPE,
  SP_Fecha_cliente IN compras.FechaCompras%TYPE,
  SP_Monto_compras IN compras.Monto%TYPE,
  SP_Estado_compras  IN compras.Estado%TYPE,
  SP_estadocompra_compras IN  compras.estado_compras%TYPE,
  SP_idcompra_compras IN compras.idcompras%TYPE
)
IS 
  BEGIN
  UPDATE compras SET Dni = SP_Dni_compras,
         FechaCompras = SP_Fecha_cliente,
		 Monto = SP_Monto_compras,
		 Estado = SP_Estado_compras,
		 estado_compras = SP_estadocompra_compras WHERE idCompras = SP_idcompra_compras;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA ACTUALIZACION DE LA COMPRA');
END;

--EJECUCION DEL PROCEDIMEINTO UPDATE COMPRA
BEGIN 
  SP_UPDATE_COMPRAS('1234567','24/11/20',300,'comprado',1);
END;
--------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE INSERT CLIENTE---------------------------------------------
CREATE OR REPLACE PROCEDURE SP_INSERT_CLIENTE
(
  SP_Dni_cliente    IN cliente.dni%TYPE,
  SP_Nombre_cliente IN cliente.nombre%TYPE,
  SP_Primer_Apellido_cliente IN cliente.primerapellido%TYPE,
  SP_Direccion_cliente IN cliente.direccion%TYPE,
  SP_Email_cliente  IN cliente.email%TYPE,
  SP_Celular_cliente IN  cliente.celular%TYPE,
  SP_idSector_cliente IN cliente.idsector%TYPE,
  SP_estado_cliente IN cliente.estado_cliente%TYPE
)
IS 
  BEGIN
  INSERT INTO cliente(Dni,
                      Nombre,
                      PrimerApellido,
                      Direccion,
                      Email,
                      Celular,
                      idsector,
                      estado_cliente)
              VALUES (SP_Dni_cliente,
                      SP_Nombre_cliente,
                      SP_Primer_Apellido_cliente,
                      SP_Direccion_cliente,
                      SP_Email_cliente,
                      SP_Celular_cliente,
                      SP_idSector_cliente,
                      SP_estado_cliente);
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA INSERCION CLIENTE');
END;

--EJECUCION DEL PROCEDIMEINTO INSERT CLIENTE
BEGIN 
  SP_INSERT_CLIENTE(7878655,'rocky','canchari','av 3rz zona de collique','rocky@gmail.com',0090908,'SI',1);
END;
---------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE UPDATE CLIENTE---------------------------------------------
CREATE OR REPLACE PROCEDURE SP_UPDATE_CLIENTE
(
  SP_Nombre_cliente IN cliente.nombre%TYPE,
  SP_Primer_Apellido_cliente IN cliente.primerapellido%TYPE,
  SP_Direccion_cliente IN cliente.direccion%TYPE,
  SP_Email_cliente  IN cliente.email%TYPE,
  SP_Celular_cliente IN  cliente.celular%TYPE,
  SP_idSector_cliente IN cliente.idsector%TYPE,
  SP_estado_cliente IN cliente.estado_cliente%TYPE,
  SP_Dni_cliente    IN cliente.dni%TYPE
)
IS 
  BEGIN
  UPDATE cliente SET Nombre = SP_Nombre_cliente,
                     PrimerApellido = SP_Primer_Apellido_cliente,
                     Direccion = SP_Direccion_cliente,
                     Email = SP_Email_cliente,
                     Celular = SP_Celular_cliente,
                     idsector = SP_idSector_cliente,
                     estado_cliente=SP_estado_cliente WHERE Dni = SP_Dni_cliente;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA UPDATE');
END;

--EJECUCION DEL PROCEDIMEINTO UPDATE CLIENTE
BEGIN 
  SP_UPDATE_CLIENTE('juan','lopez','av los jirasoles carabayllo','juan@gmail.com',989898988,'CA',1,1234567);
END;

SELECT * FROM cliente;
---------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE INSERT PRODUCTO---------------------------------------------
CREATE OR REPLACE PROCEDURE SP_INSERT_PRODUCTO
(
  SP_Nombre_producto IN producto.nombres%TYPE,
  SP_Imagen_producto IN producto.imagen%TYPE,
  SP_Descripcion_producto IN producto.descripcion%TYPE,
  SP_Precio_producto  IN producto.precio%TYPE,
  SP_Stock_producto IN  producto.stock%TYPE,
  SP_idcategoria_producto IN producto.idcategoria%TYPE,
  SP_idestado_producto    IN producto.idestado%TYPE
)
IS 
  BEGIN
  INSERT INTO producto (Nombres,
                        imagen,
                        Descripcion,
                        Precio,
                        Stock,
                        idcategoria,
                        idestado)
        VALUES(SP_Nombre_producto,
               SP_Imagen_producto,
               SP_Descripcion_producto,
               SP_Precio_producto,
               SP_Stock_producto,
               SP_idcategoria_producto,
               SP_idestado_producto);
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA INSERCION PRODUCTO');
END;

--EJECUCION DEL PROCEDIMEINTO UPDATE CLIENTE
BEGIN 
  SP_INSERT_PRODUCTO('producto prueba','imgprueba.jpg','description',45.66,12,1,1);
END;
---------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE UPDATE PRODUCTO---------------------------------------------
CREATE OR REPLACE PROCEDURE SP_UPDATE_PRODUCTO
(
  SP_Nombre_producto IN producto.nombres%TYPE,
  SP_Imagen_producto IN producto.imagen%TYPE,
  SP_Descripcion_producto IN producto.descripcion%TYPE,
  SP_Precio_producto  IN producto.precio%TYPE,
  SP_Stock_producto IN  producto.stock%TYPE,
  SP_idcategoria_producto IN producto.idcategoria%TYPE,
  SP_idestado_producto    IN producto.idestado%TYPE,
  SP_idproducto_producto IN producto.idproducto%TYPE
)
IS 
  BEGIN
  UPDATE producto SET Nombres=SP_Nombre_producto,
                    imagen=SP_Imagen_producto,
                    Descripcion=SP_Descripcion_producto,
                    Precio=SP_Precio_producto,
                    Stock=SP_Stock_producto,
                    idcategoria=SP_idcategoria_producto,
                    idestado=SP_idestado_producto WHERE idProducto=SP_idproducto_producto;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA UPDATE PRODUCTO');
END;

--EJECUCION DEL PROCEDIMEINTO UPDATE CLIENTE
BEGIN 
  SP_UPDATE_PRODUCTO('producto 1 AC','imgprueba.jpg','description',45.66,12,1,1,7);
END;
---------------------------------------------------------------------------------------------------------------------

------------------------------------------STORE PROCEDURE DELETE PRODUCTO---------------------------------------------
CREATE OR REPLACE PROCEDURE SP_DELETE_PRODUCTO(
  SP_idproducto_producto IN producto.idproducto%TYPE
)
IS 
  BEGIN
  DELETE FROM producto WHERE idProducto = SP_idproducto_producto;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA DELETE PRODUCTO');
END;

--EJECUCION DEL PROCEDIMEINTO DELETE CLIENTE
BEGIN 
  SP_DELETE_PRODUCTO(21);
END;
---------------------------------------------------------------------------------------------------------------------

---------------------------------------------CREACION DE PAQUETE ADMIN-----------------------------------------------
/*CABECERA PACKAGE ADMIN*/
CREATE OR REPLACE PACKAGE MANTENIMIENTO_ADMIN
IS
  /*PRIMER PROCESO*/
  PROCEDURE PK_INSERT_ADMIN(/*INSERT ADMIN*/
   PK_Nombre_Admin IN administrador.nombre%TYPE,
   PK_PrimerApellido_Admin IN administrador.primerapellido%TYPE,
   PK_NombreAdmin_Admin IN administrador.nombreAdmin%TYPE,
   PK_Correo_Admin IN administrador.correo%TYPE,
   PK_Idrol_Admin IN administrador.idrol%TYPE,
   PK_estado_Admin IN administrador.estado_admin%TYPE 
  );


  /*SEGUNDO PROCESO*/
  PROCEDURE PK_UPDATE_ADMIN(/*UPDATE ADMIN*/
   PK_Nombre_Admin IN administrador.nombre%TYPE,
   PK_PrimerApellido_Admin IN administrador.primerapellido%TYPE,
   PK_NombreAdmin_Admin IN administrador.nombreAdmin%TYPE,
   PK_Correo_Admin IN administrador.correo%TYPE,
   PK_Idrol_Admin IN administrador.idrol%TYPE,
   PK_estado_Admin IN administrador.estado_admin%TYPE ,
   PK_IdAdmin_Admin IN administrador.idadmin%TYPE
  );

  /*TERCER PROCESO*/
END  MANTENIMIENTO_ADMIN;/*CIERRE PAQUETE ADMIN*/ 


/*CUERPO PACKAGE ADMIN*/
CREATE OR REPLACE PACKAGE BODY MANTENIMIENTO_ADMIN
IS
  /*INSERT ADMIN PROCEDIMIENTO*/
  PROCEDURE PK_INSERT_ADMIN(/*INSERT ADMIN*/
   PK_Nombre_Admin IN administrador.nombre%TYPE,
   PK_PrimerApellido_Admin IN administrador.primerapellido%TYPE,
   PK_NombreAdmin_Admin IN administrador.nombreAdmin%TYPE,
   PK_Correo_Admin IN administrador.correo%TYPE,
   PK_Idrol_Admin IN administrador.idrol%TYPE,
   PK_estado_Admin IN administrador.estado_admin%TYPE
  )
  AS
  BEGIN
  INSERT INTO administrador(nombre,
                            primerapellido,
                            nombreAdmin,
                            correo,
                            idrol,
                            estado_admin
                            )
         VALUES(PK_Nombre_Admin,
                PK_PrimerApellido_Admin,
                PK_NombreAdmin_Admin,
                PK_Correo_Admin,
                PK_Idrol_Admin,
                PK_estado_Admin);
                
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA INSERCION ADMIN');
  END;
  
  /*UPDATE ADMIN PROCEDIMIENTO*/
  PROCEDURE PK_UPDATE_ADMIN(
   PK_Nombre_Admin IN administrador.nombre%TYPE,
   PK_PrimerApellido_Admin IN administrador.primerapellido%TYPE,
   PK_NombreAdmin_Admin IN administrador.nombreAdmin%TYPE,
   PK_Correo_Admin IN administrador.correo%TYPE,
   PK_Idrol_Admin IN administrador.idrol%TYPE,
   PK_estado_Admin IN administrador.estado_admin%TYPE ,
   PK_IdAdmin_Admin IN administrador.idadmin%TYPE
  )
  AS
  BEGIN
  UPDATE administrador SET nombre = PK_Nombre_Admin,
		 primerApellido = PK_PrimerApellido_Admin,
		 nombreAdmin = PK_NombreAdmin_Admin,
		 correo = PK_Correo_Admin,
         idrol = PK_Idrol_Admin,
         estado_admin = PK_estado_Admin WHERE idAdmin = PK_IdAdmin_Admin;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA UPDATE ADMIN');
  END;
  
  
END;/*CIERRE BODY PAQUETE ADMIN*/

SELECT * FROM administrador;

--EJECUCION DEL PAQUETE ADMIN INSERT
BEGIN 
  MANTENIMIENTO_ADMIN.pk_insert_admin('prueba3','apellido3','prueba321','@prueba.com',2,1);
END;

--EJECUCION DEL PAQUETE ADMIN UPDATE
BEGIN 
  mantenimiento_admin.PK_UPDATE_ADMIN('prueba','prueba','prueba123','prueba@prueba.com',1,1,5);
END;


---------------------------------------------CREACION DE PAQUETE PRODUCTO--------------------------------------------
/*CABECERA PACKAGE PRODUCTO*/
CREATE OR REPLACE PACKAGE MANTENIMIENTO_PRODUCTO
IS
  /*INSERT PRODUCTO PROCEDIMIENTO*/
  PROCEDURE PK_INSERT_PRODUCTO(
    PK_Nombre_producto IN producto.nombres%TYPE,
    PK_Imagen_producto IN producto.imagen%TYPE,
    PK_Descripcion_producto IN producto.descripcion%TYPE,
    PK_Precio_producto  IN producto.precio%TYPE,
    PK_Stock_producto IN  producto.stock%TYPE,
    PK_idcategoria_producto IN producto.idcategoria%TYPE,
    PK_idestado_producto    IN producto.idestado%TYPE
  );
  
  /*UPDATE PRODUCTO PROCEDIMIENTO*/
  PROCEDURE PK_UPDATE_PRODUCTO(
    PK_Nombre_producto IN producto.nombres%TYPE,
    PK_Imagen_producto IN producto.imagen%TYPE,
    PK_Descripcion_producto IN producto.descripcion%TYPE,
    PK_Precio_producto  IN producto.precio%TYPE,
    PK_Stock_producto IN  producto.stock%TYPE,
    PK_idcategoria_producto IN producto.idcategoria%TYPE,
    PK_idestado_producto    IN producto.idestado%TYPE,
    PK_idproducto_producto IN producto.idproducto%TYPE
  );
  
  
  /*DELETE PRODUCTO PROCEDIMIENTO*/
  PROCEDURE PK_DELETE_PRODUCTO(
    PK_idproducto_producto IN producto.idproducto%TYPE
  );
  
  
END;/*CABECERA PACKAGE PRODUCTO*/


/*CUERPO PACKAGE PRODUCTO*/
CREATE OR REPLACE PACKAGE BODY MANTENIMIENTO_PRODUCTO
IS
  PROCEDURE PK_INSERT_PRODUCTO(/*INSERT PRODUCTO*/
    PK_Nombre_producto IN producto.nombres%TYPE,
    PK_Imagen_producto IN producto.imagen%TYPE,
    PK_Descripcion_producto IN producto.descripcion%TYPE,
    PK_Precio_producto  IN producto.precio%TYPE,
    PK_Stock_producto IN  producto.stock%TYPE,
    PK_idcategoria_producto IN producto.idcategoria%TYPE,
    PK_idestado_producto    IN producto.idestado%TYPE
  )
  IS
  BEGIN
  INSERT INTO producto (Nombres,
                        imagen,
                        Descripcion,
                        Precio,
                        Stock,
                        idcategoria,
                        idestado)
        VALUES(PK_Nombre_producto,
               PK_Imagen_producto,
               PK_Descripcion_producto,
               PK_Precio_producto,
               PK_Stock_producto,
               PK_idcategoria_producto,
               PK_idestado_producto);
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA INSERCION PRODUCTO');
  END;
  
  
  PROCEDURE PK_UPDATE_PRODUCTO(/*ACTUALIZAR PRODUCTO*/
    PK_Nombre_producto IN producto.nombres%TYPE,
    PK_Imagen_producto IN producto.imagen%TYPE,
    PK_Descripcion_producto IN producto.descripcion%TYPE,
    PK_Precio_producto  IN producto.precio%TYPE,
    PK_Stock_producto IN  producto.stock%TYPE,
    PK_idcategoria_producto IN producto.idcategoria%TYPE,
    PK_idestado_producto    IN producto.idestado%TYPE,
    PK_idproducto_producto IN producto.idproducto%TYPE
  )
  IS 
  BEGIN
  UPDATE producto SET Nombres=PK_Nombre_producto,
                    imagen=PK_Imagen_producto,
                    Descripcion=PK_Descripcion_producto,
                    Precio=PK_Precio_producto,
                    Stock=PK_Stock_producto,
                    idcategoria=PK_idcategoria_producto,
                    idestado=PK_idestado_producto WHERE idProducto=PK_idproducto_producto;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA UPDATE PRODUCTO');
  END;


  PROCEDURE PK_DELETE_PRODUCTO(/*ELIMINAR PRODUCTO*/
    PK_idproducto_producto IN producto.idproducto%TYPE
  )
  IS 
  BEGIN
  DELETE FROM producto WHERE idProducto = PK_idproducto_producto;
         
  EXCEPTION WHEN no_data_found THEN
  DBMS_OUTPUT.PUT('HUBO UN ERROR EN LA DELETE PRODUCTO');
  END;

  /*CURSOR PARA EL SELECT*/  
END;

BEGIN 
    mantenimiento_producto.pk_insert_producto('producto prueba2','imgprueba2.jpg','description2',66.999,12,2,1);
END;

---------------------------------------------------------------------------------------------------------------------



-----------------------------------CREACION DE TRIGGERS PRODUCTO UPDATE PRECIO---------------------------------------
CREATE TABLE CONTROL_PRODUCTO_PRECIO(
  usuario varchar2(30),
  fecha date,
  codigo int ,
  precioInicial number(6,2),
  precioActual number(6,2),
  estado varchar2(30)
);

 
CREATE OR REPLACE TRIGGER TR_CONTROL_PRODUCTO_PRECIO
BEFORE UPDATE OF Precio
ON producto
FOR EACH ROW
BEGIN
     INSERT INTO CONTROL_PRODUCTO_PRECIO (usuario,fecha,codigo,precioInicial,precioActual,estado)
     VALUES(USER,SYSDATE,:NEW.idproducto,:OLD.precio,:NEW.precio,'PRECIO ACTUALIZADO');

END TR_CONTROL_PRODUCTO_PRECIO;

-----EJECUCION DE LA TABLA CONTROL_PRODUCTO_UPDATE
     SELECT * FROM CONTROL_PRODUCTO_PRECIO;
---------------------------------------------------------------------------------------------------------------------




-----------------------------------CREACION DE TRIGGERS PRODUCTO UPDATE PRECIO---------------------------------------
CREATE TABLE CONTROL_PRODUCTO_STOCK(
  usuario varchar2(30),
  fecha date,
  codigo int ,
  stockInicial int,
  stockActual int,
  estado varchar2(30)
);

 
 
CREATE OR REPLACE TRIGGER TR_CONTROL_PRODUCTO_STOCK
BEFORE UPDATE OF Stock
ON producto
FOR EACH ROW
BEGIN
     INSERT INTO CONTROL_PRODUCTO_STOCK (usuario,fecha,codigo,stockInicial,stockActual,estado)
     VALUES(USER,SYSDATE,:NEW.idproducto,:OLD.Stock,:NEW.Stock,'STOCK ACTUALIZADO');

END TR_CONTROL_PRODUCTO_STOCK;

-----EJECUCION DE LA TABLA CONTROL_PRODUCTO_UPDATE
     SELECT * FROM CONTROL_PRODUCTO_STOCK;
---------------------------------------------------------------------------------------------------------------------


-----------------------------------CREACION DE TRIGGERS ADMIN UPDATE USUARIO-----------------------------------------
CREATE TABLE CONTROL_ADMIN(
  usuario varchar2(30),
  fecha date,
  codigo int ,
  UsuarioInicial varchar2(30),
  UsuarioActual varchar2(30),
  correoInicial varchar2(100),
  correoActual varchar2(100),
  idrol int ,
  estado varchar2(30)
);


CREATE OR REPLACE TRIGGER TR_CONTROL_ADMIN
BEFORE UPDATE OF nombreAdmin , correo
ON administrador
FOR EACH ROW
BEGIN
     INSERT INTO CONTROL_ADMIN (usuario,fecha,codigo,UsuarioInicial,UsuarioActual,correoInicial,correoActual,idrol,estado)
     VALUES(USER,SYSDATE,:NEW.idAdmin,:OLD.nombreAdmin,:NEW.nombreAdmin,:OLD.correo,:NEW.correo,:NEW.idrol,'USUARIO ACTUALIZADO');

END TR_CONTROL_ADMIN;

SELECT * FROM CONTROL_ADMIN;
--------------------------------------------------------------------------------------------------------------------



------------------------------------CREACION DE TRIGGERS DELETE PRODUCTO--------------------------------------------
CREATE TABLE CONTROL_PRODUCTO_BAJA(
  usuario varchar2(30),
  fecha date,
  codigo int,
  Nombre varchar2(255),
  imagen varchar2(50),
  Descripcion varchar2(255),
  Precio number(6,2),
  Stock int,
  idcategoria int,
  idestado int,
  estado varchar2(30)
);

CREATE OR REPLACE TRIGGER TR_CONTROL_PRODUCTO_BAJA
BEFORE DELETE 
ON producto
FOR EACH ROW
BEGIN
     INSERT INTO CONTROL_PRODUCTO_BAJA(usuario,fecha,codigo,Nombre,imagen,Descripcion,Precio,Stock,idcategoria,idestado,estado)
     VALUES(USER,SYSDATE,:OLD.idProducto,:OLD.Nombres,:OLD.imagen,:OLD.Descripcion,:OLD.Precio,:OLD.Stock,:OLD.idcategoria,:OLD.idestado,'PRODUCTO DE BAJA');

END TR_CONTROL_PRODUCTO_BAJA;

SELECT * FROM CONTROL_PRODUCTO_BAJA;
---------------------------------------------------------------------------------------------------------------------


-----------------------------------------ERRORES POSIBLES DE LOS DISPARADORES----------------------------------------
SHOW ERRORS TRIGGERS TR_CONTROL_ADMIN;
DROP TABLE CONTROL_ADMIN_USUARIO;
```

