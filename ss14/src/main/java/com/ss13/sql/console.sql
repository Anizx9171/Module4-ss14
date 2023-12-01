CREATE TABLE student(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    sex BIT(1) NOT NULL DEFAULT 1
);

DELIMITER //
CREATE PROCEDURE ADD_STUDENT(IN s_name VARCHAR(255),
                             s_address VARCHAR(255),
                             s_birthdate DATE,
                             s_sex BIT(1))
BEGIN
    INSERT INTO student (name,address,birthdate,sex)
    VALUES (s_name, s_address, s_birthdate, s_sex);
END;
//

DELIMITER //
CREATE PROCEDURE UPDATE_STUDENT(s_id int,
                             s_name VARCHAR(255),
                             s_address VARCHAR(255),
                             s_birthdate DATE,
                             s_sex BIT(1))
BEGIN
    UPDATE student
    SET name = s_name,
        address = s_address,
        birthdate = s_birthdate,
        sex = s_sex
    WHERE id = s_id;
END;
//

DELIMITER //
CREATE PROCEDURE DELETE_STUDENT(s_id int)
BEGIN
    DELETE FROM student WHERE id = s_id;
END;
//

DELIMITER //
create
    procedure PAGI_STUDENT(IN _limit int, IN no_page int, OUT total int)
BEGIN
    declare _offset int;
    SET _offset = (no_page - 1) * _limit;
    SET  total = CEIL((SELECT count(*) FROM student) / _limit);
    SELECT * FROM student LIMIT _limit OFFSET _offset;
END;
//

DELIMITER //
CREATE PROCEDURE FIND_ALL_STUDENT()
BEGIN
    SELECT * FROM student;
END;
//

DELIMITER //
CREATE PROCEDURE FIND_BY_ID_STUDENT(IN s_id int)
BEGIN
    SELECT * FROM student where id = s_id;
END;
//