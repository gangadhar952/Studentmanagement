package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NewStudent {
    private Connection connection;
    private Scanner scanner;
    public NewStudent(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }
    public void newrecord(){
        String query = "insert into students(student_name,roll_no,cgpa,year) values(?,?,?,?);";
        scanner.nextLine();
        System.out.println("Enter name of the student: ");
        String student_name = scanner.nextLine();
        System.out.println("Enter roll_no of the student: ");
        int roll_no = scanner.nextInt();
        System.out.println("Enter cgpa of the student: ");
        int cgpa = scanner.nextInt();
        System.out.println("Enter the year student currently is in: ");
        int year = scanner.nextInt();
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,student_name);
            statement.setInt(2,roll_no);
            statement.setInt(3,cgpa);
            statement.setInt(4,year);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
