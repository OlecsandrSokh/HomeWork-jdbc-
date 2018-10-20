import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTabels {

    public static void selectContry() throws SQLException {
        String qvery = "select * from country;";
        PreparedStatement preparedStatement = Program.conn.prepareStatement(qvery);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                    "ID: " + resultSet.getInt("id") + "\t |" +
                            "Country: " + resultSet.getString("country_name")
            );
        }
    }

    public static void selectSities() throws SQLException{
        String query = "select * from sities order by siti_name desc;";
        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                    "ID: " + resultSet.getInt("id") + "\t |" +
                            "Sity: " + resultSet.getString("siti_name") + "\t |" +
                            "Contry id: " + resultSet.getInt("country_id")
            );
        }
    }

    public static void selectPeople() throws SQLException{
        String query = "select * from people order by first_name;";
        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
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

    public static void selectPeople(int id) throws SQLException{
        String query = "select * from people where id = ?;";
        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
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

    public static void selectSities(int id) throws SQLException{
        String query = "select * from sities where id = ?;";
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

    public static void selectContry(int id) throws SQLException {
        String qvery = "select * from country where id = ?;";
        PreparedStatement preparedStatement = Program.conn.prepareStatement(qvery);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(
                    "ID: " + resultSet.getInt("id") + "\t |" +
                            "Country: " + resultSet.getString("country_name")
            );
        }
    }
}
