import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Program {

    public static Connection conn;

    public static void main(String[] args) throws SQLException, IOException {

        String dbURL = "jdbc:mysql://localhost:3306/sities?serverTimezone=UTC";
        String userName = "root" ;
        String password = "1488";

        Scanner sc = new Scanner(System.in);

        conn = (Connection) DriverManager.getConnection(dbURL, userName, password);
        int k;
        boolean exitInWhile = true;
        while (exitInWhile){
            System.out.println("1 - Add country");
            System.out.println("2 - Add sity ");
            System.out.println("3 - Add human");
            System.out.println("4 - Show human");
            System.out.println("5 - Show sities revers sort");
            System.out.println("6 - Show country");
            System.out.println("7 - human information id");
            System.out.println("8 - sities information id");
            System.out.println("9 - country information id");
            System.out.println("10 - human information at sity");
            System.out.println("11 - siti at country");
            System.out.println("12 - human at sity and country");
            System.out.println("13 - find human");
            System.out.println("14 - 50 random data");
            System.out.println("15 - refresh data bese");
            System.out.println("16 - exit");
            System.out.println("20 - create a table");
            System.out.print("Enter a number from menu : ");
            k = sc.nextInt();
            switch (k){
                case 1:
                    AddSomesing.enterContry();
                    break;
                case 2:
                    AddSomesing.enterSity();
                    break;
                case 3:
                    AddSomesing.enterPeople();
                    break;
                case 4:
                    SelectTabels.selectPeople();
                    break;
                case 5:
                    SelectTabels.selectSities();
                    break;
                case 6:
                    SelectTabels.selectContry();
                    break;
                case 7:
                    System.out.println("enter people id: ");
                    int id = sc.nextInt();
                    SelectTabels.selectPeople(id);
                    break;
                case 8:
                    System.out.println("enter sities id: ");
                    int id1 = sc.nextInt();
                    SelectTabels.selectSities(id1);
                    break;
                case 9:
                    System.out.println("enter contry id: ");
                    int id2 = sc.nextInt();
                    SelectTabels.selectContry(id2);
                    break;
                case 10:
                    System.out.println("enter sities id: ");
                    int id3 = sc.nextInt();
                    Join.peopleInSity(id3);
                    break;
                case 11:
                    System.out.println("enter contry id: ");
                    int id4 = sc.nextInt();
                    Join.sityInContry(id4);
                    break;
                case 12:
                    System.out.println("enter people id: ");
                    int id5 = sc.nextInt();
                    Join.peopleContryAndSity(id5);
                    break;
                case 13:
                    System.out.println("Enter a patern: ");
                    String p = "%";
                    String patern = sc.next();
                    String patern1 = p + patern + p;
                    FindPeopleInPatern.peopleInPatern(patern1);
                    break;
                case 14:
                    RandomData.randomData();
                    break;
                case 15:
                    System.out.println("Enter id people: ");
                    int idp = sc.nextInt();
                    System.out.println("Enter first name: ");
                    String fn = sc.next();
                    System.out.println("Enter last name: ");
                    String ln = sc.next();
                    System.out.println("enter siti id: ");
                    int ids = sc.nextInt();
                    Update.updatePeople(fn, ln, ids, idp);
                    break;
                case 16:
                    exitInWhile = false;
                    break;
                case 20:
                    CreateDataBase.createOllTables();
                    break;
            }
            System.out.println();
        }

        sc.close();
        conn.close();
    }

}
