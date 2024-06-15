package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRecords {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String user = "root";
    private static final String password = "Gangadhar@12345";
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            Scanner scanner = new Scanner(System.in);
            NewStudent newstudent = new NewStudent(connection,scanner);
            UpdateStudent updatestudent = new UpdateStudent(connection,scanner);
            DeleteStudent deletestudent = new DeleteStudent(connection,scanner);
            Showstudentdata studentdata = new Showstudentdata(connection,scanner);
            while(true){
                System.out.println();
                System.out.println("1.Enter new student records");
                System.out.println("2.Update existing record of a student");
                System.out.println("3.Delete existing record of a student");
                System.out.println("4.Show record of a student");
                System.out.println("5.Exit");
                System.out.println("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        newstudent.newrecord();
                        break;
                    case 2:
                        updatestudent.updatedata();
                        break;
                    case 3:
                        deletestudent.deleteData();
                        break;
                    case 4:
                        studentdata.showdata();
                        break;
                    case 5:
                        System.out.println("You are now logged out!");
                        return;
                    default:
                        System.out.println("Enter Valid Choice");
                        break;
                }
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
