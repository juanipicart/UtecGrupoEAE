Create Table Modulos
(
  Id_Modulo   Number Not Null,
  Descripcion Varchar2(30 Char) Not Null
)
;
Alter Table Modulos
  Add Constraint Pk_Modulo Primary Key (Id_Modulo);