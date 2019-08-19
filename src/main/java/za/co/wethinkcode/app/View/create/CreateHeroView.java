package za.co.wethinkcode.app.View.create;


import java.sql.SQLException;

public interface CreateHeroView {

    void start() throws SQLException, ClassNotFoundException;

    void getUserInput() throws SQLException, ClassNotFoundException;

    void showErrorMessage(String message);

    void openGame() throws SQLException;
}
