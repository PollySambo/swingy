package za.co.wethinkcode.app.Controller;

import za.co.wethinkcode.app.View.start.StartView;

import java.sql.SQLException;


public class StartController {

    private StartView view;

    public StartController(StartView view) {
        this.view = view;
    }

    public void onCreateHeroButtonPressed() throws SQLException, ClassNotFoundException {
        view.openCreateHero();
    }

    public void onSwitchButtonPressed() {
        view.switchView();
    }

    public void onSelectHeroButtonPressed() throws SQLException, ClassNotFoundException {
        view.openSelectHero();
    }
}
