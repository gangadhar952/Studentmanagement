package StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudent {
    private Connection connection;
    private Scanner scanner;

    public DeleteStudent(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void deleteData() {
        String delete_query = "DELETE FROM students WHERE roll_no = ?;";

        try {

            scanner.nextLine();

            System.out.println("Enter the roll number of the student to delete: ");
            int roll_no = scanner.nextInt();

            scanner.nextLine();

            PreparedStatement statement = connection.prepareStatement(delete_query);
            statement.setInt(1, roll_no);

            int rowsDeleted = statement.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}

