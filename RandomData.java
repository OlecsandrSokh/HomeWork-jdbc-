import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class RandomData {
    private static final String PATH = System.getProperty("user.dir");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private static ArrayList<String> redFile(String fileName){
        ArrayList<String> countries = new ArrayList<>();

        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(PATH + SEPARATOR + fileName + ".txt"));

            while (true){
                String line = br.readLine();
                if(line != null){
                    countries.add(line);
                } else {
                    break;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    public static void randomData() throws SQLException {
        Random random = new Random();
        ArrayList<String> contry;
        ArrayList<String> sities;
        ArrayList<String> people;
        contry = redFile("contry");
        sities = redFile("sity");
        people = redFile("people");
        for (int i = 0; i < contry.size(); i++) {
            String qvery = "insert into country (country_name) values(?);";

            PreparedStatement preparedStatement = Program.conn.prepareStatement(qvery);
            preparedStatement.setString(1, contry.get(i));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        for (int i = 0; i < sities.size(); i++) {
            int j = random.nextInt(contry.size() - 1) + 1;
            String qvery1 = "insert into sities (siti_name, country_id) values(?, ?);";

            PreparedStatement preparedStatement1 = Program.conn.prepareStatement(qvery1);
            preparedStatement1.setString(1, sities.get(i));
            preparedStatement1.setInt(2, j);
            preparedStatement1.executeUpdate();
            preparedStatement1.close();
        }

        people.stream().forEach(p -> {
            String query2 = "insert into people (first_name , last_name, siti_id) values (?, ?, ?);";
            PreparedStatement preparedStatement2 = null;
            try {
                int x = (int)Math.floor(Math.random()*sities.size());
                preparedStatement2 = Program.conn.prepareStatement(query2);
                preparedStatement2.setString(1, p.split(" ")[0]);
                preparedStatement2.setString(2, p.split(" ")[1]);
                preparedStatement2.setInt(3, x);
                preparedStatement2.executeUpdate();
                preparedStatement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
