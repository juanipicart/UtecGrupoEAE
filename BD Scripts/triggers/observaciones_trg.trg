CREATE OR REPLACE TRIGGER observaciones_trg
BEFORE INSERT ON observaciones
FOR EACH ROW
BEGIN
    SELECT ID_OBSERVACION_seq.nextval
    INTO :new.ID_OBSERVACION
    FROM dual;	

END;
/

