CREATE OR REPLACE TRIGGER observaciones_desc_estados_trg
BEFORE INSERT ON observaciones_desc_estados
FOR EACH ROW
BEGIN
    SELECT ID_ESTADO_obs_seq.nextval
    INTO :new.ID_ESTADO
    FROM dual;

END;
/

