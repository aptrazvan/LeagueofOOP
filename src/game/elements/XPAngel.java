package game.elements;

public class XPAngel extends Angel {
    public XPAngel(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
        angelClass = "XPAngel";
    }

    @Override
    public void interact(Player player) {
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

        player.gainXP(modifier);
        player.levelUp();
        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
