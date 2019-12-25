package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.GOOD_BOY_KNIGHT_DAMAGE_MODIFIER;
import static game.elements.Constants.GOOD_BOY_KNIGHT_HEALTH_MODIFIER;
import static game.elements.Constants.GOOD_BOY_PYROMANCER_DAMAGE_MODIFIER;
import static game.elements.Constants.GOOD_BOY_PYROMANCER_HEALTH_MODIFIER;
import static game.elements.Constants.GOOD_BOY_ROGUE_DAMAGE_MODIFIER;
import static game.elements.Constants.GOOD_BOY_ROGUE_HEALTH_MODIFIER;
import static game.elements.Constants.GOOD_BOY_WIZARD_DAMAGE_MODIFIER;
import static game.elements.Constants.GOOD_BOY_WIZARD_HEALTH_MODIFIER;

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
                modifier = GOOD_BOY_KNIGHT_DAMAGE_MODIFIER;
                healthModifier = GOOD_BOY_KNIGHT_HEALTH_MODIFIER;
                break;
            case "Pyromancer":
                modifier = GOOD_BOY_PYROMANCER_DAMAGE_MODIFIER;
                healthModifier = GOOD_BOY_PYROMANCER_HEALTH_MODIFIER;
                break;
            case "Rogue":
                modifier = GOOD_BOY_ROGUE_DAMAGE_MODIFIER;
                healthModifier = GOOD_BOY_ROGUE_HEALTH_MODIFIER;
                break;
            case "Wizard":
                modifier = GOOD_BOY_WIZARD_DAMAGE_MODIFIER;
                healthModifier = GOOD_BOY_WIZARD_HEALTH_MODIFIER;
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
