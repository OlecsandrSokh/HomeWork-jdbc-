import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindPeopleInPatern {
    public static void peopleInPatern(String patern) throws SQLException{
        String query = "select * from people where first_name like ?;";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setString(1, patern);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                    "ID: " + resultSet.getInt("id") +  "\t |" +
                            "First name: " + resultSet.getString("first_name") +  "\t |"+
                            "Last name: " + resultSet.getString("last_name") + "\t |" +
                            "sity id: " + resultSet.getInt("siti_id")
            );
        }
    }
}
