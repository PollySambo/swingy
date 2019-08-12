package za.co.wethinkcode.app.View.create;


import java.sql.SQLException;

public interface CreateHeroView {

    void start() throws SQLException;

    void getUserInput() throws SQLException;

    void showErrorMessage(String message);

    void openGame() throws SQLException;
}
