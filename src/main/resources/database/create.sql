CREATE SEQUENCE if not exists hibernate_sequence;

CREATE TABLE IF NOT EXISTS employee
(
    id                 int default nextval('hibernate_sequence') primary key,
    fio                varchar(255)        not null,
    birthdate          date                not null,
    dateofstartworking date                not null,
    login              varchar(255) unique not null,
    password           varchar(255)        not null,
    personalnumber     int          unique not null,
    post               varchar(255)
);

CREATE TABLE IF NOT EXISTS vacation
(
    id                int default nextval('hibernate_sequence') primary key,
    vacationenddate   date,
    vacationstartdate date,
    employee_id       int not null,
    foreign key (employee_id) references employee (id)
);
