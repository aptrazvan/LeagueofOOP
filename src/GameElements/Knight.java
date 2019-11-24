package GameElements;

public class Knight extends Player {
    public Knight(int positionX, int positionY) {
        super(positionX, positionY);
        heroClass = "Knight";
        resetHP();
        abilities.add(new Execute());
        abilities.add(new Slam());
    }

    public void accept(Ability ability) {
        ability.target(this);
    }
}
