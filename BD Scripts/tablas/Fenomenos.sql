Create Table Fenomenos
(
  Id_Fenomeno         Number Not Null,
  Nombre              Varchar2(20 Char) Not Null,
  Descripcion         Varchar2(50 Char) Not Null,
  Contacto_Emergencia Varchar2(20 Char)
)
;
Alter Table Fenomenos
  Add Constraint Pk_Fenomeno Primary Key (Id_Fenomeno);
Alter Table Fenomenos
  Add Constraint Uk_Fenomeno Unique (Nombre);