package za.co.wethinkcode.app.View.game;

import za.co.wethinkcode.app.Model.Game;
import za.co.wethinkcode.app.Dependencies.exception.Point;

import java.sql.SQLException;


public interface GameView {

    void start() throws SQLException;

    void printMap(boolean[][] map, Point heroCoord);

    void update(Game game) throws SQLException;

    void gameFinished() throws SQLException;

    void showMessage(String message);

    void getVillainCollisionInput() throws SQLException;

    boolean replaceArtifact(String replaceMessage);

    void switchView();
}
