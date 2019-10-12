Create Table Observaciones_Desc_Nivel
(
  Id_Nivel          Number Not Null,
  Descripcion_Corta Varchar2(20 Char) Not Null,
  Descripcion       Varchar2(50 Char) Not Null
)
;
Alter Table Observaciones_Desc_Nivel
  Add Constraint Pk_Obs_Dec_Nivel Primary Key (Id_Nivel);