Create Table Usuarios_Desc_Estados
(
  Id_Estado   Number Not Null,
  Desc_Estado Varchar2(30 Char) Not Null
)
;
Alter Table Usuarios_Desc_Estados
  Add Constraint Pk_Usu_Des_Estado Primary Key (Id_Estado);
