Create Table Fenomenos_Caracteristicas
(
  Id_Fenomeno       Number Not Null,
  Id_Caracteristica Number Not Null,
  Valor             Varchar2(10) Not Null
)
;
Alter Table Fenomenos_Caracteristicas
  Add Constraint Fk_Fen_Car_Car Foreign Key (Id_Caracteristica)
  References Caracteristicas (Id_Caracteristica);
Alter Table Fenomenos_Caracteristicas
  Add Constraint Fk_Fen_Car_Fen Foreign Key (Id_Fenomeno)
  References Fenomenos (Id_Fenomeno);