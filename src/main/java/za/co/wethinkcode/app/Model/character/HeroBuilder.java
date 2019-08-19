package za.co.wethinkcode.app.Model.character;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.app.Model.artifact.Armor;
import za.co.wethinkcode.app.Model.artifact.Helm;
import za.co.wethinkcode.app.Model.artifact.Weapon;

@Getter
@Setter
public class HeroBuilder {
    private int id;
    private String name;
    private int attack;
    private int defense;
    private int hitPoints;
    private String heroClass;
    private int level;
    private int experience;
    private Weapon weapon;
    private Armor armor;
    private Helm helm;

    public Hero getHero() {
        return new Hero(name, attack, defense, hitPoints, id, heroClass, level, experience, weapon, armor, helm);
    }
}
