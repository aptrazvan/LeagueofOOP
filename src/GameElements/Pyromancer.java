package GameElements;

public class Pyromancer extends Player {
    public Pyromancer(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Pyromancer";
        resetHP();
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
