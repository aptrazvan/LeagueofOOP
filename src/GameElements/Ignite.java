package GameElements;

public class Ignite implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damage = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((150 + 20 * boostLevel) * boostTerrain * (90.0f / 100)));
        damage = Math.round((50 + 30 * boostLevel) * boostTerrain * (90.0f / 100));
        pyromancer.addEffect(0, 2, damage);
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((150 + 20 * boostLevel) * boostTerrain * (120.0f / 100)));
        damage = Math.round((50 + 30 * boostLevel) * boostTerrain * (120.0f / 100));
        knight.addEffect(0, 2, damage);
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((150 + 20 * boostLevel) * boostTerrain * (105.0f / 100)));
        damage = Math.round((50 + 30 * boostLevel) * boostTerrain * (105.0f / 100));
        wizard.addEffect(0, 2, damage);
        wizard.addDamageReceived(Math.round((150 + 20 * boostLevel) * boostTerrain));
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((150 + 20 * boostLevel) * boostTerrain * (80.0f / 100)));
        damage = Math.round((50 + 30 * boostLevel) * boostTerrain * (80.0f / 100));
        rogue.addEffect(0, 2, damage);
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0], player.getPosition()[1]).equals("V")) {
            boostTerrain = 125.0f / 100;
        }
        else {
            boostTerrain = 1;
        }
    }
}
