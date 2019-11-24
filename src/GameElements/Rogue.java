package GameElements;

public class Rogue extends Player{
    public Rogue(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Rogue";
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
