package com.order.service;
import java.sql.*;


public class JavaToMySQL {

    // JDBC URL, username and password of MySQL server
    private  String url = "jdbc:mysql://localhost:3306/mydb";
    private  String user = "root";
    private  String password = "12345";

    // JDBC variables for opening and managing connection
    private  Connection con;
    private  Statement stmt;
    private  ResultSet rs;
    private  ResultSet ru;


    public void mybd() {
        String query = "select * from meal;";


        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            con.prepareStatement("select * from accounts where id = 1").setString(1, "");
            while (rs.next()) {
                int count = rs.getInt(1);

                System.out.println("Total number of meals: " + count);
            }


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}
