Create Table Roles_Permisos
(
  Id_Rol    Number Not Null,
  Id_Modulo Number Not Null,
  Permiso   Char(1 Char)
)
;
Alter Table Roles_Permisos
  Add Constraint Pk_Per_Rol Primary Key (Id_Rol, Id_Modulo);
Alter Table Roles_Permisos
  Add Constraint Fk_Modulo Foreign Key (Id_Modulo)
  References Modulos (Id_Modulo);
Alter Table Roles_Permisos
  Add Constraint Fk_Rol Foreign Key (Id_Rol)
  References Roles_Usuarios (Id_Rol);
Alter Table Roles_Permisos
  Add Constraint Chk_Usu_Perm_Rol
  Check (Permiso In('R','r','W','w'));