package com.eurotech.tests.day02_JDBC_PracticeAndMetaData;

import org.testng.annotations.Test;

import java.sql.*;

public class C03_JDBC_MetaData {

    String dbUrl="jdbc:postgresql://localhost:5432/postgres";
    String dbUserName="postgres";
    String dbPassWord="Melek14.";


    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

       //  result set bie başlıkları vermiyor bunları alamını yolu
        // get the database related data inside the databaseMetaData object

        DatabaseMetaData databaseMetaData= connection.getMetaData();

        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());

        System.out.println("........");

        // get the result set object metadata
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        // how many columns we have
        System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());


        System.out.println(".................");

        // column names
        // index number start with 1

        System.out.println("resultSetMetaData.getColumnName(1) = " + resultSetMetaData.getColumnName(1));
        System.out.println("resultSetMetaData.getColumnName(2) = " + resultSetMetaData.getColumnName(2));

        System.out.println(".....");
        // print all the column names dynamically

        for (int i = 1; i <= resultSetMetaData.getColumnCount() ; i++) {
            System.out.println(i+ ".column name " + resultSetMetaData.getColumnName(i));

        }


        resultSet.close();
        statement.close();
        connection.close();

    }
}
