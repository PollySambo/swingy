package za.co.wethinkcode.app.View.create;

import za.co.wethinkcode.app.Main.App;
import za.co.wethinkcode.app.Controller.CreateHeroController;
import za.co.wethinkcode.app.View.game.GameViewConsole;

import java.sql.SQLException;
import java.util.Scanner;


public class CreateHeroViewConsole implements CreateHeroView {

    private CreateHeroController controller;

    @Override
    public void start() throws SQLException {
        controller = new CreateHeroController(this);

        getUserInput();
    }

    @Override
    public void getUserInput() throws SQLException {
        Scanner scanner = App.getScanner();

        System.out.println("To create hero enter his name and class.");
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Classes: attack  defense   hp\n" +
                "Warrior    40      20      100\n" +
                "Shaman     30      15      90\n" +
                "Priest     25      25      90\n" +
                "Paladin    40      30      120\n" +
                "Mage       45      10      80\n" +
                "Hunter     25      20      110\n" +
                "Enter class name: ");
        String heroClass = scanner.nextLine();

        System.out.println("CREATE - to create hero with previously entered Name and Class");
        System.out.println("Command (CREATE):");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("create".equalsIgnoreCase(input)) {
                controller.onCreateButtonPressed(name, heroClass);
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void openGame() throws SQLException {
        new GameViewConsole().start();
    }
}
