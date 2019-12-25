package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.SMALL_ANGEL_KNIGHT_DAMAGE_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_KNIGHT_HEALTH_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_PYROMANCER_DAMAGE_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_PYROMANCER_HEALTH_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_ROGUE_DAMAGE_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_ROGUE_HEALTH_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_WIZARD_DAMAGE_MODIFIER;
import static game.elements.Constants.SMALL_ANGEL_WIZARD_HEALTH_MODIFIER;

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
                modifier = SMALL_ANGEL_KNIGHT_DAMAGE_MODIFIER;
                healthModifier = SMALL_ANGEL_KNIGHT_HEALTH_MODIFIER;
                break;
            case "Pyromancer":
                modifier = SMALL_ANGEL_PYROMANCER_DAMAGE_MODIFIER;
                healthModifier = SMALL_ANGEL_PYROMANCER_HEALTH_MODIFIER;
                break;
            case "Rogue":
                modifier = SMALL_ANGEL_ROGUE_DAMAGE_MODIFIER;
                healthModifier = SMALL_ANGEL_ROGUE_HEALTH_MODIFIER;
                break;
            case "Wizard":
                modifier = SMALL_ANGEL_WIZARD_DAMAGE_MODIFIER;
                healthModifier = SMALL_ANGEL_WIZARD_HEALTH_MODIFIER;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        player.gainHP(healthModifier);
        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
