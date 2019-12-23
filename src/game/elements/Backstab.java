package game.elements;

import static game.elements.Constants.BACKSTAB_BASE_DAMAGE;
import static game.elements.Constants.BACKSTAB_BOOST_DAMAGE;
import static game.elements.Constants.BACKSTAB_KNIGHT_MODIFIER;
import static game.elements.Constants.BACKSTAB_PYROMANCER_MODIFIER;
import static game.elements.Constants.BACKSTAB_ROGUE_MODIFIER;
import static game.elements.Constants.BACKSTAB_WIZARD_MODIFIER;
import static game.elements.Constants.CRITICAL_BOOST;
import static game.elements.Constants.CRITICAL_HIT_NUMBER;
import static game.elements.Constants.MULTIPLIER;
import static game.elements.Constants.WOODS_BOOST;

public final class Backstab implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int abilityCounter = 2;
    private float damageModifier = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((BACKSTAB_BASE_DAMAGE + BACKSTAB_BOOST_DAMAGE
                * boostLevel) * boostTerrain * BACKSTAB_PYROMANCER_MODIFIER * damageModifier));
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((BACKSTAB_BASE_DAMAGE + BACKSTAB_BOOST_DAMAGE
                * boostLevel) * boostTerrain * BACKSTAB_KNIGHT_MODIFIER * damageModifier));
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((BACKSTAB_BASE_DAMAGE + BACKSTAB_BOOST_DAMAGE * boostLevel)
                * boostTerrain * BACKSTAB_WIZARD_MODIFIER * damageModifier));
        wizard.setDamageReceived(Math.round((BACKSTAB_BASE_DAMAGE + BACKSTAB_BOOST_DAMAGE
                * boostLevel) * boostTerrain));
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((BACKSTAB_BASE_DAMAGE + BACKSTAB_BOOST_DAMAGE * boostLevel)
                * boostTerrain * BACKSTAB_ROGUE_MODIFIER * damageModifier));
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(final Player player) {
        abilityCounter++;

        if (Map.getInstance().getTerrainType(player.getPosition()[0],
                player.getPosition()[1]).equals("W")) {
            boostTerrain = WOODS_BOOST;

            if (abilityCounter == CRITICAL_HIT_NUMBER) {
                boostTerrain *= CRITICAL_BOOST;
                boostTerrain = (float) Math.round(boostTerrain * MULTIPLIER) / MULTIPLIER;
                abilityCounter = 0;
            }
        } else {
            boostTerrain = 1;
        }

        if (abilityCounter == CRITICAL_HIT_NUMBER) {
            abilityCounter = 0;
        }
    }

    @Override
    public void setDamageModifier(float modifier) {
        damageModifier = modifier;
    }
}
