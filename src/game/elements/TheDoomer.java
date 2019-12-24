package game.elements;

public class TheDoomer extends Angel {
    public TheDoomer(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
        angelClass = "TheDoomer";
    }

    @Override
    public void interact(Player player) {
        player.setHP(0);
        Subject.getInstance().setState(4, angelClass, player.getHeroClass(),
                0, player.getId());
        Subject.getInstance().setState(7, player.getHeroClass(), null,
                player.getId(), 0);
    }
}
