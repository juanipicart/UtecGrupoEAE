Create Table Palabras_Prohibidas
(
  Palabra Varchar2(20 Char) Not Null,
  Detalle Varchar2(40 Char)
)
;
Alter Table Palabras_Prohibidas
  Add Constraint Pk_Palabras_Prohibidas Primary Key (Palabra);