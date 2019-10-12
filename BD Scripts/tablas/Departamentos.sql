Create Table Departamentos
(
  Id_Departamento Char(1 Char) Not Null,
  Departamento    Varchar2(35 Char) Not Null
)
;
Alter Table Departamentos
  Add Constraint Pk_Departamento Primary Key (Id_Departamento);
