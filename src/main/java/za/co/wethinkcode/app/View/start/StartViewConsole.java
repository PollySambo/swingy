package za.co.wethinkcode.app.View.start;

import za.co.wethinkcode.app.Main.App;
import za.co.wethinkcode.app.Controller.StartController;
import za.co.wethinkcode.app.View.create.CreateHeroViewConsole;
import za.co.wethinkcode.app.View.select.SelectHeroViewConsole;

import java.sql.SQLException;
import java.util.Scanner;


public class StartViewConsole implements StartView {

    private StartController controller;

    @Override
    public void start() throws SQLException, ClassNotFoundException {
        controller = new StartController(this);
        System.out.println("You are in console RPG game, enter available commands to play.");

        Scanner scanner = App.getScanner();
        System.out.println();
        System.out.println("CREATE - to create hero");
        System.out.println("SELECT - to select already created hero");
        System.out.println("SWITCH - to switch to GUI view");
        System.out.println("Commands (CREATE, SELECT, SWITCH):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateHeroButtonPressed();
                break;
            } else if ("select".equalsIgnoreCase(input)) {
                controller.onSelectHeroButtonPressed();
                break;
            } else if ("switch".equalsIgnoreCase(input)) {
                controller.onSwitchButtonPressed();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    @Override
    public void openCreateHero() throws SQLException, ClassNotFoundException {
        new CreateHeroViewConsole().start();
    }

    @Override
    public void switchView() {
        return;
//        new StartViewGUI().start();
    }

    @Override
    public void openSelectHero() throws SQLException, ClassNotFoundException {
        new SelectHeroViewConsole().start();
    }
}
