package game.elements;

import static game.elements.Constants.WIZARD_FIRST_DAMAGE_MODIFIER;
import static game.elements.Constants.WIZARD_FIRST_HEALTH_MODIFIER;

public class WizardGainDamage implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.takeDamage(Math.round(WIZARD_FIRST_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(WIZARD_FIRST_HEALTH_MODIFIER);
    }
}
