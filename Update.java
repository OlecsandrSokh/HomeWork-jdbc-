import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void updatePeople(String firstName, String lastName,int home, int id) throws SQLException {
        String query = "update people set first_name = ?, last_name = ?, siti_id = ? where id = ?;";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, home);
        preparedStatement.setInt(4, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
