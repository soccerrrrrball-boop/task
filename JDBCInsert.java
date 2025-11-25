import java.sql.*;

public class JDBCInsert {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456789";
    
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connected to the database successfully!");
            
            // Create table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee_table (" +
                    "empcode INT PRIMARY KEY, " +
                    "empname VARCHAR(30), " +
                    "empage INT, " +
                    "esalary DOUBLE" +
                    ")";
            
            stmt = conn.createStatement();
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created or already exists.");
            
            // Prepare insert statement
            String insertSQL = "INSERT INTO employee_table (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            
            // Employee data
            int[][] employeeData = {
                {101, 25, 10000},
                {102, 30, 20000},
                {103, 20, 40000},
                {104, 40, 80000},
                {105, 25, 90000}
            };
            
            String[] employeeNames = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
            
            // Insert each employee
            for (int i = 0; i < employeeData.length; i++) {
                pstmt.setInt(1, employeeData[i][0]); // empcode
                pstmt.setString(2, employeeNames[i]); // empname
                pstmt.setInt(3, employeeData[i][1]); // empage
                pstmt.setDouble(4, employeeData[i][2]); // esalary
                
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserted employee: " + employeeNames[i] + " (Rows affected: " + rowsAffected + ")");
            }
            
            System.out.println("\nAll employees inserted successfully!");
            
            // Display all inserted records
            System.out.println("\nDisplaying all employees:");
            rs = stmt.executeQuery("SELECT * FROM employee_table");
            System.out.println("EmpCode\tEmpName\tEmpAge\tESalary");
            System.out.println("----------------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("empcode") + "\t" + 
                                 rs.getString("empname") + "\t" + 
                                 rs.getInt("empage") + "\t" + 
                                 rs.getDouble("esalary"));
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            System.err.println("Error: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL Error occurred!");
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close resources in reverse order
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("\nDatabase connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

