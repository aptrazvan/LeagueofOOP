package game.elements;

import static game.elements.Constants.ROGUE_FIRST_DAMAGE_MODIFIER;
import static game.elements.Constants.ROGUE_FIRST_HEALTH_MODIFIER;

public class RogueGainDamage implements Strategy {
    @Override
    public final void setStats(final Player player) {
        player.takeDamage(Math.round(ROGUE_FIRST_DAMAGE_MODIFIER * player.getHP()));
        player.addDamageModifier(ROGUE_FIRST_HEALTH_MODIFIER);
    }
}
