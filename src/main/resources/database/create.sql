DROP SEQUENCE if exists employee_sequence;

CREATE SEQUENCE if not exists employee_sequence
    increment by 1
    start with 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1;

CREATE TABLE IF NOT EXISTS employee
(
    id                 int default nextval('employee_sequence') primary key,
    fio                varchar(255)        not null,
    birthdate          date                not null,
    dateofstartworking date                not null,
    login              varchar(255) unique not null,
    password           varchar(255)        not null,
    personalnumber     int          unique not null,
    post               varchar(255)
);

DROP SEQUENCE if exists hibernate_sequence;

CREATE SEQUENCE if not exists hibernate_sequence
    increment by 1
    start with 1
    minvalue 1
    maxvalue 9223372036854775807
    cache 1;

CREATE TABLE IF NOT EXISTS vacation
(
    id                int default nextval('hibernate_sequence') primary key,
    vacationenddate   date,
    vacationstartdate date,
    employee_id       int not null,
    foreign key (employee_id) references employee (id)
);
