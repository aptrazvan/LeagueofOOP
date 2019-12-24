package game.elements;

public class Spawner extends Angel {
    public Spawner(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "Spawner";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 200;
                break;
            case "Pyromancer":
                modifier = 150;
                break;
            case "Rogue":
                modifier = 180;
                break;
            case "Wizard":
                modifier = 120;
                break;
            default:
                break;
        }

        player.setHP(modifier);
        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
        Subject.getInstance().setState(8, player.getHeroClass(), null,
                player.getId(), 0);
    }
}
