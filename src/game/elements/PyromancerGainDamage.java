package game.elements;

import static game.elements.Constants.PYROMANCER_FIRST_DAMAGE_MODIFIER;
import static game.elements.Constants.PYROMANCER_FIRST_HEALTH_MODIFIER;

public class PyromancerGainDamage implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.takeDamage(Math.round(PYROMANCER_FIRST_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(PYROMANCER_FIRST_HEALTH_MODIFIER);
    }
}
