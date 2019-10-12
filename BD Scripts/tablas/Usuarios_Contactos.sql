Create Table Usuarios_Contactos
(
  Id_Usuario Number Not Null,
  Id_Tipo    Number Not Null,
  Contacto   Varchar2(30 Char) Not Null
)
;
Alter Table Usuarios_Contactos
  Add Constraint Fk_Usu_Con_Contacto Foreign Key (Id_Tipo)
  References Usuarios_Tipos_Contactos (Id_Tipo);
Alter Table Usuarios_Contactos
  Add Constraint Fk_Usu_Con_Usuario Foreign Key (Id_Usuario)
  References Usuarios (Id_User);
