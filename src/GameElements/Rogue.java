package GameElements;

public class Rogue extends Player{
    public Rogue(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Rogue";
        resetHP();
        abilities.add(new Backstab());
        abilities.add(new Paralysis());
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
