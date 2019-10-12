Create Table Caracteristicas
(
  Id_Caracteristica Number Not Null,
  Nombre            Varchar2(20 Char) Not Null,
  Etiqueta          Varchar2(20 Char) Not Null,
  Tipo              Varchar2(20 Char) Not Null,
  Descripcion       Varchar2(50 Char)
)
;
Alter Table Caracteristicas
  Add Constraint Fk_Caracteristica Primary Key (Id_Caracteristica);
Alter Table Caracteristicas
  Add Constraint Uk_Caracteristica Unique (Nombre);