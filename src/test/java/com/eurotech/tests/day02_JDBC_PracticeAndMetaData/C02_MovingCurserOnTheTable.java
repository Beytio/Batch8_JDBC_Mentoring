package com.eurotech.tests.day02_JDBC_PracticeAndMetaData;

import org.testng.annotations.Test;

import java.sql.*;

public class C02_MovingCurserOnTheTable {

    String dbUrl="jdbc:postgresql://localhost:5432/postgres";
    String dbUserName="postgres";
    String dbPassWord="Melek14.";


    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

    // how to find row count
        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("rowCount = " + rowCount);


        System.out.println("........");

        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        System.out.println("......");

        // how to get Ahmet firstname directly
        resultSet.absolute(7);
        String firstnameof7thRow = resultSet.getString("firstname");
        System.out.println("firstnameof7thRow = " + firstnameof7thRow);


        //  how to go 6 the row
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());


        resultSet.close();
        statement.close();
        connection.close();

    }

}

/*
    next() -- bir sonraki satır

    previos()--- bir önceki satır
    beforeFirst()--- default durum
    afterLast()--- tablonun son satırından sonraki boş kısma
    first()--- ilk satıra
    last()--- son satıra
    absolute(integer)---pointer i istediğimiz satıra götürür


 */