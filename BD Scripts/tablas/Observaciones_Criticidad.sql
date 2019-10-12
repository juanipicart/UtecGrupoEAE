Create Table Observaciones_Criticidad
(
  Id_Observacion Number Not Null,
  Id_Nivel       Number Not Null,
  Fecha_Desde    Date Not Null
)
;
Alter Table Observaciones_Criticidad
  Add Constraint Fk_Obs_Cri_Nivel Foreign Key (Id_Nivel)
  References Observaciones_Desc_Nivel (Id_Nivel);
Alter Table Observaciones_Criticidad
  Add Constraint Fk_Obs_Cri_Obs Foreign Key (Id_Observacion)
  References Observaciones (Id_Observacion);
