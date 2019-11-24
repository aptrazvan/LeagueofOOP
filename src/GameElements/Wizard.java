package GameElements;

public class Wizard extends Player {
    public Wizard(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Wizard";
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
