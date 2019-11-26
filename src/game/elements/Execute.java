package game.elements;

import static game.elements.Constants.EXECUTE_BASE_DAMAGE1;
import static game.elements.Constants.EXECUTE_BASE_DAMAGE2;
import static game.elements.Constants.EXECUTE_BOOST_DAMAGE;
import static game.elements.Constants.EXECUTE_KNIGHT_MODIFIER;
import static game.elements.Constants.EXECUTE_PYROMANCER_MODIFIER;
import static game.elements.Constants.EXECUTE_ROGUE_MODIFIER;
import static game.elements.Constants.EXECUTE_WIZARD_MODIFIER;
import static game.elements.Constants.LAND_BOOST;
import static game.elements.Constants.MAX_EXECUTE;
import static game.elements.Constants.PERCENT;

public final class Execute implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;

    @Override
    public void target(final Player player) {

    }

    @Override
    public void target(final Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);

        if (pyromancer.getHP() < Math.min((EXECUTE_BASE_DAMAGE1 + boostLevel), MAX_EXECUTE)
                / PERCENT * (pyromancer.getMaxHP())) {
            pyromancer.takeDamage(pyromancer.getHP());
        } else {
            pyromancer.takeDamage(Math.round((EXECUTE_BASE_DAMAGE2 + EXECUTE_BOOST_DAMAGE
                    * boostLevel) * boostTerrain * EXECUTE_PYROMANCER_MODIFIER));
        }
    }

    @Override
    public void target(final Knight knight) {
        setBoostTerrain(knight);

        if (knight.getHP() < Math.min((EXECUTE_BASE_DAMAGE1 + boostLevel), MAX_EXECUTE)
                / PERCENT * (knight.getMaxHP())) {
            knight.takeDamage(knight.getHP());
        } else {
            knight.takeDamage(Math.round((EXECUTE_BASE_DAMAGE2 + EXECUTE_BOOST_DAMAGE
                    * boostLevel) * boostTerrain * EXECUTE_KNIGHT_MODIFIER));
        }
    }

    @Override
    public void target(final Wizard wizard) {
        setBoostTerrain(wizard);

        if (wizard.getHP() < Math.min((EXECUTE_BASE_DAMAGE1 + boostLevel), MAX_EXECUTE)
                / PERCENT * (wizard.getMaxHP())) {
            wizard.setDamageReceived(wizard.getHP());
            wizard.takeDamage(wizard.getHP());
        } else {
            wizard.takeDamage(Math.round((EXECUTE_BASE_DAMAGE2 + EXECUTE_BOOST_DAMAGE
                    * boostLevel) * boostTerrain * EXECUTE_WIZARD_MODIFIER));
            wizard.setDamageReceived(Math.round((EXECUTE_BASE_DAMAGE2 + EXECUTE_BOOST_DAMAGE
                    * boostLevel) * boostTerrain));
        }
    }

    @Override
    public void target(final Rogue rogue) {
        setBoostTerrain(rogue);

        if (rogue.getHP() < Math.min((EXECUTE_BASE_DAMAGE1 + boostLevel), MAX_EXECUTE)
                / PERCENT * (rogue.getMaxHP())) {
            rogue.takeDamage(rogue.getHP());
        } else {
            rogue.takeDamage(Math.round((EXECUTE_BASE_DAMAGE2 + EXECUTE_BOOST_DAMAGE * boostLevel)
                    * boostTerrain * EXECUTE_ROGUE_MODIFIER));
        }
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
}
