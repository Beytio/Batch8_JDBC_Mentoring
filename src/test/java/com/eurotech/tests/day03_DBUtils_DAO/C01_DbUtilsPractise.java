package com.eurotech.tests.day03_DBUtils_DAO;

import com.eurotech.utilities.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class C01_DbUtilsPractise {
    @Test
    public void listOfMap(){
        // create connection
        DBUtils.createConnection();

        //get all information from employees and put them into a list of map
        List<Map<String, Object>> list = DBUtils.getQueryResultMap("select * from employees");

        //print all info that belongs to employee table
        System.out.println("list = " + list);

        // get the firstname of 5th row
        String actualFirstname = (String) list.get(4).get("firstname");
        String expectedFirstName="Fethi";
        Assert.assertEquals(actualFirstname,expectedFirstName);

        // get the salary of 13th row

        DBUtils.destroy();
    }

    @Test
    public void oneSingleRow(){
        DBUtils.createConnection();

        Map<String, Object> rowMap = DBUtils.getRowMap("select * from employees where firstname='Elif'");

        System.out.println("rowMap = " + rowMap);

        Integer expectedEmployeeId=1010;
        Integer actualEmployeeid = (Integer) rowMap.get("employeeid");
        Assert.assertEquals(actualEmployeeid,expectedEmployeeId);

        DBUtils.destroy();


    }


}
