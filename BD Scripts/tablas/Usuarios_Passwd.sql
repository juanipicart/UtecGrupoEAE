Create Table Usuarios_Passwd
(
  Id_User     Number Not Null,
  Passwd      Varchar2(100 Char) Not Null,
  Fecha_Hasta Date
)
;
Alter Table Usuarios_Passwd
  Add Constraint Fk_Usu_Pass_Usu Foreign Key (Id_User)
  References Usuarios (Id_User);