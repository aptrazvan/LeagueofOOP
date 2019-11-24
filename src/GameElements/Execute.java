package GameElements;

public class Execute implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (110.0f / 100)));
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (100.0f / 100)));
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (80.0f / 100)));
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (115.0f / 100)));
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
