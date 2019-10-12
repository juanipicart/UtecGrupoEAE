Create Table Usuarios_Tipos_Doc
(
  Id_Tipo_Doc Number Not Null,
  Tipo        Varchar2(20 Char) Not Null
)
;
Alter Table Usuarios_Tipos_Doc
  Add Constraint Pk_Usu_Tipo_Doc Primary Key (Id_Tipo_Doc);
