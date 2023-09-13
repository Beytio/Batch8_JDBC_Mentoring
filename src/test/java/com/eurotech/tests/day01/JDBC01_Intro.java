package com.eurotech.tests.day01;

import java.sql.*;


public class JDBC01_Intro {

    public static void main(String[] args) throws SQLException {
        /*
        JDBC-- stands for-- java database connectivty
        1. import package               -- telefon gerekli      -- java.sql
        2. load
            register the driver         -- network e ihtiyaçımız var  -- mysql, oracle, postgres-- maven dependency

        3. establish the connection     --dail number --            Connection
        4. create statement             -- think what you ara gone say      -- statement- preparedStatement - collabaleStatement
        5. execute query                -- speak

        6. process the result           -- get response
        7. close                        -- close


         */


      String dbUrl="jdbc:postgresql://localhost:5432/postgres";
      String dbUserName="postgres";
      String dbPassWord="Melek14.";

      //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);

      // create a statement
      Statement statement= connection.createStatement();


      // run query and get the result
        ResultSet resultSet = statement.executeQuery("select * from employees");


        // resultset query deki bütün verileri tutar
        // ilk satır üstünde
        // next ile ilk satırın üzerine geliyoruz
        resultSet.next();

        // get the information by column name
    //    System.out.println("resultSet.getString(\"employeeid\") = " + resultSet.getString("employeeid"));
        int employeeid = resultSet.getInt("employeeid");
        String employeeid1 = resultSet.getString("employeeid");


        //get the info by index number
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));


        // move the pointer to the second row
        resultSet.next();

        //get the phone number by column name
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        // get the phone number by index
      System.out.println("resultSet.getString(5) = " + resultSet.getString(5));


      // get the employeeid, firstname, and lastname in one shot
      // loop

  //          true

      /*
      while(resultSet.next())
        System.out.println(
                resultSet.getString("employeeid")
                +" - "
                +resultSet.getString("firstname")
                +" - "
                +resultSet.getString("lastname")
        );
*/


      System.out.println("with for loop");
      for (; resultSet.next(); ) {


        System.out.println(
                resultSet.getString("employeeid")
                        +" - "
                        +resultSet.getString("firstname")
                        +" - "
                        +resultSet.getString("lastname")
        );

      }


    }
}
