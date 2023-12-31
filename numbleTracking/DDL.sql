CREATE TABLE viewcount (
    id           NUMBER NOT NULL,
    url          VARCHAR2(4000 BYTE) NOT NULL,
    daily_hit    NUMBER DEFAULT 0 NOT NULL,
    total_hit    NUMBER DEFAULT 0 NOT NULL,
    average_hit  NUMBER DEFAULT 0 NOT NULL
);

CREATE UNIQUE INDEX pk_viewcounts ON
    viewcount (
        id
    ASC );

ALTER TABLE viewcount
    ADD CONSTRAINT pk_viewcount PRIMARY KEY ( id )
        USING INDEX pk_viewcounts;

CREATE TABLE dailyhit (
    id                     NUMBER NOT NULL,
    viewcount_id           NUMBER NOT NULL,
    daily_hit              NUMBER DEFAULT 0 NOT NULL,
    hit_date               DATE NOT NULL
);

CREATE UNIQUE INDEX pk_dailyhits ON
    dailyhit (
        id
    ASC );

ALTER TABLE dailyhit
    ADD CONSTRAINT pk_dailyhit PRIMARY KEY ( id )
        USING INDEX pk_dailyhits;

ALTER TABLE dailyhit ADD CONSTRAINT fk_viewcount_to_dailyhit FOREIGN KEY (
	viewcount_id
)
REFERENCES viewcount (
	id
);

create SEQUENCE viewcount_sequence;
create SEQUENCE dailyhit_sequence;

BEGIN
  DBMS_SCHEDULER.create_job (
    job_name        => 'RESET_DAILY_HIT_JOB',
    job_type        => 'PLSQL_BLOCK',
    job_action      => 'BEGIN
                          UPDATE viewcount
                          SET daily_hit = 0;
                        END;',
    start_date      => SYSTIMESTAMP,
    repeat_interval => 'FREQ=DAILY; BYHOUR=0; BYMINUTE=0; BYSECOND=0',
    enabled         => TRUE
  );
END;
/