package game.elements;

public class XPAngel extends Angel {
    public XPAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "XPAngel";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 45;
                break;
            case "Pyromancer":
                modifier = 50;
                break;
            case "Rogue":
                modifier = 40;
                break;
            case "Wizard":
                modifier = 60;
                break;
            default:
                break;
        }

        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
        player.gainXP(modifier);
        player.levelUp();
    }
}
