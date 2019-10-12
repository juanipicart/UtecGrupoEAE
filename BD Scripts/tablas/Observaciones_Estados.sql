Create Table Observaciones_Estados
(
  Id_Observacion Number Not Null,
  Id_Estado      Number Not Null,
  Fecha_Desde    Date
)
;
Alter Table Observaciones_Estados
  Add Constraint Fk_Obs_Est_Desc_Estado Foreign Key (Id_Estado)
  References Observaciones_Desc_Estados (Id_Estado);
Alter Table Observaciones_Estados
  Add Constraint Fk_Obs_Est_Observacion Foreign Key (Id_Observacion)
  References Observaciones (Id_Observacion);