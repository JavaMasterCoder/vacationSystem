-- Table: public.employee

-- CREATE TABLE public.employee(
--     id int primary     key          not null,
--     fio                char(255)    not null,
--     birthdate          date         not null,
--     dateofstartworking date         not null,
--     login              char(255)    not null,
--     password           char(255)    not null ,
--     personalnumber     int          not null ,
--     post               char(255)    no null
-- )


DROP TABLE public.employee;

CREATE TABLE public.employee
(
    id integer NOT NULL,
    fio character varying(255) COLLATE pg_catalog."default" NOT NULL,
    birthdate date NOT NULL,
    dateofstartworking date NOT NULL,
    login character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    personalnumber integer NOT NULL,
    post character varying(255) COLLATE pg_catalog."default" NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to root;
--
-- DROP TABLE public.vacations;
--
-- CREATE TABLE public.vacations
-- (
--     id integer NOT NULL,
--     vacationenddate date,
--     vacationstartdate date,
--     employee_id integer
-- --     CONSTRAINT vacation_pkey PRIMARY KEY (id),
-- --     CONSTRAINT fk10t3vysjel72fr3n10qb49a3l FOREIGN KEY (employee_id)
-- --         REFERENCES employee (id) MATCH SIMPLE
-- --         ON UPDATE NO ACTION
-- --         ON DELETE NO ACTION
-- )
-- WITH (
--     OIDS = FALSE
-- )
-- TABLESPACE pg_default;
--
-- ALTER TABLE public.vacations
--     OWNER to root;
