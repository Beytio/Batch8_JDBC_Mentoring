package com.eurotech.tests.day03_DBUtils_DAO;

import com.eurotech.utilities.DBUtils;
import org.testng.annotations.Test;

import java.sql.*;

public class C02_Update1 {

    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Melek14.";
    String query="insert into locations values (10008,'ABC MAH XYZ CAD',06100,'Ankara','İç Anadolu','TR');";
    /*
    DDL, DML, DQL
    if you are changing the structure of your table you use DDL
    DML-- changing the value
    DQL-- data ya ulaşmak için

    DQL-- executeQuery()-- resultset de depoladık
    DML -- executeUpdate()

     */

    @Test
    public void test1() throws SQLException {

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        int rowCountEffected = statement.executeUpdate(query);
        System.out.println("rowCountEffected = " + rowCountEffected);


        DBUtils.destroy();


    }


}
