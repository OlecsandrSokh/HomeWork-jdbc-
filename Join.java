import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Join {
    public static void peopleInSity(int id) throws SQLException {
        String query = "select p.* from people p join sities s on s.id = p.siti_id where s.id = ? ;";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(
                    "ID: " + resultSet.getInt("id") + "\t |" +
                            "First name: " + resultSet.getString("first_name") + "\t |" +
                            "Last name: " + resultSet.getString("last_name") + "\t |" +
                            "sity id: " + resultSet.getInt("siti_id")
            );
        }
    }

    public static void sityInContry(int id) throws SQLException{
        String query = "select s.* from sities s join country c on c.id = s.country_id where c.id = ? ;";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                    "ID: " + resultSet.getInt("id") + "\t |" +
                            "Sity: " + resultSet.getString("siti_name") + "\t |" +
                            "Contry id: " + resultSet.getInt("country_id")
            );
        }
    }

    public static void peopleContryAndSity(int id) throws SQLException{
        String query = "select s.siti_name, c.country_name from people p join sities s on s.id = p.siti_id" +
                " join country c on s.country_id = c.id where p.id = ? ;";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                            "Sity: " + resultSet.getString("siti_name") + "\t |" +
                            "Contry: " + resultSet.getString("country_name")
            );
        }
    }

}
