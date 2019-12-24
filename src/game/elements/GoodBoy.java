package game.elements;

public class GoodBoy extends Angel {
    public GoodBoy(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "GoodBoy";
    }

    @Override
    public final void interact(final Player player) {
        float modifier = 0;
        int healthModifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 0.4f;
                healthModifier = 20;
                break;
            case "Pyromancer":
                modifier = 0.5f;
                healthModifier = 30;
                break;
            case "Rogue":
                modifier = 0.4f;
                healthModifier = 40;
                break;
            case "Wizard":
                modifier = 0.3f;
                healthModifier = 50;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        player.gainHP(healthModifier);
        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
