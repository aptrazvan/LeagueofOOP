package GameElements;

public class Paralysis implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damage = 0;
    private int overtime = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        damage = Math.round((40 + 10 * boostLevel) * boostTerrain * (120.0f / 100));
        pyromancer.takeDamage(damage);
        pyromancer.addEffect(0, overtime, damage);
        pyromancer.addEffect(1, overtime, 0);
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        damage = Math.round((40 + 10 * boostLevel) * boostTerrain * (80.0f / 100));
        knight.takeDamage(damage);
        knight.addEffect(0, overtime, damage);
        knight.addEffect(1, overtime, 0);

    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        damage = Math.round((40 + 10 * boostLevel) * boostTerrain * (125.0f / 100));
        wizard.takeDamage(damage);
        wizard.addEffect(0, overtime, damage);
        wizard.addEffect(1, overtime, 0);

    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        damage = Math.round((40 + 10 * boostLevel) * boostTerrain * (90.0f / 100));
        rogue.takeDamage(damage);
        rogue.addEffect(0, overtime, damage);
        rogue.addEffect(1, overtime, 0);

    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0], player.getPosition()[1]).equals("W")) {
            boostTerrain = 115.0f / 100;
            overtime = 6;
        }
        else {
            boostTerrain = 1;
            overtime = 3;
        }
    }
}
