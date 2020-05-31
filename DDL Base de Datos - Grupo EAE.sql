--------------------------------------------------------
--  File created - Saturday-May-30-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence ID_CARACT_CARACT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_CARACT_CARACT_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_DEPARTAMENTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_DEPARTAMENTO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_ESTADO_OBS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_ESTADO_OBS_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_ESTADO_USUARIO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_ESTADO_USUARIO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_FENOMENO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_FENOMENO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_LOCALIDAD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_LOCALIDAD_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_MODULO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_MODULO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_NIVEL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_NIVEL_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_OBSERVACION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_OBSERVACION_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_ROL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_ROL_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_TIPO_CONTACTO_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_TIPO_CONTACTO_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_TIPO_DOC_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_TIPO_DOC_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_UBICACION_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_UBICACION_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_USER_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Sequence ID_ZONA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ID_ZONA_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
--------------------------------------------------------
--  DDL for Table CARACTERISTICAS
--------------------------------------------------------

  CREATE TABLE "CARACTERISTICAS" ("ID_CARACTERISTICA" NUMBER, "NOMBRE" VARCHAR2(20 CHAR), "ETIQUETA" VARCHAR2(20 CHAR), "TIPO" VARCHAR2(20 CHAR), "DESCRIPCION" VARCHAR2(50 CHAR))
--------------------------------------------------------
--  DDL for Table DEPARTAMENTOS
--------------------------------------------------------

  CREATE TABLE "DEPARTAMENTOS" ("ID_DEPARTAMENTO" NUMBER, "DEPARTAMENTO" VARCHAR2(35 CHAR))
--------------------------------------------------------
--  DDL for Table FENOMENOS
--------------------------------------------------------

  CREATE TABLE "FENOMENOS" ("ID_FENOMENO" NUMBER, "NOMBRE" VARCHAR2(20 CHAR), "DESCRIPCION" VARCHAR2(50 CHAR), "CONTACTO_EMERGENCIA" VARCHAR2(20 CHAR), "CODIGO" VARCHAR2(5 CHAR))
--------------------------------------------------------
--  DDL for Table FENOMENOS_CARACTERISTICAS
--------------------------------------------------------

  CREATE TABLE "FENOMENOS_CARACTERISTICAS" ("ID_FENOMENO" NUMBER, "ID_CARACTERISTICA" NUMBER, "VALOR" VARCHAR2(10))
--------------------------------------------------------
--  DDL for Table LOCALIDADES
--------------------------------------------------------

  CREATE TABLE "LOCALIDADES" ("ID_LOCALIDAD" NUMBER, "LOCALIDAD" VARCHAR2(40 CHAR), "ID_DEPTO" VARCHAR2(2))
--------------------------------------------------------
--  DDL for Table MODULOS
--------------------------------------------------------

  CREATE TABLE "MODULOS" ("ID_MODULO" NUMBER, "DESCRIPCION" VARCHAR2(30 CHAR))
--------------------------------------------------------
--  DDL for Table OBSERVACIONES
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES" ("ID_OBSERVACION" NUMBER, "ID_USUARIO" NUMBER, "DESCRIPCION" VARCHAR2(100 CHAR), "GEOLOCALIZACION" VARCHAR2(150 CHAR), "FECHA_HORA" DATE, "ID_FENOMENO" NUMBER)
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_CRITICIDAD
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_CRITICIDAD" ("ID_OBSERVACION" NUMBER, "ID_NIVEL" NUMBER, "FECHA_DESDE" DATE)
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_DESC_ESTADOS
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_DESC_ESTADOS" ("ID_ESTADO" NUMBER, "DESCRIPCION" VARCHAR2(30 CHAR))
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_DESC_NIVEL
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_DESC_NIVEL" ("ID_NIVEL" NUMBER, "DESCRIPCION_CORTA" VARCHAR2(20 CHAR), "DESCRIPCION" VARCHAR2(50 CHAR))
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_ESTADOS
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_ESTADOS" ("ID_OBSERVACION" NUMBER, "ID_ESTADO" NUMBER, "FECHA_DESDE" DATE)
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_FENOMENOS
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_FENOMENOS" ("ID_OBSERVACION" NUMBER, "ID_FENOMENO" NUMBER)
--------------------------------------------------------
--  DDL for Table OBSERVACIONES_IMAGENES
--------------------------------------------------------

  CREATE TABLE "OBSERVACIONES_IMAGENES" ("ID_OBSERVACION" NUMBER, "ARCHIVO" VARCHAR2(250 CHAR), "IMAGEN" BLOB)
--------------------------------------------------------
--  DDL for Table PALABRAS_PROHIBIDAS
--------------------------------------------------------

  CREATE TABLE "PALABRAS_PROHIBIDAS" ("PALABRA" VARCHAR2(20 CHAR), "DETALLE" VARCHAR2(40 CHAR))
--------------------------------------------------------
--  DDL for Table ROLES_PERMISOS
--------------------------------------------------------

  CREATE TABLE "ROLES_PERMISOS" ("ID_ROL" NUMBER, "ID_MODULO" NUMBER, "PERMISO" CHAR(1 CHAR))
--------------------------------------------------------
--  DDL for Table ROLES_USUARIOS
--------------------------------------------------------

  CREATE TABLE "ROLES_USUARIOS" ("ID_ROL" NUMBER, "DESCRIPCION_ROL" VARCHAR2(20 CHAR))
--------------------------------------------------------
--  DDL for Table USUARIOS
--------------------------------------------------------

  CREATE TABLE "USUARIOS" ("ID_USER" NUMBER, "USUARIO" VARCHAR2(15 CHAR), "NOMBRE" VARCHAR2(30 CHAR), "APELLIDO" VARCHAR2(30 CHAR), "DIRECCION" VARCHAR2(60 CHAR), "ROL" NUMBER, "LOCALIDAD" NUMBER, "ZONA" NUMBER, "ESTADO" NUMBER, "DEPARTAMENTO" NUMBER, "MAIL" VARCHAR2(100), "PASSWORD" VARCHAR2(100), "TIPO_DOC" NUMBER, "DOCUMENTO" VARCHAR2(20))
--------------------------------------------------------
--  DDL for Table USUARIOS_ESTADOS
--------------------------------------------------------

  CREATE TABLE "USUARIOS_ESTADOS" ("ID_ESTADO" NUMBER, "DESC_ESTADO" VARCHAR2(30 CHAR))
--------------------------------------------------------
--  DDL for Table USUARIOS_TIPOS_DOC
--------------------------------------------------------

  CREATE TABLE "USUARIOS_TIPOS_DOC" ("ID_TIPO_DOC" NUMBER, "TIPO" VARCHAR2(20 CHAR))
--------------------------------------------------------
--  DDL for Table ZONAS
--------------------------------------------------------

  CREATE TABLE "ZONAS" ("ID_ZONA" NUMBER, "DESCRIPCION" VARCHAR2(20 CHAR))
REM INSERTING into CARACTERISTICAS
SET DEFINE OFF;
REM INSERTING into DEPARTAMENTOS
SET DEFINE OFF;
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (21,'ARTIGAS');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (22,'CANELONES');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (23,'CERRO LARGO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (24,'COLONIA');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (25,'DURAZNO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (26,'FLORES');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (27,'FLORIDA');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (28,'LAVALLEJA');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (29,'MALDONADO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (30,'MONTEVIDEO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (31,'PAYSANDÚ');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (32,'RÍO NEGRO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (33,'RIVERA');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (34,'ROCHA');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (35,'SALTO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (36,'SAN JOSÉ');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (37,'SORIANO');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (38,'TACUAREMBÓ');
Insert into DEPARTAMENTOS (ID_DEPARTAMENTO,DEPARTAMENTO) values (39,'TREINTA Y TRES');
REM INSERTING into FENOMENOS
SET DEFINE OFF;
Insert into FENOMENOS (ID_FENOMENO,NOMBRE,DESCRIPCION,CONTACTO_EMERGENCIA,CODIGO) values (5,'AA','DESCD','1223333','1234');
Insert into FENOMENOS (ID_FENOMENO,NOMBRE,DESCRIPCION,CONTACTO_EMERGENCIA,CODIGO) values (4,'Q','QQ','Q','Q');
Insert into FENOMENOS (ID_FENOMENO,NOMBRE,DESCRIPCION,CONTACTO_EMERGENCIA,CODIGO) values (8,'HOLA','HOLA','HOLA','HOLA');
Insert into FENOMENOS (ID_FENOMENO,NOMBRE,DESCRIPCION,CONTACTO_EMERGENCIA,CODIGO) values (7,'LLUVIAS TORRENCIALES','LLUVIAS DE MAS DE 30MM','312','TEST');
REM INSERTING into FENOMENOS_CARACTERISTICAS
SET DEFINE OFF;
REM INSERTING into LOCALIDADES
SET DEFINE OFF;
Insert into LOCALIDADES (ID_LOCALIDAD,LOCALIDAD,ID_DEPTO) values (1,'ARTIGAS','1');
Insert into LOCALIDADES (ID_LOCALIDAD,LOCALIDAD,ID_DEPTO) values (2,'BELLA UNIÓN','1');
Insert into LOCALIDADES (ID_LOCALIDAD,LOCALIDAD,ID_DEPTO) values (3,'BALTASAR BRUM','1');
Insert into LOCALIDADES (ID_LOCALIDAD,LOCALIDAD,ID_DEPTO) values (4,'TOMÁS GOMENSORO','1');
REM INSERTING into MODULOS
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_CRITICIDAD
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_DESC_ESTADOS
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_DESC_NIVEL
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_ESTADOS
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_FENOMENOS
SET DEFINE OFF;
REM INSERTING into OBSERVACIONES_IMAGENES
SET DEFINE OFF;
REM INSERTING into PALABRAS_PROHIBIDAS
SET DEFINE OFF;
REM INSERTING into ROLES_PERMISOS
SET DEFINE OFF;
REM INSERTING into ROLES_USUARIOS
SET DEFINE OFF;
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (1,'ADMINISTRADOR');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (2,'ADMINISTRADOR');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (3,'CIUDADANO');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (4,'VALIDADOR');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (5,'ONG');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (6,'ORGANISMO PRIVADO');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (7,'CIENTÍFICO');
Insert into ROLES_USUARIOS (ID_ROL,DESCRIPCION_ROL) values (8,'ESTUDIANTE');
REM INSERTING into USUARIOS
SET DEFINE OFF;
Insert into USUARIOS (ID_USER,USUARIO,NOMBRE,APELLIDO,DIRECCION,ROL,LOCALIDAD,ZONA,ESTADO,DEPARTAMENTO,MAIL,PASSWORD,TIPO_DOC,DOCUMENTO) values (4,'TESTUSER','TEST1234','USER1234','AAAAAA',3,1,4,2,21,'AAA@AAA.COM','5678TEST',1,'12345');
Insert into USUARIOS (ID_USER,USUARIO,NOMBRE,APELLIDO,DIRECCION,ROL,LOCALIDAD,ZONA,ESTADO,DEPARTAMENTO,MAIL,PASSWORD,TIPO_DOC,DOCUMENTO) values (2,'A','A','AA','AA',2,1,2,1,21,'A@AA.COM','AA',1,'AA');
Insert into USUARIOS (ID_USER,USUARIO,NOMBRE,APELLIDO,DIRECCION,ROL,LOCALIDAD,ZONA,ESTADO,DEPARTAMENTO,MAIL,PASSWORD,TIPO_DOC,DOCUMENTO) values (3,'ELJUAN','JUANNNNTEST','PICARTTTTTEST','JSJSJJSJSTEST',4,2,3,2,26,'JASJAS@ASDFAS.COM','12344433',3,'123555555TEST');
Insert into USUARIOS (ID_USER,USUARIO,NOMBRE,APELLIDO,DIRECCION,ROL,LOCALIDAD,ZONA,ESTADO,DEPARTAMENTO,MAIL,PASSWORD,TIPO_DOC,DOCUMENTO) values (5,'TEST','TEST1111','TEST1111','TEST1111',4,2,1,2,21,'TEST1111@GGG.COM','TEST1111',1,'TEST1111');
REM INSERTING into USUARIOS_ESTADOS
SET DEFINE OFF;
Insert into USUARIOS_ESTADOS (ID_ESTADO,DESC_ESTADO) values (1,'ACTIVO');
Insert into USUARIOS_ESTADOS (ID_ESTADO,DESC_ESTADO) values (2,'INACTIVO');
Insert into USUARIOS_ESTADOS (ID_ESTADO,DESC_ESTADO) values (3,'BLOQUEADO');
REM INSERTING into USUARIOS_TIPOS_DOC
SET DEFINE OFF;
Insert into USUARIOS_TIPOS_DOC (ID_TIPO_DOC,TIPO) values (1,'CI');
Insert into USUARIOS_TIPOS_DOC (ID_TIPO_DOC,TIPO) values (2,'PASAPORTE');
Insert into USUARIOS_TIPOS_DOC (ID_TIPO_DOC,TIPO) values (3,'CREDENCIAL CÍVICA');
Insert into USUARIOS_TIPOS_DOC (ID_TIPO_DOC,TIPO) values (4,'OTROS');
REM INSERTING into ZONAS
SET DEFINE OFF;
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (1,'NORTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (2,'ESTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (3,'OESTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (4,'SUR');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (5,'NORESTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (6,'NOROESTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (7,'SURESTE');
Insert into ZONAS (ID_ZONA,DESCRIPCION) values (8,'SUROESTE');
--------------------------------------------------------
--  DDL for Index PK_OBS_DES_ESTADOS
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_OBS_DES_ESTADOS" ON "OBSERVACIONES_DESC_ESTADOS" ("ID_ESTADO")
--------------------------------------------------------
--  DDL for Index UK_FENOMENO
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_FENOMENO" ON "FENOMENOS" ("NOMBRE")
--------------------------------------------------------
--  DDL for Index PK_USUARIO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USUARIO" ON "USUARIOS" ("ID_USER")
--------------------------------------------------------
--  DDL for Index PK_OBS_DEC_NIVEL
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_OBS_DEC_NIVEL" ON "OBSERVACIONES_DESC_NIVEL" ("ID_NIVEL")
--------------------------------------------------------
--  DDL for Index PK_DEPARTAMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_DEPARTAMENTO" ON "DEPARTAMENTOS" ("ID_DEPARTAMENTO")
--------------------------------------------------------
--  DDL for Index PK_LOCALIDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_LOCALIDAD" ON "LOCALIDADES" ("ID_LOCALIDAD")
--------------------------------------------------------
--  DDL for Index PK_FENOMENO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_FENOMENO" ON "FENOMENOS" ("ID_FENOMENO")
--------------------------------------------------------
--  DDL for Index PK_OBSERVACION
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_OBSERVACION" ON "OBSERVACIONES" ("ID_OBSERVACION")
--------------------------------------------------------
--  DDL for Index UK_CARACTERISTICA
--------------------------------------------------------

  CREATE UNIQUE INDEX "UK_CARACTERISTICA" ON "CARACTERISTICAS" ("NOMBRE")
--------------------------------------------------------
--  DDL for Index PK_ROL
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ROL" ON "ROLES_USUARIOS" ("ID_ROL")
--------------------------------------------------------
--  DDL for Index PK_ZONA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_ZONA" ON "ZONAS" ("ID_ZONA")
--------------------------------------------------------
--  DDL for Index PK_USU_DES_ESTADO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USU_DES_ESTADO" ON "USUARIOS_ESTADOS" ("ID_ESTADO")
--------------------------------------------------------
--  DDL for Index PK_OBS_IMAGEN
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_OBS_IMAGEN" ON "OBSERVACIONES_IMAGENES" ("ID_OBSERVACION", "ARCHIVO")
--------------------------------------------------------
--  DDL for Index PK_USU_TIPO_DOC
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_USU_TIPO_DOC" ON "USUARIOS_TIPOS_DOC" ("ID_TIPO_DOC")
--------------------------------------------------------
--  DDL for Index FK_CARACTERISTICA
--------------------------------------------------------

  CREATE UNIQUE INDEX "FK_CARACTERISTICA" ON "CARACTERISTICAS" ("ID_CARACTERISTICA")
--------------------------------------------------------
--  DDL for Index PK_MODULO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_MODULO" ON "MODULOS" ("ID_MODULO")
--------------------------------------------------------
--  Constraints for Table CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "CARACTERISTICAS" ADD CONSTRAINT "FK_CARACTERISTICA" PRIMARY KEY ("ID_CARACTERISTICA") ENABLE
 
  ALTER TABLE "CARACTERISTICAS" MODIFY ("ID_CARACTERISTICA" NOT NULL ENABLE)
 
  ALTER TABLE "CARACTERISTICAS" MODIFY ("NOMBRE" NOT NULL ENABLE)
 
  ALTER TABLE "CARACTERISTICAS" MODIFY ("ETIQUETA" NOT NULL ENABLE)
 
  ALTER TABLE "CARACTERISTICAS" MODIFY ("TIPO" NOT NULL ENABLE)
 
  ALTER TABLE "CARACTERISTICAS" ADD CONSTRAINT "UK_CARACTERISTICA" UNIQUE ("NOMBRE") ENABLE
--------------------------------------------------------
--  Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "USUARIOS" ADD CONSTRAINT "PK_USUARIO" PRIMARY KEY ("ID_USER") ENABLE
 
  ALTER TABLE "USUARIOS" MODIFY ("ID_USER" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("USUARIO" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("NOMBRE" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("APELLIDO" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("DIRECCION" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("ROL" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("ESTADO" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("MAIL" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("PASSWORD" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("TIPO_DOC" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS" MODIFY ("DOCUMENTO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MODULOS
--------------------------------------------------------

  ALTER TABLE "MODULOS" ADD CONSTRAINT "PK_MODULO" PRIMARY KEY ("ID_MODULO") ENABLE
 
  ALTER TABLE "MODULOS" MODIFY ("ID_MODULO" NOT NULL ENABLE)
 
  ALTER TABLE "MODULOS" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table LOCALIDADES
--------------------------------------------------------

  ALTER TABLE "LOCALIDADES" ADD CONSTRAINT "PK_LOCALIDAD" PRIMARY KEY ("ID_LOCALIDAD") ENABLE
 
  ALTER TABLE "LOCALIDADES" MODIFY ("ID_LOCALIDAD" NOT NULL ENABLE)
 
  ALTER TABLE "LOCALIDADES" MODIFY ("LOCALIDAD" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table USUARIOS_ESTADOS
--------------------------------------------------------

  ALTER TABLE "USUARIOS_ESTADOS" ADD CONSTRAINT "PK_USU_DES_ESTADO" PRIMARY KEY ("ID_ESTADO") ENABLE
 
  ALTER TABLE "USUARIOS_ESTADOS" MODIFY ("ID_ESTADO" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS_ESTADOS" MODIFY ("DESC_ESTADO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_FENOMENOS
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_FENOMENOS" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_FENOMENOS" MODIFY ("ID_FENOMENO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ROLES_PERMISOS
--------------------------------------------------------

  ALTER TABLE "ROLES_PERMISOS" MODIFY ("ID_ROL" NOT NULL ENABLE)
 
  ALTER TABLE "ROLES_PERMISOS" MODIFY ("ID_MODULO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_DESC_NIVEL
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_DESC_NIVEL" ADD CONSTRAINT "PK_OBS_DEC_NIVEL" PRIMARY KEY ("ID_NIVEL") ENABLE
 
  ALTER TABLE "OBSERVACIONES_DESC_NIVEL" MODIFY ("ID_NIVEL" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_DESC_NIVEL" MODIFY ("DESCRIPCION_CORTA" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_DESC_NIVEL" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table FENOMENOS_CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "FENOMENOS_CARACTERISTICAS" MODIFY ("ID_FENOMENO" NOT NULL ENABLE)
 
  ALTER TABLE "FENOMENOS_CARACTERISTICAS" MODIFY ("ID_CARACTERISTICA" NOT NULL ENABLE)
 
  ALTER TABLE "FENOMENOS_CARACTERISTICAS" MODIFY ("VALOR" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_IMAGENES
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_IMAGENES" ADD CONSTRAINT "PK_OBS_IMAGEN" PRIMARY KEY ("ID_OBSERVACION", "ARCHIVO") ENABLE
 
  ALTER TABLE "OBSERVACIONES_IMAGENES" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_IMAGENES" MODIFY ("ARCHIVO" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_IMAGENES" MODIFY ("IMAGEN" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table DEPARTAMENTOS
--------------------------------------------------------

  ALTER TABLE "DEPARTAMENTOS" ADD CONSTRAINT "PK_DEPARTAMENTO" PRIMARY KEY ("ID_DEPARTAMENTO") ENABLE
 
  ALTER TABLE "DEPARTAMENTOS" MODIFY ("ID_DEPARTAMENTO" NOT NULL ENABLE)
 
  ALTER TABLE "DEPARTAMENTOS" MODIFY ("DEPARTAMENTO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ROLES_USUARIOS
--------------------------------------------------------

  ALTER TABLE "ROLES_USUARIOS" ADD CONSTRAINT "PK_ROL" PRIMARY KEY ("ID_ROL") ENABLE
 
  ALTER TABLE "ROLES_USUARIOS" MODIFY ("ID_ROL" NOT NULL ENABLE)
 
  ALTER TABLE "ROLES_USUARIOS" MODIFY ("DESCRIPCION_ROL" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ZONAS
--------------------------------------------------------

  ALTER TABLE "ZONAS" ADD CONSTRAINT "PK_ZONA" PRIMARY KEY ("ID_ZONA") ENABLE
 
  ALTER TABLE "ZONAS" MODIFY ("ID_ZONA" NOT NULL ENABLE)
 
  ALTER TABLE "ZONAS" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_DESC_ESTADOS
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_DESC_ESTADOS" ADD CONSTRAINT "PK_OBS_DES_ESTADOS" PRIMARY KEY ("ID_ESTADO") ENABLE
 
  ALTER TABLE "OBSERVACIONES_DESC_ESTADOS" MODIFY ("ID_ESTADO" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_DESC_ESTADOS" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_ESTADOS
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_ESTADOS" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_ESTADOS" MODIFY ("ID_ESTADO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES" ADD CONSTRAINT "PK_OBSERVACION" PRIMARY KEY ("ID_OBSERVACION") ENABLE
 
  ALTER TABLE "OBSERVACIONES" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES" MODIFY ("ID_USUARIO" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES" MODIFY ("GEOLOCALIZACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES" MODIFY ("FECHA_HORA" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PALABRAS_PROHIBIDAS
--------------------------------------------------------

  ALTER TABLE "PALABRAS_PROHIBIDAS" MODIFY ("PALABRA" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table FENOMENOS
--------------------------------------------------------

  ALTER TABLE "FENOMENOS" ADD CONSTRAINT "PK_FENOMENO" PRIMARY KEY ("ID_FENOMENO") ENABLE
 
  ALTER TABLE "FENOMENOS" MODIFY ("ID_FENOMENO" NOT NULL ENABLE)
 
  ALTER TABLE "FENOMENOS" MODIFY ("NOMBRE" NOT NULL ENABLE)
 
  ALTER TABLE "FENOMENOS" MODIFY ("DESCRIPCION" NOT NULL ENABLE)
 
  ALTER TABLE "FENOMENOS" ADD CONSTRAINT "UK_FENOMENO" UNIQUE ("NOMBRE") ENABLE
--------------------------------------------------------
--  Constraints for Table USUARIOS_TIPOS_DOC
--------------------------------------------------------

  ALTER TABLE "USUARIOS_TIPOS_DOC" ADD CONSTRAINT "PK_USU_TIPO_DOC" PRIMARY KEY ("ID_TIPO_DOC") ENABLE
 
  ALTER TABLE "USUARIOS_TIPOS_DOC" MODIFY ("ID_TIPO_DOC" NOT NULL ENABLE)
 
  ALTER TABLE "USUARIOS_TIPOS_DOC" MODIFY ("TIPO" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table OBSERVACIONES_CRITICIDAD
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_CRITICIDAD" MODIFY ("ID_OBSERVACION" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_CRITICIDAD" MODIFY ("ID_NIVEL" NOT NULL ENABLE)
 
  ALTER TABLE "OBSERVACIONES_CRITICIDAD" MODIFY ("FECHA_DESDE" NOT NULL ENABLE)
--------------------------------------------------------
--  Ref Constraints for Table FENOMENOS_CARACTERISTICAS
--------------------------------------------------------

  ALTER TABLE "FENOMENOS_CARACTERISTICAS" ADD CONSTRAINT "FK_FEN_CAR_CAR" FOREIGN KEY ("ID_CARACTERISTICA") REFERENCES "CARACTERISTICAS" ("ID_CARACTERISTICA") ENABLE
 
  ALTER TABLE "FENOMENOS_CARACTERISTICAS" ADD CONSTRAINT "FK_FEN_CAR_FEN" FOREIGN KEY ("ID_FENOMENO") REFERENCES "FENOMENOS" ("ID_FENOMENO") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES" ADD CONSTRAINT "FK_OBS_FENOMENO" FOREIGN KEY ("ID_FENOMENO") REFERENCES "FENOMENOS" ("ID_FENOMENO") ENABLE
 
  ALTER TABLE "OBSERVACIONES" ADD CONSTRAINT "FK_OBS_USUARIOS" FOREIGN KEY ("ID_USUARIO") REFERENCES "USUARIOS" ("ID_USER") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES_CRITICIDAD
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_CRITICIDAD" ADD CONSTRAINT "FK_OBS_CRI_NIVEL" FOREIGN KEY ("ID_NIVEL") REFERENCES "OBSERVACIONES_DESC_NIVEL" ("ID_NIVEL") ENABLE
 
  ALTER TABLE "OBSERVACIONES_CRITICIDAD" ADD CONSTRAINT "FK_OBS_CRI_OBS" FOREIGN KEY ("ID_OBSERVACION") REFERENCES "OBSERVACIONES" ("ID_OBSERVACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES_ESTADOS
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_ESTADOS" ADD CONSTRAINT "FK_OBS_EST_DESC_ESTADO" FOREIGN KEY ("ID_ESTADO") REFERENCES "OBSERVACIONES_DESC_ESTADOS" ("ID_ESTADO") ENABLE
 
  ALTER TABLE "OBSERVACIONES_ESTADOS" ADD CONSTRAINT "FK_OBS_EST_OBSERVACION" FOREIGN KEY ("ID_OBSERVACION") REFERENCES "OBSERVACIONES" ("ID_OBSERVACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES_FENOMENOS
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_FENOMENOS" ADD CONSTRAINT "FK_OBS_FEN_FEN" FOREIGN KEY ("ID_FENOMENO") REFERENCES "FENOMENOS" ("ID_FENOMENO") ENABLE
 
  ALTER TABLE "OBSERVACIONES_FENOMENOS" ADD CONSTRAINT "FK_OBS_FEN_OBS" FOREIGN KEY ("ID_OBSERVACION") REFERENCES "OBSERVACIONES" ("ID_OBSERVACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table OBSERVACIONES_IMAGENES
--------------------------------------------------------

  ALTER TABLE "OBSERVACIONES_IMAGENES" ADD CONSTRAINT "FK_OBS_IMA_OBS" FOREIGN KEY ("ID_OBSERVACION") REFERENCES "OBSERVACIONES" ("ID_OBSERVACION") ENABLE
--------------------------------------------------------
--  Ref Constraints for Table USUARIOS
--------------------------------------------------------

  ALTER TABLE "USUARIOS" ADD CONSTRAINT "FK_USU_DEPTO" FOREIGN KEY ("DEPARTAMENTO") REFERENCES "DEPARTAMENTOS" ("ID_DEPARTAMENTO") ENABLE
 
  ALTER TABLE "USUARIOS" ADD CONSTRAINT "FK_USU_LOCAL" FOREIGN KEY ("LOCALIDAD") REFERENCES "LOCALIDADES" ("ID_LOCALIDAD") ENABLE
 
  ALTER TABLE "USUARIOS" ADD CONSTRAINT "FK_USU_ROL" FOREIGN KEY ("ROL") REFERENCES "ROLES_USUARIOS" ("ID_ROL") ENABLE
 
  ALTER TABLE "USUARIOS" ADD CONSTRAINT "FK_USU_TIPO_DOC" FOREIGN KEY ("TIPO_DOC") REFERENCES "USUARIOS_TIPOS_DOC" ("ID_TIPO_DOC") ENABLE
 
  ALTER TABLE "USUARIOS" ADD CONSTRAINT "FK_USU_ZONA" FOREIGN KEY ("ZONA") REFERENCES "ZONAS" ("ID_ZONA") ENABLE
