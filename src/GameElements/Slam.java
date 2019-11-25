package GameElements;

public class Slam implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((100 + 40 * boostLevel) * boostTerrain * (90.0f / 100)));
        pyromancer.addEffect(1, 1, 0);
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((100 + 40 * boostLevel) * boostTerrain * (120.0f / 100)));
        knight.addEffect(1, 1, 0);
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((100 + 40 * boostLevel) * boostTerrain * (105.0f / 100)));
        wizard.addEffect(1, 1, 0);
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((100 + 40 * boostLevel) * boostTerrain * (80.0f / 100)));
        rogue.addEffect(1, 1, 0);
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0], player.getPosition()[1]).equals("L")) {
            boostTerrain = 115.0f / 100;
        }
        else {
            boostTerrain = 1;
        }
    }
}