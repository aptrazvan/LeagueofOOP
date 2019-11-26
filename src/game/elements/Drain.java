package game.elements;

import static game.elements.Constants.COEFFICIENT1;
import static game.elements.Constants.DESERT_BOOST;
import static game.elements.Constants.DRAIN_BASE_DAMAGE;
import static game.elements.Constants.DRAIN_BOOST_DAMAGE;
import static game.elements.Constants.DRAIN_KNIGHT_MODIFIER;
import static game.elements.Constants.DRAIN_PYROMANCER_MODIFIER;
import static game.elements.Constants.DRAIN_ROGUE_MODIFIER;
import static game.elements.Constants.DRAIN_WIZARD_MODIFIER;
import static game.elements.Constants.PERCENT;

public final class Drain implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((DRAIN_BASE_DAMAGE  + DRAIN_BOOST_DAMAGE * boostLevel)
                / PERCENT * Math.min(COEFFICIENT1 * pyromancer.getMaxHP(), pyromancer.getHP())
                * boostTerrain * DRAIN_PYROMANCER_MODIFIER));
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((DRAIN_BASE_DAMAGE + DRAIN_BOOST_DAMAGE * boostLevel)
                / PERCENT * Math.min(COEFFICIENT1 * knight.getMaxHP(), knight.getHP())
                * boostTerrain * DRAIN_KNIGHT_MODIFIER));
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((DRAIN_BASE_DAMAGE + DRAIN_BOOST_DAMAGE * boostLevel)
                / PERCENT * Math.min(COEFFICIENT1 * wizard.getMaxHP(), wizard.getHP())
                * boostTerrain * DRAIN_WIZARD_MODIFIER));
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((DRAIN_BASE_DAMAGE + DRAIN_BOOST_DAMAGE * boostLevel)
                / PERCENT * Math.min(COEFFICIENT1 * rogue.getMaxHP(), rogue.getHP())
                * boostTerrain * DRAIN_ROGUE_MODIFIER));
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
}
