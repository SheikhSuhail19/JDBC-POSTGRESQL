import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        int rollno = 3;
        String name = "Doe";
        int age = 21;

        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO students (rollno, name, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, rollno);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);

            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully." + preparedStatement);

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
