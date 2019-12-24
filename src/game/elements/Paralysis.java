package game.elements;

import static game.elements.Constants.PARALYSIS_BASE_DAMAGE;
import static game.elements.Constants.PARALYSIS_BOOST_DAMAGE;
import static game.elements.Constants.PARALYSIS_DURATION;
import static game.elements.Constants.PARALYSIS_DURATION_WOODS;
import static game.elements.Constants.PARALYSIS_KNIGHT_MODIFIER;
import static game.elements.Constants.PARALYSIS_PYROMANCER_MODIFIER;
import static game.elements.Constants.PARALYSIS_ROGUE_MODIFIER;
import static game.elements.Constants.PARALYSIS_WIZARD_MODIFIER;
import static game.elements.Constants.WOODS_BOOST;

public final class Paralysis implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damage = 0;
    private int overtime = 0;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        damage = Math.round((PARALYSIS_BASE_DAMAGE + PARALYSIS_BOOST_DAMAGE * boostLevel)
                * boostTerrain * (PARALYSIS_PYROMANCER_MODIFIER - 1 + damageModifier));
        pyromancer.takeDamage(damage);
        pyromancer.addEffect(2, overtime, damage);
        pyromancer.addEffect(1, overtime, 0);
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        damage = Math.round((PARALYSIS_BASE_DAMAGE + PARALYSIS_BOOST_DAMAGE * boostLevel)
                * boostTerrain * (PARALYSIS_KNIGHT_MODIFIER - 1 + damageModifier));
        knight.takeDamage(damage);
        knight.addEffect(2, overtime, damage);
        knight.addEffect(1, overtime, 0);

    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        damage = Math.round((PARALYSIS_BASE_DAMAGE + PARALYSIS_BOOST_DAMAGE * boostLevel)
                * boostTerrain * (PARALYSIS_WIZARD_MODIFIER - 1 + damageModifier));
        wizard.takeDamage(damage);
        wizard.addEffect(2, overtime, damage);
        wizard.addEffect(1, overtime, 0);
        wizard.addDamageReceived(Math.round((PARALYSIS_BASE_DAMAGE + PARALYSIS_BOOST_DAMAGE
                * boostLevel) * boostTerrain));

    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        damage = Math.round((PARALYSIS_BASE_DAMAGE + PARALYSIS_BOOST_DAMAGE * boostLevel)
                * boostTerrain * (PARALYSIS_ROGUE_MODIFIER - 1 + damageModifier));
        rogue.takeDamage(damage);
        rogue.addEffect(2, overtime, damage);
        rogue.addEffect(1, overtime, 0);

    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(final Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0],
                player.getPosition()[1]).equals("W")) {
            boostTerrain = WOODS_BOOST;
            overtime = PARALYSIS_DURATION_WOODS;
        } else {
            boostTerrain = 1;
            overtime = PARALYSIS_DURATION;
        }
    }

    @Override
    public void setDamageModifier(float modifier) {
        damageModifier = modifier;
    }
}
