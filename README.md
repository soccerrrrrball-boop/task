# MySQL Employee Database Project

This repository contains SQL queries and JDBC program for employee database management.

## Files Description

1. **create_table.sql** - Contains table creation and data insertion statements for the `Empl` table
2. **queries.sql** - Contains all 6 SQL queries (A-F) as per requirements
3. **JDBCInsert.java** - Java program to insert employee data using JDBC

## Setup Instructions

### Prerequisites
- MySQL Server installed and running
- Java JDK installed
- MySQL JDBC Driver (mysql-connector-java.jar)

### Database Setup

1. Create a database in MySQL:
```sql
CREATE DATABASE employee_db;
USE employee_db;
```

2. Run the table creation script:
```bash
mysql -u root -p employee_db < create_table.sql
```

3. Verify the table and data:
```sql
SELECT * FROM Empl;
```

### Running SQL Queries

Execute the queries from `queries.sql` in MySQL Workbench or command line:

```bash
mysql -u root -p employee_db < queries.sql
```

Or run individual queries in MySQL Workbench.

### Running JDBC Program

1. **Update Database Credentials** in `JDBCInsert.java`:
   - `DB_URL` is set to `employee_db` schema
   - Change `DB_USER` to your MySQL username (default: root)
   - Change `DB_PASSWORD` to your MySQL password

2. **Add MySQL JDBC Driver** to your classpath:
   - Download `mysql-connector-java-8.0.33.jar` (or latest version)
   - Add it to your project classpath

3. **Compile the Java program**:
```bash
javac -cp ".:mysql-connector-java-8.0.33.jar" JDBCInsert.java
```

4. **Run the Java program**:
```bash
java -cp ".:mysql-connector-java-8.0.33.jar" JDBCInsert
```

## Query Descriptions

- **Query A**: Display EName and Salary of employees with salary >= 2200
- **Query B**: Display details of employees not getting commission
- **Query C**: Display employee name and salary NOT in range 2500-4000
- **Query D**: Display name, job, and salary of employees without manager
- **Query E**: Display employee names with "A" as third alphabet
- **Query F**: Display employee names ending with "T"

## JDBC Program Details

The JDBC program (`JDBCInsert.java`) inserts the following employee data:

| empcode | empname | empage | esalary |
|---------|---------|--------|---------|
| 101     | Jenny   | 25     | 10000   |
| 102     | Jacky   | 30     | 20000   |
| 103     | Joe     | 20     | 40000   |
| 104     | John    | 40     | 80000   |
| 105     | Shameer | 25     | 90000   |

## Submission Notes

1. Take screenshots of:
   - Table creation and data insertion results
   - Each query execution result (A-F)
   - JDBC program execution output

2. Upload all files and screenshots to this GitHub repository

3. Make sure to update database credentials before running the JDBC program

## License

This project is for educational purposes.

"# task" 
