package za.co.wethinkcode.app.View.select;


import java.sql.SQLException;

public interface SelectHeroView {

    void start() throws SQLException, ClassNotFoundException;

    void updateInfo(String info);

    void showErrorMessage(String message) throws SQLException, ClassNotFoundException;

    void openGame() throws SQLException;

    void openCreateHero() throws SQLException, ClassNotFoundException;
}
