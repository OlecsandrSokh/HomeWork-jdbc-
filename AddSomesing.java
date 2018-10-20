import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddSomesing {
    public static Scanner scanner = new Scanner(System.in);

    public static void enterContry() throws SQLException {
        System.out.println("Enter contry name ");
        String contry = scanner.nextLine();
        insertCountry(contry);
    }

    public static void enterSity() throws SQLException{
        System.out.println("Enter sity name ");
        String sity = scanner.nextLine();
        System.out.println("enter a contry id");
        int id = scanner.nextInt();
        insertSiti(sity, id);
    }

    public static void enterPeople() throws SQLException{
        System.out.println("Enter first name ");
        String fname = scanner.next();
        System.out.println("Enter last name ");
        String lname = scanner.next();
        System.out.println("Enter sity id ");
        int id = scanner.nextInt();
        insertPeople(fname, lname, id);
    }

    private static void insertCountry(String str) throws SQLException {
        String qvery = "insert into country (country_name) values(?);";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(qvery);
        preparedStatement.setString(1, str);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void insertSiti(String str, int id) throws SQLException{
        String qvery = "insert into sities (siti_name, country_id) values(?, ?);";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(qvery);
        preparedStatement.setString(1, str);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void insertPeople(String firstName, String lastName, int id) throws SQLException{
        String query = "insert into people (first_name , last_name,  siti_id) values (?, ?, ?);";

        PreparedStatement preparedStatement = Program.conn.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
}
