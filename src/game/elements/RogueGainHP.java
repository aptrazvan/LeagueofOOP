package game.elements;

import static game.elements.Constants.ROGUE_SECOND_DAMAGE_MODIFIER;
import static game.elements.Constants.ROGUE_SECOND_HEALTH_MODIFIER;

public class RogueGainHP implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.gainHP(Math.round(ROGUE_SECOND_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(ROGUE_SECOND_HEALTH_MODIFIER);
    }
}
