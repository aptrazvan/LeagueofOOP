package game.elements;

import static game.elements.Constants.FIREBLAST_BASE_DAMAGE;
import static game.elements.Constants.FIREBLAST_BOOST_DAMAGE;
import static game.elements.Constants.FIREBLAST_KNIGHT_MODIFIER;
import static game.elements.Constants.FIREBLAST_PYROMANCER_MODIFIER;
import static game.elements.Constants.FIREBLAST_ROGUE_MODIFIER;
import static game.elements.Constants.FIREBLAST_WIZARD_MODIFIER;
import static game.elements.Constants.VOLCANO_BOOST;

public final class Fireblast implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((FIREBLAST_BASE_DAMAGE
                + FIREBLAST_BOOST_DAMAGE * boostLevel)
                * boostTerrain * FIREBLAST_PYROMANCER_MODIFIER * damageModifier));
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((FIREBLAST_BASE_DAMAGE + FIREBLAST_BOOST_DAMAGE * boostLevel)
                * boostTerrain * FIREBLAST_KNIGHT_MODIFIER * damageModifier));
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((FIREBLAST_BASE_DAMAGE + FIREBLAST_BOOST_DAMAGE * boostLevel)
                * boostTerrain * FIREBLAST_WIZARD_MODIFIER * damageModifier));
        wizard.setDamageReceived(Math.round((FIREBLAST_BASE_DAMAGE + FIREBLAST_BOOST_DAMAGE
                * boostLevel) * boostTerrain));
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((FIREBLAST_BASE_DAMAGE + FIREBLAST_BOOST_DAMAGE * boostLevel)
                * boostTerrain * FIREBLAST_ROGUE_MODIFIER * damageModifier));
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(final Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0],
                player.getPosition()[1]).equals("V")) {
            boostTerrain = VOLCANO_BOOST;
        } else {
            boostTerrain = 1;
        }
    }

    @Override
    public void setDamageModifier(float modifier) {
        damageModifier = modifier;
    }
}
