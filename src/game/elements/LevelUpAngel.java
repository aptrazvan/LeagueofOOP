package game.elements;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(int round, int positionX, int positionY) {
        super(round, positionX, positionY);
        angelClass = "LevelUpAngel";
    }

    @Override
    public void interact(Player player) {
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

        player.gainXP(XPTable.getInstance().getTable().get(player.getLevel() + 1) - player.getXP());
        player.levelUp();
        player.addDamageModifier(modifier);
        Subject.getInstance().setState(3, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
