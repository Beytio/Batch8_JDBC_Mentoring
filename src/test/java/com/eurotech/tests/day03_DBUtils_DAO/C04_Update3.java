package com.eurotech.tests.day03_DBUtils_DAO;

import com.eurotech.utilities.DBUtils;
import org.testng.annotations.Test;

import java.sql.*;

public class C04_Update3 {

    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Melek14.";
    int locationId=10010;
    String adress="Gülistan Mah Başak Sitesi";
    int postCode=22222;
    String city="Isparta";
    String region="Akdeniz";
    String country="TR";


    String query="insert into locations values (?,?,?,?,?,?);";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        PreparedStatement statement=connection.prepareStatement(query);

        statement.setInt(1,locationId);
        statement.setString(2,adress);
        statement.setInt(3,postCode);
        statement.setString(4,city);
        statement.setString(5,region);
        statement.setString(6,country);


        int rowCountEffected = statement.executeUpdate();


        DBUtils.destroy();

    }

}
