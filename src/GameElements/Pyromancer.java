package GameElements;

public class Pyromancer extends Player {
    public Pyromancer(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Pyromancer";
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
