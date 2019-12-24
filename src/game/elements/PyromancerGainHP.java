package game.elements;

import static game.elements.Constants.PYROMANCER_SECOND_DAMAGE_MODIFIER;
import static game.elements.Constants.PYROMANCER_SECOND_HEALTH_MODIFIER;

public class PyromancerGainHP implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.gainHP(Math.round(PYROMANCER_SECOND_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(PYROMANCER_SECOND_HEALTH_MODIFIER);
    }
}
