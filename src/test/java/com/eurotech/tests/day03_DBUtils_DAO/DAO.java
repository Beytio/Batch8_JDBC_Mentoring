package com.eurotech.tests.day03_DBUtils_DAO;


import java.sql.*;

public class DAO {
        // Data Access Object
        public static void main(String[] args) throws SQLException {
            StudentDAO dao=new StudentDAO();
         //   Students s1=dao.getStudents(10);
         //   System.out.println(s1.sname);

            Students s2=new Students();
        //    s2.rollno=15;
          //  s2.sname="Ayşe";
            dao.connect();
            //dao.addStudents(s2);
            dao.deleteStudent(10);

            dao.destroy();


        }

}


class StudentDAO{
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Melek14.";

    Connection connection= null;

    public void connect() throws SQLException {
        connection=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
    }

    public void destroy() throws SQLException {
        connection.close();

    }



    public Students getStudents(int rollno) throws SQLException {
        Students s=new Students();
        s.rollno=rollno;



        String query ="select sname from students where rollno="+rollno;

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        String name=resultSet.getString(1);
        s.sname=name;



        return s;
    }


    public void addStudents(Students s2) throws SQLException {
        String query="insert into students values(?,?)";
        PreparedStatement pst= connection.prepareStatement(query);
        pst.setInt(1,s2.rollno);
        pst.setString(2,s2.sname);
        pst.executeUpdate();



    }

    public void deleteStudent(int rollno) throws SQLException {
        String query="delete from students where rollno="+rollno;
        PreparedStatement pst= connection.prepareStatement(query);
        pst.executeUpdate();

    }
}


class Students {
    int rollno;
    String sname;
}