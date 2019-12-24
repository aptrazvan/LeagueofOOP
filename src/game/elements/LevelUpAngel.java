package game.elements;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "LevelUpAngel";
    }

    @Override
    public final void interact(final Player player) {
        float modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = 0.1f;
                break;
            case "Pyromancer":
                modifier = 0.2f;
                break;
            case "Rogue":
                modifier = 0.15f;
                break;
            case "Wizard":
                modifier = 0.25f;
                break;
            default:
                break;
        }

        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
        player.gainXP(XPTable.getInstance().getTable().get(player.getLevel() + 1)
                - player.getXP());
        player.levelUp();
        player.addDamageModifier(modifier);

    }
}
