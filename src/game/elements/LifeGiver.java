package game.elements;

public class LifeGiver extends Angel {
    public LifeGiver(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
        angelClass = "LifeGiver";
    }

    @Override
    public void interact(Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 100;
                break;
            case "Pyromancer":
                modifier = 80;
                break;
            case "Rogue":
                modifier = 90;
                break;
            case "Wizard":
                modifier = 120;
                break;
            default:
                break;
        }

        int maxHP = HPTable.getInstance().getTable().get(player.getHeroClass() + "Start")
                + player.getLevel() * HPTable.getInstance().getTable().get(player.getHeroClass() + "Level");

        player.gainHP(modifier);

        if (player.getHP() > maxHP) {
            player.resetHP();
        }

        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
