CREATE OR REPLACE TRIGGER USUARIOS_TIPOS_CONTACTOS_TRG
BEFORE INSERT ON USUARIOS_TIPOS_CONTACTOS
FOR EACH ROW
BEGIN
    SELECT ID_TIPO_CONTACTO_SEQ.nextval
    INTO :new.ID_TIPO
    FROM dual;

END;
/

