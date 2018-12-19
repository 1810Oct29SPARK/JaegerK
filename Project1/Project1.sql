DROP TABLE EMPLOYEE;
DROP TABLE REIMBURSEMENTS;
DROP TABLE LOGIN;

CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID NUMBER NOT NULL,
    EMPLOYEE_LASTNAME VARCHAR2(40),
    EMPLOYEE_FIRSTNAME VARCHAR2(40),
    EMPLOYEE_POSITION VARCHAR2(20),
    EMPLOYEE_SALARY NUMBER NOT NULL,
    EMPLOYEE_HOURS NUMBER NOT NULL,
    CONSTRAINT EMPLOYEE_ID PRIMARY KEY (EMPLOYEE_ID)
);

INSERT INTO EMPLOYEE VALUES(1,'JAEGER', 'KALEIGH', 'CEO', 20000000, 40);
INSERT INTO EMPLOYEE VALUES(2,'FARLEY', 'JAN', 'MANAGER', 80000, 40);
INSERT INTO EMPLOYEE VALUES(3,'DOBRAVICH', 'NICOLE', 'MANAGER', 60000, 40);
INSERT INTO EMPLOYEE VALUES(4,'LENOVITZ', 'ADIS', 'MANAGER', 60000, 40);
INSERT INTO EMPLOYEE VALUES(5,'NATALE', 'JORDAN', 'SERVER', 14040, 30);
INSERT INTO EMPLOYEE VALUES(6,'HAJACOS', 'LUKE', 'SERVER', 20800, 40);
INSERT INTO EMPLOYEE VALUES(7,'LEE', 'ELEANOR', 'SERVER', 15470, 35);

---- DELETE ENTRIES
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 1;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 2;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 3;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 4;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 5;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 6;
--DELETE FROM EMPLOYEE 
--WHERE EMPLOYEE_ID = 7;

CREATE TABLE REIMBURSEMENTS
(
    EMPLOYEE_ID NUMBER NOT NULL,
    REIMBURSEMENT_ID NUMBER NOT NULL,
    REIMBURSEMENT_DESCRIPTION VARCHAR2(40),
    REIMBURSEMENT_AMOUNT NUMBER NOT NULL,
    REIMBURSEMENT_IMAGE BLOB,
    REIMBURSEMENT_STATUS VARCHAR2(40)
);

CREATE TABLE LOGIN 
(
    EMPLOYEE_ID NUMBER NOT NULL,
    EMPLOYEE_USERNAME VARCHAR2(20),
    EMPLOYEE_PASSWORD VARCHAR2(30)
);
    