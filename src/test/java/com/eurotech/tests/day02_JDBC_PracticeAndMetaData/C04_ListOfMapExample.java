package com.eurotech.tests.day02_JDBC_PracticeAndMetaData;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C04_ListOfMapExample {
    String dbUrl="jdbc:postgresql://localhost:5432/postgres";
    String dbUserName="postgres";
    String dbPassWord="Melek14.";


    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select firstname, lastname, salary, jobid from employees");

        List<Map<String ,Object>>  queryData=new ArrayList<>();

        Map<String ,Object> row1=new HashMap<>();
        row1.put("firstname","Ahmet");
        row1.put("lastname","Çakar");
        row1.put("salary",200000);
        row1.put("jobid","QA");

        System.out.println("row1 = " + row1);


        Map<String ,Object> row2=new HashMap<>();
        row2.put("firstname","Mehmet");
        row2.put("lastname","Aymaz");
        row2.put("salary",120000);
        row2.put("jobid","Dev");

        System.out.println("row2 = " + row2);

        queryData.add(row1);
        queryData.add(row2);

        // get the Ahmet lastname directly from the list
        System.out.println("queryData.get(0).get(\"lastname\") = " + queryData.get(0).get("lastname"));

        // get the mehmet salary
        System.out.println("queryData.get(1).get(\"salary\") = " + queryData.get(1).get("salary"));

        System.out.println("........");

        System.out.println("queryData = " + queryData);


        System.out.println("...............");




        List<Map<String,Object>> queryData2=new ArrayList<>();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        resultSet.next();

        //create a map that contains the first row
        Map<String,Object> row1Dyn=new HashMap<>();
        row1Dyn.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstname"));
        row1Dyn.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastname"));
        row1Dyn.put(resultSetMetaData.getColumnName(3),resultSet.getString("salary"));
        row1Dyn.put(resultSetMetaData.getColumnName(4),resultSet.getString("jobid"));


        System.out.println("row1Dyn = " + row1Dyn);

        //create a map that contains the second row
        resultSet.next();

        Map<String,Object> row2Dyn=new HashMap<>();
        row2Dyn.put(resultSetMetaData.getColumnName(1),resultSet.getString(1));
        row2Dyn.put(resultSetMetaData.getColumnName(2),resultSet.getString(2));
        row2Dyn.put(resultSetMetaData.getColumnName(3),resultSet.getString(3));
        row2Dyn.put(resultSetMetaData.getColumnName(4),resultSet.getString(4));


        System.out.println("row2Dyn = " + row2Dyn);

        // add maps into list of map
        queryData2.add(row1Dyn);
        queryData2.add(row2Dyn);

        //get the first one lastname from the list
        System.out.println("queryData2.get(0).get(\"lastname\") = " + queryData2.get(0).get("lastname"));
        // get alperens salary
        System.out.println("queryData2.get(1).get(\"salary\") = " + queryData2.get(1).get("salary"));


        resultSet.close();
        statement.close();
        connection.close();

    }
}
