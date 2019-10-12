Create Table Usuarios
(
  Id_User      Number Not Null,
  Usuario      Varchar2(15 Char) Not Null,
  Nombre       Varchar2(30 Char) Not Null,
  Apellido     Varchar2(30 Char) Not Null,
  Direccion    Varchar2(60 Char) Not Null,
  Id_Ubicacion Number Not Null,
  Id_Rol       Number Not Null
)
;
Alter Table Usuarios
  Add Constraint Pk_Usuario Primary Key (Id_User);
Alter Table Usuarios
  Add Constraint Fk_Usu_Rol Foreign Key (Id_Rol)
  References Roles_Usuarios (Id_Rol);
Alter Table Usuarios
  Add Constraint Fk_Usu_Ubicacion Foreign Key (Id_Ubicacion)
  References Ubicaciones (Id_Ubicacion);
