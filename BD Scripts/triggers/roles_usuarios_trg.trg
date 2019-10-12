CREATE OR REPLACE TRIGGER roles_usuarios_trg
BEFORE INSERT ON roles_usuarios
FOR EACH ROW
BEGIN
    SELECT ID_ROL_seq.nextval
    INTO :new.ID_ROL
    FROM dual;	

END;
/

