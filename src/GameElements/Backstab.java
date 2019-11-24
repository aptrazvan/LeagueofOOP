package GameElements;

public class Backstab implements Ability {
    private int boostLevel = 0;
    float boostTerrain = 0;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round((200 + 20 * boostLevel) * boostTerrain * (125.0f / 100)));
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round((200 + 20 * boostLevel) * boostTerrain * (90.0f / 100)));
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
        wizard.takeDamage(Math.round((200 + 20 * boostLevel) * boostTerrain * (125.0f / 100)));
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round((200 + 20 * boostLevel) * boostTerrain * (120.0f / 100)));
    }

    @Override
    public void levelUp() {
        boostLevel++;
    }

    @Override
    public void setBoostTerrain(Player player) {
        if (Map.getInstance().getTerrainType(player.getPosition()[0], player.getPosition()[1]).equals("W")) {
            boostTerrain = 115.0f / 100;
        }
        else {
            boostTerrain = 1;
        }
    }
}
