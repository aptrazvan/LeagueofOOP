package game.elements;

import static game.elements.Constants.KNIGHT_SECOND_DAMAGE_MODIFIER;
import static game.elements.Constants.KNIGHT_SECOND_HEALTH_MODIFIER;

public class KnightGainHP implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.gainHP(Math.round(KNIGHT_SECOND_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(KNIGHT_SECOND_HEALTH_MODIFIER);
    }
}
