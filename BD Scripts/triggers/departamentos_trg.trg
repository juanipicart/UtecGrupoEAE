CREATE OR REPLACE TRIGGER DEPARTAMENTOs_trg
BEFORE INSERT ON departamentos
FOR EACH ROW
BEGIN
	  SELECT ID_DEPARTAMENTO_seq.nextval
    INTO :new.ID_DEPARTAMENTO
    FROM dual;

END;
/

