package com.eurotech.tests.day03_DBUtils_DAO;

import com.eurotech.utilities.DBUtils;
import org.testng.annotations.Test;

import java.sql.*;

public class C03_Update2 {

    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Melek14.";
    int locationId=10009;
    String adress="Eryaman Mah Başak Sitesi";
    int postCode=11111;
    String city="Ankara";
    String region="İç Anadolu";
    String country="TR";


    String query="insert into locations values ("+locationId+",'"+adress+"',"+postCode+",'"+city+"','"+region+"','"+country+"');";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        int rowCountEffected = statement.executeUpdate(query);


        DBUtils.destroy();

    }

}
