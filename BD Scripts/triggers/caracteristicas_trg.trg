CREATE OR REPLACE TRIGGER caracteristicas_trg
BEFORE INSERT ON caracteristicas
FOR EACH ROW
BEGIN
    SELECT id_caract_caract_seq.nextval
    INTO :new.ID_CARACTERISTICA
    FROM dual;
END;
/

