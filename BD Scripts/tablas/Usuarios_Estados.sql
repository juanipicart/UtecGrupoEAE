Create Table Usuarios_Estados
(
  Id_Usuario  Number Not Null,
  Id_Estado   Number Not Null,
  Fecha_Desde Date
)
;
Alter Table Usuarios_Estados
  Add Constraint Fk_Usu_Est_Tipo_Estado Foreign Key (Id_Estado)
  References Usuarios_Desc_Estados (Id_Estado);
Alter Table Usuarios_Estados
  Add Constraint Fk_Usu_Est_Usu Foreign Key (Id_Usuario)
  References Usuarios (Id_User);