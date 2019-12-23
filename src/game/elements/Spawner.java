package game.elements;

public class Spawner extends Angel {
    public Spawner(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
    }

    @Override
    public void interact(Player player) {
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
    }
}
