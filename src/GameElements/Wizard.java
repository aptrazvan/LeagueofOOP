package GameElements;

public class Wizard extends Player {
    public Wizard(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Wizard";
        resetHP();
        abilities.add(new Drain());
        abilities.add(new Deflect());
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
