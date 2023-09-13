package com.eurotech.tests.day02_JDBC_PracticeAndMetaData;

import java.sql.*;

public class C01_JDBC_Practice {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:postgresql://localhost:5432/postgres";
        String dbUserName="postgres";
        String dbPassWord="Melek14.";


        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        Statement statement= connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from locations");


        //get the locationid, streetaddress, postcode of first row
        resultSet.next();
        System.out.println(resultSet.getString("locationid")
        +" "
        +resultSet.getString("streetaddress")
        +" "
        +resultSet.getString("postcode"));


        System.out.println(".....................");

        //get the all info of 4th row
        resultSet.next();
        resultSet.next();
        resultSet.next();

        for (int i = 1; i <= 6; i++) {
            System.out.println(i+ ".column  " + resultSet.getString(i));
        }

        System.out.println(".....................");

        // get the region of last row
        resultSet.next();
        resultSet.next();
        resultSet.next();
        resultSet.next();
        System.out.println("resultSet.getString(\"region\") = " + resultSet.getString("region"));


        resultSet.close();
        statement.close();
        connection.close();

    }
}
