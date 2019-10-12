Create Table Observaciones_Desc_Estados
(
  Id_Estado   Number Not Null,
  Descripcion Varchar2(30 Char) Not Null
)
;
Alter Table Observaciones_Desc_Estados
  Add Constraint Pk_Obs_Des_Estados Primary Key (Id_Estado);