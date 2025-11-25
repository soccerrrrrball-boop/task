# JDBC Setup Instructions

## Download MySQL JDBC Driver

The program needs the MySQL JDBC driver to run. Follow these steps:

### Option 1: Download from MySQL Website
1. Go to: https://dev.mysql.com/downloads/connector/j/
2. Download the Platform Independent ZIP file
3. Extract the JAR file (e.g., `mysql-connector-java-8.0.33.jar`)
4. Place it in the same folder as `JDBCInsert.java`

### Option 2: Using Maven (if you have Maven installed)
```bash
mvn dependency:get -Dartifact=mysql:mysql-connector-java:8.0.33
```

## Running the Program

Once you have the JAR file in the same directory:

### Compile:
```bash
javac JDBCInsert.java
```

### Run (replace with your actual JAR filename):
```bash
java -cp ".;mysql-connector-java-8.0.33.jar" JDBCInsert
```

Or if the JAR is in a different location:
```bash
java -cp ".;C:\path\to\mysql-connector-java-8.0.33.jar" JDBCInsert
```

## Quick Download Command (PowerShell)

You can also download directly using PowerShell:

```powershell
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.33/mysql-connector-java-8.0.33.jar" -OutFile "mysql-connector-java-8.0.33.jar"
```

Then run:
```bash
java -cp ".;mysql-connector-java-8.0.33.jar" JDBCInsert
```

