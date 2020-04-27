INSERT INTO employee (id, fio, birthdate, dateofstartworking, login, password, personalnumber, post) VALUES
(1, 'Melikhov Grigorii Fedorovich', '1997-10-09', '2020-05-10', 'gregor', 'root', 1, 'Junior Java-developer'),
(2, 'Pupkin Vasiliy Nikolaevich', '1990-01-27', '2010-06-11', 'vasiliy', 'vasya', 2, 'Middle Java-developer'),
(3, 'Pirojkov Andrey Stepanovich', '1987-06-13', '2015-07-15', 'andrue', 'dron',  3, 'Senior Java-developer'),
(4, 'Vasyliev Petr Ivanovich', '1996-12-05', '2019-12-12', 'petr', 'petek',  4, 'Junior Java-developer'),
(5, 'Lermontov Michael Yurevich', '1980-12-17', '2014-03-15', 'techPis', 'techPis', 5, 'Technical writer'),
(6, 'Pushkin Alexandr Sergeevich', '1985-08-25', '2010-05-15', 'boss', 'boss', 6, 'Product owner');

insert into vacation (id, vacationenddate, vacationstartdate, employee_id) VALUES
(1, '2020-06-15', '2020-06-01', 1),
(2, '2020-08-20', '2020-08-13', 1),
(3, '2020-12-27', '2020-12-20', 1),
(4, '2020-01-17', '2020-01-10', 2),
(5, '2020-04-24', '2020-04-17', 2),
(6, '2020-09-30', '2020-09-02', 3),
(7, '2020-08-01', '2020-07-17', 4),
(8, '2020-03-27', '2020-03-20', 4),
(9, '2020-11-20', '2020-11-13', 4),
(10, '2020-06-24', '2020-06-10', 6),
(11, '2020-09-23', '2020-09-09', 6);
