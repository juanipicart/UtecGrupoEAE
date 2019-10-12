CREATE OR REPLACE TRIGGER observaciones_desc_nivel_trg
BEFORE INSERT ON observaciones_desc_nivel
FOR EACH ROW
BEGIN
    SELECT ID_NIVEL_seq.nextval
    INTO :new.ID_NIVEL
    FROM dual;

END;
/

