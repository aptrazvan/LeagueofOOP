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

        if (pyromancer.getHP() < Math.min((20.0f + boostLevel), 40.0f) / 100 * (pyromancer.getMaxHP())) {
            pyromancer.takeDamage(pyromancer.getHP());
        }
        else {
            pyromancer.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (110.0f / 100)));
        }
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);

        if (knight.getHP() < Math.min((20.0f + boostLevel), 40.0f) / 100 * (knight.getMaxHP())) {
            knight.takeDamage(knight.getHP());
        }
        else {
            knight.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (100.0f / 100)));
        }
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);

        if (wizard.getHP() < Math.min((20.0f + boostLevel), 40.0f) / 100 * (wizard.getMaxHP())) {
            wizard.setDamageReceived(wizard.getHP());
            wizard.takeDamage(wizard.getHP());
        }
        else {
            wizard.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (80.0f / 100)));
            wizard.setDamageReceived(Math.round((200 + 30 * boostLevel) * boostTerrain));
        }
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);

        if (rogue.getHP() < Math.min((20.0f + boostLevel), 40.0f) / 100 * (rogue.getMaxHP())) {
            rogue.takeDamage(rogue.getHP());
        }
        else {
            rogue.takeDamage(Math.round((200 + 30 * boostLevel) * boostTerrain * (115.0f / 100)));
        }
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
