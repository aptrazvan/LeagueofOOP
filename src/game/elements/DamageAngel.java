package game.elements;

public class DamageAngel extends Angel {
    public DamageAngel(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
    }

    @Override
    public void interact(Player player) {
        float modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 0.15f;
                break;
            case "Pyromancer":
                modifier = 0.2f;
                break;
            case "Rogue":
                modifier = 0.3f;
                break;
            case "Wizard":
                modifier = 0.4f;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
    }
}
