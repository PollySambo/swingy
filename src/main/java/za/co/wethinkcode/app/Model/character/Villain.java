package za.co.wethinkcode.app.Model.character;

import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.app.Model.artifact.Artifact;

@Setter
@Getter
public class Villain extends Character {

    private Artifact artifact;

    public Villain(String name, int attack, int defense, int hitPoints, Artifact artifact) {
        super(name, attack, defense, hitPoints);
        this.artifact = artifact;
    }

}
