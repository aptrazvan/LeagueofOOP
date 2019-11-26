package GameElements;

public class Deflect implements Ability {
    private int boostLevel = 0;
    private float boostTerrain = 0;
    private int damageReceived;

    @Override
    public void target(Player player) {

    }

    @Override
    public void target(Pyromancer pyromancer) {
        setBoostTerrain(pyromancer);
        pyromancer.takeDamage(Math.round(Math.min(0.35f + 0.02f * boostLevel, 0.7f) * damageReceived * boostTerrain * 1.3f));
        System.out.println((Math.min(35.0f + 2.0f * (float)boostLevel, 70.0f) / 100.0f * (float)damageReceived * (float)boostTerrain * 130.0f / 100.0f));
    }

    @Override
    public void target(Knight knight) {
        setBoostTerrain(knight);
        knight.takeDamage(Math.round(Math.min(35.0f + 2 * boostLevel, 70.0f) / 100 * damageReceived * boostTerrain * 140.0f / 100));
    }

    @Override
    public void target(Wizard wizard) {
        setBoostTerrain(wizard);
    }

    @Override
    public void target(Rogue rogue) {
        setBoostTerrain(rogue);
        rogue.takeDamage(Math.round(Math.min(35.0f + 2 * boostLevel, 70.0f) / 100 * damageReceived * boostTerrain * 120.0f / 100));

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

    public void setDamage (int damage) {
        damageReceived = damage;
    }
}
