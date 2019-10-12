Create Table Observaciones_Fenomenos
(
  Id_Observacion Number Not Null,
  Id_Fenomeno    Number Not Null
)
;
Alter Table Observaciones_Fenomenos
  Add Constraint Fk_Obs_Fen_Fen Foreign Key (Id_Fenomeno)
  References Fenomenos (Id_Fenomeno);
Alter Table Observaciones_Fenomenos
  Add Constraint Fk_Obs_Fen_Obs Foreign Key (Id_Observacion)
  References Observaciones (Id_Observacion);