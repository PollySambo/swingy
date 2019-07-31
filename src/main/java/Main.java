
import java.sql.*;

public class Main
{
    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:saves.db";

    public static void main(String[] args)
    {
        Connection connection = null;
        Statement statement = null;
        try
        {
            // STEP 1: Register JDBC driver
            // Class.forName(JDBC_DRIVER);
            Class.forName(JDBC_DRIVER);
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL);
            //STEP 3: Execute a query
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            System.out.println("statement");


            String sql = "CREATE TABLE IF NOT EXISTS saves" +
                    "(characterName varchar(255), " +
                    " characterXP int, " +
                    " characterHP int, " +
                    " characterAP int, " +
                    " characterDP int)";
            statement.execute(sql);

            System.out.println("Created table in given database...");

            sql = "REPLACE INTO saves (characterName ,characterXP ,characterHP ,characterAP ,characterDP)" +
                    "VALUES" +
                    "('Polite the sleepy' , 1000 , 100000000 , 1000000000000 , 2000000000000)";

//            resultSet = statement.executeQuery(sql);';

            statement.execute(sql);

        }
        catch (NullPointerException e)
        {
            System.out.println("Trying to access NULL");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return;
    }
}