package za.co.wethinkcode.app.Controller;

import za.co.wethinkcode.app.Dependencies.exception.HeroValidationException;
import za.co.wethinkcode.app.Model.Game;
import za.co.wethinkcode.app.Model.character.Hero;
import za.co.wethinkcode.app.Model.character.HeroFactory;
import za.co.wethinkcode.app.Database.DataBase;
import za.co.wethinkcode.app.View.create.CreateHeroView;

import java.sql.SQLException;


public class CreateHeroController {

    private CreateHeroView view;
    private Game game;

    public CreateHeroController(CreateHeroView view) {
        this.view = view;
        game = Game.getInstance();
    }

    public void onCreateButtonPressed(String name, String heroClass) throws SQLException {
        Hero hero;
        try {
            hero = HeroFactory.newHero(name, heroClass);
            hero.validateHero();
        } catch (IllegalArgumentException | HeroValidationException e) {
            view.showErrorMessage(e.getMessage());
            view.getUserInput();
            return;
        }

//        int id = DataBase.insert(hero.getName(), hero.getHeroClass(), hero.getLevel(), hero.getExperience(), hero.getAttack(), hero.getDefense(), hero.getHitPoints());
//        hero.setId(id);
        game.initGame(hero);
        view.openGame();
    }
}
