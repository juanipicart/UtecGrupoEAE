Create Table Observaciones
(
  Id_Observacion  Number Not Null,
  Id_Usuario      Number Not Null,
  Descripcion     Varchar2(100 Char) Not Null,
  Geolocalizacion Varchar2(150 Char) Not Null,
  Fecha_Hora      Date Not Null,
  Id_Ubicacion    Number Not Null

)
;
Alter Table Observaciones
  Add Constraint Pk_Observacion Primary Key (Id_Observacion);
Alter Table Observaciones
  Add Constraint Fk_Obs_Ubicacion Foreign Key (Id_Ubicacion)
  References Ubicaciones (Id_Ubicacion);
Alter Table Observaciones
  Add Constraint Fk_Obs_Usuarios Foreign Key (Id_Usuario)
  References Usuarios (Id_User);
