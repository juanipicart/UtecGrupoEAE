CREATE OR REPLACE TRIGGER MODULOS_trg
BEFORE INSERT ON modulos
FOR EACH ROW
BEGIN
    SELECT ID_MODULO_seq.nextval
    INTO :new.ID_MODULO
    FROM dual;
END;
/

