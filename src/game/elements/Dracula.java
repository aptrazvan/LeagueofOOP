package game.elements;

import static game.elements.Constants.ANGEL_HIT_STATE;
import static game.elements.Constants.ANGEL_KILL_STATE;
import static game.elements.Constants.DRACULA_KNIGHT_DAMAGE_MODIFIER;
import static game.elements.Constants.DRACULA_KNIGHT_HEALTH_MODIFIER;
import static game.elements.Constants.DRACULA_PYROMANCER_DAMAGE_MODIFIER;
import static game.elements.Constants.DRACULA_PYROMANCER_HEALTH_MODIFIER;
import static game.elements.Constants.DRACULA_ROGUE_DAMAGE_MODIFIER;
import static game.elements.Constants.DRACULA_ROGUE_HEALTH_MODIFIER;
import static game.elements.Constants.DRACULA_WIZARD_DAMAGE_MODIFIER;
import static game.elements.Constants.DRACULA_WIZARD_HEALTH_MODIFIER;

public class Dracula extends Angel {
    public Dracula(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "Dracula";
    }

    @Override
    public final void interact(final Player player) {
        float modifier = 0;
        int healthModifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = DRACULA_KNIGHT_DAMAGE_MODIFIER;
                healthModifier = DRACULA_KNIGHT_HEALTH_MODIFIER;
                break;
            case "Pyromancer":
                modifier = DRACULA_PYROMANCER_DAMAGE_MODIFIER;
                healthModifier = DRACULA_PYROMANCER_HEALTH_MODIFIER;
                break;
            case "Rogue":
                modifier = DRACULA_ROGUE_DAMAGE_MODIFIER;
                healthModifier = DRACULA_ROGUE_HEALTH_MODIFIER;
                break;
            case "Wizard":
                modifier = DRACULA_WIZARD_DAMAGE_MODIFIER;
                healthModifier = DRACULA_WIZARD_HEALTH_MODIFIER;
                break;
            default:
                break;
        }

        player.addDamageModifier(modifier);
        player.takeDamage(healthModifier);
        Subject.getInstance().setState(ANGEL_HIT_STATE, angelClass, player.getHeroClass(),
                0, player.getId());

        if (player.getHP() <= 0) {
            Subject.getInstance().setState(ANGEL_KILL_STATE, player.getHeroClass(), null,
                    player.getId(), 0);
        }
    }
}
