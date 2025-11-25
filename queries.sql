-- SQL Queries for Employee Table

-- Query A: Display EName and Salary of employees whose salary is greater than or equal to 2200
SELECT ename, sal
FROM Empl
WHERE sal >= 2200;

-- Query B: Display details of employees who are not getting commission
SELECT *
FROM Empl
WHERE comm IS NULL OR comm = 0;

-- Query C: Display employee name and salary of employees whose salary is NOT in the range of 2500 to 4000
SELECT ename, sal
FROM Empl
WHERE sal NOT BETWEEN 2500 AND 4000;

-- Query D: Display the name, job title, and salary of employees who do not have a manager
SELECT ename, job, sal
FROM Empl
WHERE mgr IS NULL;

-- Query E: Display the name of an employee whose name contains "A" as the third alphabet
SELECT ename
FROM Empl
WHERE SUBSTRING(ename, 3, 1) = 'A';

-- Query F: Display the name of an employee whose name contains "T" as the last alphabet
SELECT ename
FROM Empl
WHERE ename LIKE '%T';

