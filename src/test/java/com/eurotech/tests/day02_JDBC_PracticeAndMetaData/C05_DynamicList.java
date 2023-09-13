package com.eurotech.tests.day02_JDBC_PracticeAndMetaData;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C05_DynamicList {
    String dbUrl="jdbc:postgresql://localhost:5432/postgres";
    String dbUserName="postgres";
    String dbPassWord="Melek14.";


    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select firstname, lastname, salary, jobId from employees");

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        List<Map<String,Object>> queryData=new ArrayList<>();



        while (resultSet.next()){
           Map<String ,Object> map=new HashMap<>();

            for (int i = 1; i <=resultSetMetaData.getColumnCount() ; i++) {
                map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
            }
            queryData.add(map);

            System.out.println(map);
        }

        System.out.println("queryData = " + queryData);

        //get the job id of last one
        System.out.println("queryData.get(queryData.size()-1).get(\"jobid\") = " + queryData.get(queryData.size() - 1).get("jobid"));


        resultSet.close();
        statement.close();
        connection.close();

    }
}
