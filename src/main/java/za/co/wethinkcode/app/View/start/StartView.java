package za.co.wethinkcode.app.View.start;

import java.sql.SQLException;

public interface StartView {

    void start() throws SQLException, ClassNotFoundException;

    void openCreateHero() throws SQLException;

    void switchView();

    void openSelectHero() throws SQLException, ClassNotFoundException;
}
