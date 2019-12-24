package game.elements;

import static game.elements.Constants.WIZARD_SECOND_DAMAGE_MODIFIER;
import static game.elements.Constants.WIZARD_SECOND_HEALTH_MODIFIER;

public class WizardGainHP implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.gainHP(Math.round(WIZARD_SECOND_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(WIZARD_SECOND_HEALTH_MODIFIER);
    }
}
