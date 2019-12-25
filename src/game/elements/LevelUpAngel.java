package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.LEVEL_UP_ANGEL_KNIGHT_MODIFIER;
import static game.elements.Constants.LEVEL_UP_ANGEL_PYROMANCER_MODIFIER;
import static game.elements.Constants.LEVEL_UP_ANGEL_ROGUE_MODIFIER;
import static game.elements.Constants.LEVEL_UP_ANGEL_WIZARD_MODIFIER;

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
                modifier = LEVEL_UP_ANGEL_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = LEVEL_UP_ANGEL_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = LEVEL_UP_ANGEL_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = LEVEL_UP_ANGEL_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
        player.gainXP(XPTable.getInstance().getTable().get(player.getLevel() + 1)
                - player.getXP());
        player.levelUp();
        player.addDamageModifier(modifier);

    }
}
