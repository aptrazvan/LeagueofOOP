package game.elements;

import static game.elements.Constants.KNIGHT_FIRST_DAMAGE_MODIFIER;
import static game.elements.Constants.KNIGHT_FIRST_HEALTH_MODIFIER;

public class KnightGainDamage implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.takeDamage(Math.round(KNIGHT_FIRST_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(KNIGHT_FIRST_HEALTH_MODIFIER);
    }
}
