Create Table Observaciones_Imagenes 
(
  Id_Observacion Number Not Null, 
	Archivo Varchar2(250 Char) Not Null, 
	Imagen Blob Not Null
)
Alter Table Observaciones_Imagenes 
  Add Constraint Pk_Obs_Imagen Primary Key (Id_Observacion, Archivo);
Alter Table Observaciones_Imagenes
  Add Constraint Fk_Obs_Ima_Obs Foreign Key (Id_Observacion)
  References Observaciones (Id_Observacion);   