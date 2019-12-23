package game.elements;

public class TheDoomer extends Angel {
    public TheDoomer(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
    }

    @Override
    public void interact(Player player) {
        player.setHP(0);
    }
}
