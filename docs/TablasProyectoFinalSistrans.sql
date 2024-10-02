CREATE TABLE Ciudades (
    codigo NUMBER PRIMARY KEY,
    nombre VARCHAR2(100)NOT NULL
);
CREATE TABLE Sucursales (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tamanioM2 NUMBER NOT NULL,
    direccion VARCHAR2(100) NOT NULL,
    telefono NUMBER NOT NULL,
    id_ciudad NUMBER NOT NULL,
    CONSTRAINT id_ciudad FOREIGN KEY (id_ciudad) REFERENCES Ciudades(codigo)
    
);
CREATE TABLE Clientes (
    cedula NUMBER PRIMARY KEY,
    nombre VARCHAR2(100)
);
CREATE TABLE BODEGAS (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    tamanioM2 NUMBER NOT NULL,
    id_sucursal NUMBER NOT NULL,
    CONSTRAINT id_sucursal FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id)
);
CREATE TABLE Ventas (
    id NUMBER PRIMARY KEY,
    fecha DATE NOT NULL,
    id_sucursal NUMBER NOT NULL,
    id_cliente NUMBER NOT NULL,
    CONSTRAINT FKid_sucursal FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id),
    CONSTRAINT FKid_cliente FOREIGN KEY (id_cliente) REFERENCES Clientes(cedula)
);
CREATE TABLE Proveedores (
    nit NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    direccion VARCHAR2(100) NOT NULL,
    nombreContacto VARCHAR2(100)NOT NULL,
    telefonoContacto NUMBER NOT NULL
);
CREATE TABLE OrdenCompras (
    id NUMBER PRIMARY KEY,
    fechaCreacion Date NOT NULL,
    estado VARCHAR2(100) NOT NULL,
    fechaEntrega Date NOT NULL,
    id_sucursal NUMBER NOT NULL,
    nit_proveedor NUMBER NOT NULL,
    CONSTRAINT FK_sucursal FOREIGN KEY (id_sucursal) REFERENCES Sucursales(id),
    CONSTRAINT FK_proveedor FOREIGN KEY (nit_proveedor) REFERENCES Proveedores(nit)
);
CREATE TABLE RecepcionProductos (
    id NUMBER PRIMARY KEY,
    fechaRecepcion Date NOT NULL,
    id_bodega NUMBER NOT NULL,
    id_ordenCompra NUMBER NOT NULL,
    CONSTRAINT id_bodega FOREIGN KEY (id_bodega) REFERENCES Bodegas(id),
    CONSTRAINT id_ordenCompra FOREIGN KEY (id_ordenCompra) REFERENCES OrdenCompras(id)
);
CREATE TABLE EspecificacionesEmpacado (
    id NUMBER PRIMARY KEY,
    volumen NUMBER NOT NULL,
    pesoGr NUMBER NOT NULL
);
CREATE TABLE Categorias (
    codigo NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    descripcion VARCHAR2(2000) NOT NULL,
    caracteristicasAlmacenamiento VARCHAR2(2000) NOT NULL
);
CREATE TABLE Productos (
    codBarras NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    precioUnitarioVenta NUMBER NOT NULL,
    presentacion VARCHAR2(100) NOT NULL,
    cantidadPresentacio NUMBER NOT NULL,
    unidadMedia NUMBER NOT NULL,
    fechaExpiracion Date NOT NULL,
    id_expecificacionesEmpacado NUMBER NOT NULL,
    id_categoria NUMBER NOT NULL,
    CONSTRAINT id_expecificacionesEmpacado FOREIGN KEY (id_expecificacionesEmpacado) REFERENCES EspecificacionesEmpacado(id),
    CONSTRAINT id_categoria FOREIGN KEY (id_categoria) REFERENCES Categorias(codigo)
);
CREATE TABLE ProductosPerecedero (
    codBarras NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL,
    precioUnitarioVenta NUMBER NOT NULL,
    presentacion VARCHAR2(100) NOT NULL,
    cantidadPresentacio NUMBER NOT NULL,
    unidadMedia NUMBER NOT NULL,
    fechaExpiracion Date NOT NULL,
    id_expecificacionesEmpacado NUMBER NOT NULL,
    id_categoria NUMBER NOT NULL,
    CONSTRAINT id_expecificacionesEmpacadoPerecedero FOREIGN KEY (id_expecificacionesEmpacado) REFERENCES EspecificacionesEmpacado(id),
    CONSTRAINT id_categoriaPerecedero FOREIGN KEY (id_categoria) REFERENCES Categorias(codigo),
    fechadeVencimiento Date NOT NULL
);
CREATE TABLE InfoExtraVentas (
     id_venta NUMBER,
     id_producto NUMBER,
     cantidad NUMBER NOT NULL,
     precioUnitarioVenta NUMBER NOT NULL,
     CONSTRAINT pk_infoVenta PRIMARY KEY (id_venta, id_producto)
);
CREATE TABLE InfoExtraOrdenes (
    id_ordenCompra NUMBER,
    id_producto NUMBER,
    cantidad NUMBER NOT NULL,
    costoUnitarioCompra NUMBER NOT NULL,
    CONSTRAINT pk_infoOrden PRIMARY KEY (id_ordenCompra, id_producto)
);
CREATE TABLE InfoExtraProveedores (
    id_producto NUMBER,
    id_proveedor NUMBER,
    cantidadExistencias NUMBER,
    CONSTRAINT pk_infoProveedor PRIMARY KEY (id_proveedor, id_producto)
);
CREATE TABLE InfoExtraBodegas (
    id_bodega NUMBER ,
    id_producto NUMBER,
    totalExistencias NUMBER,
    costoPromedio NUMBER NOT NULL,
    capacidadAlmacenamiento NUMBER NOT NULL,
    nivelMinimoReorden NUMBER NOT NULL,
    CONSTRAINT pk_infoBodega PRIMARY KEY (id_bodega, id_producto)
);
CREATE TABLE DetalleCostosBodegas (
    id NUMBER PRIMARY KEY,
    costoUnitarioBodega NUMBER NOT NULL,
    cantidadExistencias NUMBER NOT NULL,
    id_infoExtra NUMBER,
    id_bodega NUMBER,
    id_producto NUMBER,
    CONSTRAINT fk_infoExtra FOREIGN KEY (id_bodega, id_producto)
        REFERENCES InfoExtraBodegas(id_bodega, id_producto),
    CONSTRAINT fk_bodega FOREIGN KEY (id_bodega)
        REFERENCES Bodegas(id),
    CONSTRAINT fk_producto FOREIGN KEY ( id_producto)
        REFERENCES Productos(codBarras)
);
create sequence idBodegas start with 1 increment by 1;
create sequence idSucursales start with 1 increment by 1;
create sequence codigo start with 1 increment by 1;
create sequence id_especificaciones start with 1 increment by 1;
create sequence codBarras start with 1000 increment by 1;
commit;

