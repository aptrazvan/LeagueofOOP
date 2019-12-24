package game.elements;

public class DarkAngel extends Angel {
    public DarkAngel(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
        angelClass = "DarkAngel";
    }

    @Override
    public void interact(Player player) {
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
