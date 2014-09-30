CREATE TABLE EMPLOYEE (
	empId INT NOT NULL,
	empName VARCHAR(128) NOT NULL,
	dateOfBirth DATE NOT NULL,
	designation VARCHAR(128),
	manager VARCHAR(128),
	dateOfJoin DATE NOT NULL,
	department VARCHAR(128),
	salary DOUBLE NOT NULL,
	PRIMARY KEY(empId)
);
commit;