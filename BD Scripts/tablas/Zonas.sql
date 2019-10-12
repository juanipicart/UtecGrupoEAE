Create Table Zonas
(
  Id_Zona     Number Not Null,
  Descripcion Varchar2(20 Char) Not Null
)
;
Alter Table Zonas
  Add Constraint Pk_Zona Primary Key (Id_Zona);
