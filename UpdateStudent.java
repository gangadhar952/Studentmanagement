package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent {
    private Connection connection;
    private Scanner scanner;

    public UpdateStudent(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void updatedata() {
        String update_query = "UPDATE students SET student_name = ?, roll_no = ?, cgpa = ?, year = ? WHERE roll_no = ?;";

        try {
            scanner.nextLine();
            System.out.println("Enter original roll_no of the student: ");
            int original_roll_no = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter name of the student: ");
            String student_name = scanner.nextLine();
            System.out.println("Enter new roll_no of the student: ");
            int new_roll_no = scanner.nextInt();
            System.out.println("Enter new cgpa of the student: ");
            float cgpa = scanner.nextFloat();
            System.out.println("Enter the year student currently is in: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            PreparedStatement statement = connection.prepareStatement(update_query);
            statement.setString(1, student_name);
            statement.setInt(2, new_roll_no);
            statement.setFloat(3, cgpa);
            statement.setInt(4, year);
            statement.setInt(5, original_roll_no);

            int rowsUpdated = statement.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }
}
