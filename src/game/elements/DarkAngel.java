package game.elements;

public class DarkAngel extends Angel {
    public DarkAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "DarkAngel";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 40;
                break;
            case "Pyromancer":
                modifier = 30;
                break;
            case "Rogue":
                modifier = 10;
                break;
            case "Wizard":
                modifier = 20;
                break;
            default:
                break;
        }

        player.takeDamage(modifier);
        Subject.getInstance().setState(4, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
