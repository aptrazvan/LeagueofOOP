package GameElements;

public class Drain implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((20.0f + 5 * boostLevel) / 100 * Math.min(0.3f * pyromancer.getMaxHP(), pyromancer.getHP()) * boostTerrain * (90.0f / 100)));
        System.out.println((20.0f + 5 * boostLevel) / 100 * Math.min(0.3f * pyromancer.getMaxHP(), pyromancer.getHP()) * boostTerrain * (90.0f / 100));
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((20.0f + 5 * boostLevel) / 100 * Math.min(0.3f * knight.getMaxHP(), knight.getHP()) * boostTerrain * (120.0f / 100)));
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((20.0f + 5 * boostLevel) / 100 * Math.min(0.3f * wizard.getMaxHP(), wizard.getHP()) * boostTerrain * (105.0f / 100)));
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((20.0f + 5 * boostLevel) / 100 * Math.min(0.3f * rogue.getMaxHP(), rogue.getHP()) * boostTerrain * (80.0f / 100)));
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0], player.getPosition()[1]).equals("D")) {
            boostTerrain = 110.0f / 100;
        }
        else {
            boostTerrain = 1;
        }
    }
}
