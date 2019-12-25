package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.DAMAGE_ANGEL_KNIGHT_MODIFIER;
import static game.elements.Constants.DAMAGE_ANGEL_PYROMANCER_MODIFIER;
import static game.elements.Constants.DAMAGE_ANGEL_ROGUE_MODIFIER;
import static game.elements.Constants.DAMAGE_ANGEL_WIZARD_MODIFIER;

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
                modifier = DAMAGE_ANGEL_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = DAMAGE_ANGEL_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = DAMAGE_ANGEL_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = DAMAGE_ANGEL_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
