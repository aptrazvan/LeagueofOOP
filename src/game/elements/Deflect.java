package game.elements;

import static game.elements.Constants.DEFLECT_BASE_DAMAGE;
import static game.elements.Constants.DEFLECT_KNIGHT_MODIFIER;
import static game.elements.Constants.DEFLECT_PYROMANCER_MODIFIER;
import static game.elements.Constants.DEFLECT_ROGUE_MODIFIER;
import static game.elements.Constants.DESERT_BOOST;
import static game.elements.Constants.MAX_DEFLECT;
import static game.elements.Constants.PERCENT;

public final class Deflect implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damageReceived;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round(Math.min(DEFLECT_BASE_DAMAGE / PERCENT
                + 2.0f / PERCENT * boostLevel, MAX_DEFLECT / PERCENT)
                * damageReceived * boostTerrain * (DEFLECT_PYROMANCER_MODIFIER
                - 1 + damageModifier)));
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round(Math.min(DEFLECT_BASE_DAMAGE + 2 * boostLevel, MAX_DEFLECT)
                / PERCENT * damageReceived * boostTerrain
                * (DEFLECT_KNIGHT_MODIFIER - 1 + damageModifier)));
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round(Math.min(DEFLECT_BASE_DAMAGE + 2 * boostLevel, MAX_DEFLECT)
                / PERCENT * damageReceived * boostTerrain
                * (DEFLECT_ROGUE_MODIFIER - 1 + damageModifier)));

    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(final Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0],
                player.getPosition()[1]).equals("D")) {
            boostTerrain = DESERT_BOOST;
        } else {
            boostTerrain = 1;
        }
    }

    public void setDamage(final int damage) {
        damageReceived = damage;
    }

    @Override
    public void setDamageModifier(final float modifier) {
        damageModifier = modifier;
    }
}
