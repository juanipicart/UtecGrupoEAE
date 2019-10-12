Create Table Usuarios_Tipos_Contactos
(
  Id_Tipo     Number Not Null,
  Descripcion Varchar2(20 Char) Not Null
)
;
Alter Table Usuarios_Tipos_Contactos
  Add Constraint Pk_Usu_Tipo_Contacto Primary Key (Id_Tipo);