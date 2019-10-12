Create Table Roles_Usuarios
(
  Id_Rol          Number Not Null,
  Descripcion_Rol Varchar2(20 Char) Not Null,
  Id_Estado       Number Not Null,
  Fecha_Desde     Date Not Null
)
;
Alter Table Roles_Usuarios
  Add Constraint Pk_Rol Primary Key (Id_Rol);
Alter Table Roles_Usuarios
  Add Constraint Fk_Estado Foreign Key (Id_Estado)
  References Usuarios_Desc_Estados (Id_Estado);
