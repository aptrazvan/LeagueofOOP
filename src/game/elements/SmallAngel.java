package game.elements;

public class SmallAngel extends Angel {
    public SmallAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "SmallAngel";
    }

    @Override
    public final void interact(final Player player) {
        float modifier = 0;
        int healthModifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 0.1f;
                healthModifier = 10;
                break;
            case "Pyromancer":
                modifier = 0.15f;
                healthModifier = 15;
                break;
            case "Rogue":
                modifier = 0.05f;
                healthModifier = 20;
                break;
            case "Wizard":
                modifier = 0.1f;
                healthModifier = 25;
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
