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
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
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
