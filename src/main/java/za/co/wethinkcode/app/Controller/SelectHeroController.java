package za.co.wethinkcode.app.Controller;

import za.co.wethinkcode.app.Dependencies.exception.HeroValidationException;
import za.co.wethinkcode.app.Model.Game;
import za.co.wethinkcode.app.Model.character.Hero;
import za.co.wethinkcode.app.Database.DataBase;
import za.co.wethinkcode.app.View.select.SelectHeroView;

import java.sql.SQLException;
import java.util.ArrayList;

public class SelectHeroController {

    private SelectHeroView view;
    private Game game;

    public SelectHeroController(SelectHeroView view) {
        this.view = view;
        game = Game.getInstance();
    }

    public void onListElementSelected(int idx) throws SQLException, ClassNotFoundException {
        Hero hero = DataBase.selectHeroById(idx + 1);
        view.updateInfo(hero.toString());
    }

    public String[] getListData() throws SQLException, ClassNotFoundException {
        ArrayList<String> list = DataBase.selectAll();
        String[] listArr = new String[list.size()];
        listArr = list.toArray(listArr);
        return listArr;
    }

    public void onSelectButtonPressed(int idx) throws SQLException, ClassNotFoundException {
        Hero hero;
        try {
            hero = DataBase.selectHeroById(idx + 1);
            hero.validateHero();
        } catch (HeroValidationException e) {
            view.showErrorMessage(e.getMessage());
            return;
        }

        game.initGame(hero);
        view.openGame();
    }

    public void onCreateButtonPressed() throws SQLException, ClassNotFoundException {
        view.openCreateHero();
    }
}