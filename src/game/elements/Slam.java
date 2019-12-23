package game.elements;

import static game.elements.Constants.LAND_BOOST;
import static game.elements.Constants.SLAM_BASE_DAMAGE;
import static game.elements.Constants.SLAM_BOOST_DAMAGE;
import static game.elements.Constants.SLAM_KNIGHT_MODIFIER;
import static game.elements.Constants.SLAM_PYROMANCER_MODIFIER;
import static game.elements.Constants.SLAM_ROGUE_MODIFIER;
import static game.elements.Constants.SLAM_WIZARD_MODIFIER;

public final class Slam implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((SLAM_BASE_DAMAGE + SLAM_BOOST_DAMAGE * boostLevel)
                * boostTerrain * SLAM_PYROMANCER_MODIFIER * damageModifier));
        pyromancer.addEffect(1, 1, 0);
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((SLAM_BASE_DAMAGE + SLAM_BOOST_DAMAGE * boostLevel)
                * boostTerrain * SLAM_KNIGHT_MODIFIER * damageModifier));
        knight.addEffect(1, 1, 0);
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((SLAM_BASE_DAMAGE + SLAM_BOOST_DAMAGE * boostLevel)
                * boostTerrain * SLAM_WIZARD_MODIFIER * damageModifier));
        wizard.addEffect(1, 1, 0);
        wizard.addDamageReceived(Math.round((SLAM_BASE_DAMAGE + SLAM_BOOST_DAMAGE * boostLevel)
                * boostTerrain));
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((SLAM_BASE_DAMAGE + SLAM_BOOST_DAMAGE * boostLevel)
                * boostTerrain * SLAM_ROGUE_MODIFIER * damageModifier));
        rogue.addEffect(1, 1, 0);
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(final Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0],
                player.getPosition()[1]).equals("L")) {
            boostTerrain = LAND_BOOST;
        } else {
            boostTerrain = 1;
        }
    }

    @Override
    public void setDamageModifier(float modifier) {
        damageModifier = modifier;
    }
}
