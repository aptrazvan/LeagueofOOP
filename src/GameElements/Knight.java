package GameElements;

public class Knight extends Player {
    public Knight(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Knight";
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
