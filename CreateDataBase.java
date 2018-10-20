import java.sql.*;

public class CreateDataBase {

    private static void createTableCountry() throws SQLException {
        String dropQvery = "DROP TABLE IF EXISTS country;";
        String qvery = "create table country(" +
                "id int not null primary key auto_increment," +
                "country_name varchar(80) not null" +
                ");";
        Statement statement = Program.conn.createStatement();
        statement.execute(dropQvery);
        statement.execute(qvery);

        statement.close();
    }

    private static void createTableSities() throws SQLException {
        String dropQvery = "DROP TABLE IF EXISTS sities;";
        String qvery = "create table sities(" +
                "id int not null primary key auto_increment," +
                "siti_name varchar(80) not null," +
                "country_id int not null" +
                ");";
        Statement statement = Program.conn.createStatement();
        statement.execute(dropQvery);
        statement.execute(qvery);

        statement.close();
    }

    private static void createTablePeople() throws SQLException {

        String dropQvery = "DROP TABLE IF EXISTS people;";
        String qvery = "create table people(" +
                "id int not null primary key auto_increment," +
                "first_name varchar(80) not null, " +
                "last_name varchar(80) not null, " +
                "siti_id int not null" +
                ");";
        Statement statement = Program.conn.createStatement();
        statement.execute(dropQvery);
        statement.execute(qvery);

        statement.close();
    }

    private static void alterTable() throws SQLException{
        String querySities = "alter table sities add foreign key (country_id) references country(id);";
        String queryPeople = "alter table people add foreign key (siti_id) references sities(id);";
        Statement statement = Program.conn.createStatement();
        statement.execute(querySities);
        statement.execute(queryPeople);
        statement.close();

    }

    public static void createOllTables() throws SQLException {
        createTableCountry();
        createTablePeople();
        createTableSities();
        alterTable();
    }
}
