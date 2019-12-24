package game.elements;

public class DamageAngel extends Angel {
    public DamageAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "DamageAngel";
    }

    @Override
    public final void interact(final Player player) {
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
        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
