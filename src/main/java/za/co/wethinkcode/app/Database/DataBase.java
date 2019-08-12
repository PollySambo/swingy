package za.co.wethinkcode.app.Database;

import za.co.wethinkcode.app.Model.artifact.Armor;
import za.co.wethinkcode.app.Model.artifact.Helm;
import za.co.wethinkcode.app.Model.artifact.Weapon;
import za.co.wethinkcode.app.Model.character.Hero;
import za.co.wethinkcode.app.Model.character.HeroBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
public class DataBase {

    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DB_URL = "jdbc:sqlite:src/main/java/za/co/wethinkcode/app/Database/Swing.db";

    private static Connection connection = null;

    private static  Statement statement = null;

    public static void Connect2DataBase() throws ClassNotFoundException, SQLException 
    {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL);
            statement = connection.createStatement();
            System.out.println("Database Connected ");
    }

    private static Connection TestConnection() throws ClassNotFoundException, SQLException {
        if (connection != null)
            Connect2DataBase();
        return connection;
    }

    public static void DisConnect() throws SQLException {
            if (connection != null)
                connection.close();
            connection = null;
    }

    public static void CreateTabe() throws SQLException, ClassNotFoundException {

        TestConnection();

    String sql = "CREATE TABLE IF NOT EXISTS saves" +
                    "(characterName varchar(255), " +
                    " characterXP int, " +
                    " characterHP int, " +
                    " characterAP int, " +
                    " characterDP int)";
            statement.execute(sql);

            System.out.println("Created table in given database...");

            // sql = "REPLACE INTO saves (characterName ,characterXP ,characterHP ,characterAP ,characterDP)" +
            //         "VALUES" +
            //         "('Polite the sleepy' , 1000 , 100000000 , 1000000000000 , 2000000000000)";

            statement.execute(sql);
    }

    public static ArrayList<String> selectAll() throws ClassNotFoundException, SQLException {
        String sqlQuery = "SELECT * FROM saves";
        ArrayList<String> arrayList = new ArrayList<>();

        Statement stmt = TestConnection().createStatement();
        try (ResultSet rs = stmt.executeQuery(sqlQuery)) {
            for (int i = 1; rs.next(); i++) {
                arrayList.add(String.format("%d. %s (%s)", i, rs.getString("name"), rs.getString("class")));
            }
        }
        return arrayList;
    }

    public static Hero selectHeroById(int id) throws SQLException, ClassNotFoundException {
        String sqlQuery = "SELECT * FROM heroes WHERE id = ?";
        Hero hero = null;

        try (PreparedStatement pstmt = TestConnection().prepareStatement(sqlQuery)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                HeroBuilder builder = new HeroBuilder();
                builder.setId(rs.getInt("id"));
                builder.setName(rs.getString("name"));
                builder.setHeroClass(rs.getString("class"));
                builder.setLevel(rs.getInt("level"));
                builder.setExperience(rs.getInt("xp"));
                builder.setAttack(rs.getInt("attack"));
                builder.setDefense(rs.getInt("defense"));
                builder.setHitPoints(rs.getInt("hp"));

                if (rs.getString("weapon_name") != null)
                    builder.setWeapon(new Weapon(rs.getString("weapon_name"), rs.getInt("weapon_value")));
                if (rs.getString("helm_name") != null)
                    builder.setHelm(new Helm(rs.getString("helm_name"), rs.getInt("helm_value")));
                if (rs.getString("armor_name") != null)
                    builder.setArmor(new Armor(rs.getString("armor_name"), rs.getInt("armor_value")));

                hero = builder.getHero();
            }
        return hero;
    }
    }
}