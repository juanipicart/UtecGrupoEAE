Create Table Localidades
(
  Id_Localidad Number Not Null,
  Localidad    Varchar2(40 Char) Not Null
)
;
Alter Table Localidades
  Add Constraint Pk_Localidad Primary Key (Id_Localidad);