Create Table Usuarios_Documentos
(
  Id_Usuario  Number Not Null,
  Id_Tipo_Doc Number Not Null,
  Documento   Varchar2(15 Char) Not Null,
  Fecha_Desde Date Not Null,
  Fecha_Hasta Date
)
;
Alter Table Usuarios_Documentos
  Add Constraint Fk_Usu_Doc_Tipo_Doc Foreign Key (Id_Tipo_Doc)
  References Usuarios_Tipos_Doc (Id_Tipo_Doc);
Alter Table Usuarios_Documentos
  Add Constraint Fk_Usu_Doc_Usu Foreign Key (Id_Usuario)
  References Usuarios (Id_User);
