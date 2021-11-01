import java.sql.*;

public class TestConnection {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/test_schema";


    public static void main(String[] agrs){

        try{

            try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD)){

                System.out.println("Connection to Store DB successfully!");
                Statement statement = conn.createStatement();
                int rows = statement.executeUpdate("INSERT person(name, age) VALUES ('igor', 76)," +
                        "('Gala', 45)");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }

    }
}
