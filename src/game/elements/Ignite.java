package game.elements;

import static game.elements.Constants.IGNITE_BASE_DAMAGE;
import static game.elements.Constants.IGNITE_BOOST_DAMAGE;
import static game.elements.Constants.IGNITE_DURATION;
import static game.elements.Constants.IGNITE_EFFECT_BOOST;
import static game.elements.Constants.IGNITE_EFFECT_DAMAGE;
import static game.elements.Constants.IGNITE_KNIGHT_MODIFIER;
import static game.elements.Constants.IGNITE_PYROMANCER_MODIFIER;
import static game.elements.Constants.IGNITE_ROGUE_MODIFIER;
import static game.elements.Constants.IGNITE_WIZARD_MODIFIER;
import static game.elements.Constants.VOLCANO_BOOST;

public final class Ignite implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damage = 0;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((IGNITE_BASE_DAMAGE + IGNITE_BOOST_DAMAGE
                * boostLevel) * boostTerrain * IGNITE_PYROMANCER_MODIFIER * damageModifier));
        damage = Math.round((IGNITE_EFFECT_DAMAGE + IGNITE_EFFECT_BOOST * boostLevel)
                * boostTerrain * IGNITE_PYROMANCER_MODIFIER * damageModifier);
        pyromancer.addEffect(0, IGNITE_DURATION, damage);
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((IGNITE_BASE_DAMAGE + IGNITE_BOOST_DAMAGE * boostLevel)
                * boostTerrain * IGNITE_KNIGHT_MODIFIER * damageModifier));
        damage = Math.round((IGNITE_EFFECT_DAMAGE + IGNITE_EFFECT_BOOST * boostLevel)
                * boostTerrain * IGNITE_KNIGHT_MODIFIER * damageModifier);
        knight.addEffect(0, IGNITE_DURATION, damage);
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((IGNITE_BASE_DAMAGE + IGNITE_BOOST_DAMAGE * boostLevel)
                * boostTerrain * IGNITE_WIZARD_MODIFIER * damageModifier));
        damage = Math.round((IGNITE_EFFECT_DAMAGE + IGNITE_EFFECT_BOOST * boostLevel)
                * boostTerrain * IGNITE_WIZARD_MODIFIER * damageModifier);
        wizard.addEffect(0, IGNITE_DURATION, damage);
        wizard.addDamageReceived(Math.round((IGNITE_BASE_DAMAGE + IGNITE_BOOST_DAMAGE
                * boostLevel) * boostTerrain));
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((IGNITE_BASE_DAMAGE + IGNITE_BOOST_DAMAGE * boostLevel)
                * boostTerrain * IGNITE_ROGUE_MODIFIER * damageModifier));
        damage = Math.round((IGNITE_EFFECT_DAMAGE + IGNITE_EFFECT_BOOST * boostLevel)
                * boostTerrain * IGNITE_ROGUE_MODIFIER * damageModifier);
        rogue.addEffect(0, IGNITE_DURATION, damage);
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
