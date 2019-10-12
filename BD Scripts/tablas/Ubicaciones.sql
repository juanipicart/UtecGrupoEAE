Create Table Ubicaciones
(
  Id_Ubicacion    Number Not Null,
  Id_Localidad    Number Not Null,
  Id_Departamento Char(1 Char) Not Null,
  Id_Zona         Number Not Null
)
;
Alter Table Ubicaciones
  Add Constraint Pk_Ubicacion Primary Key (Id_Ubicacion);
Alter Table Ubicaciones
  Add Constraint Fk_Ubi_Dep Foreign Key (Id_Departamento)
  References Departamentos (Id_Departamento);
Alter Table Ubicaciones
  Add Constraint Fk_Ubi_Loc Foreign Key (Id_Localidad)
  References Localidades (Id_Localidad);
Alter Table Ubicaciones
  Add Constraint Fk_Ubi_Zona Foreign Key (Id_Zona)
  References Zonas (Id_Zona);