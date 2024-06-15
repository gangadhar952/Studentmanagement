package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Showstudentdata {
    private Connection connection;
    private Scanner scanner;
    public Showstudentdata(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void showdata(){
        String query = "select * from students;";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String student_name = resultSet.getString("student_name");
                int roll_no = resultSet.getInt("roll_no");
                int cgpa = resultSet.getInt("cgpa");
                int year = resultSet.getInt("year");
                System.out.println("Student name is "+student_name);
                System.out.println("Student roll no is "+roll_no);
                System.out.println("Student cgpa is "+cgpa);
                System.out.println("Student is currently in "+year);
                System.out.println();
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
