package za.co.wethinkcode.app.Model.artifact;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Artifact {

    private int points;
    protected String name;

    public Artifact(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    public String toString() {
        return name + " (+" + points + ")";
    }
}
