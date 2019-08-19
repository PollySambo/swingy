package za.co.wethinkcode.app.View.select;

import za.co.wethinkcode.app.Main.App;
import za.co.wethinkcode.app.Controller.SelectHeroController;
import za.co.wethinkcode.app.View.create.CreateHeroViewConsole;
import za.co.wethinkcode.app.View.game.GameViewConsole;

import java.sql.SQLException;
import java.util.Scanner;


public class SelectHeroViewConsole implements SelectHeroView {

    private SelectHeroController controller;
    private int lastIdx = -1;

    @Override
    public void start() throws SQLException, ClassNotFoundException {
        controller = new SelectHeroController(this);

        getInput();
    }

    private void getInput() throws SQLException, ClassNotFoundException {
        Scanner scanner = App.getScanner();

        System.out.println("Available heroes: ");
        printHeroes(controller.getListData());

        System.out.println();
        System.out.println("CREATE - to create hero");
        System.out.println("NUMBER - enter number of available hero to see full information");
        System.out.println("SELECT - enter select after entering number");
        System.out.println("Commands (CREATE, NUMBER, SELECT):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateButtonPressed();
                break;
            } else if (isValidNumericString(input, controller.getListData().length)) {
                lastIdx = Integer.parseInt(input) - 1;
                controller.onListElementSelected(lastIdx);
            } else if ("select".equalsIgnoreCase(input) && lastIdx != -1) {
                controller.onSelectButtonPressed(lastIdx);
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    private boolean isValidNumericString(String str, int max) {
        try {
            int n = Integer.parseInt(str);
            if (n <= 0 || n > max)
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void printHeroes(String[] heroes) {
        if (heroes.length == 0)
            System.out.println("No saved heroes");
        for (String hero : heroes) {
            System.out.println(hero);
        }
    }

    @Override
    public void updateInfo(String info) {
        System.out.println(info);
    }

    @Override
    public void showErrorMessage(String message) throws SQLException, ClassNotFoundException {
        System.out.println("Error: " + message);
        getInput();
    }

    @Override
    public void openGame() throws SQLException {
        new GameViewConsole().start();
    }

    @Override
    public void openCreateHero() throws SQLException, ClassNotFoundException {
        new CreateHeroViewConsole().start();
    }
}
