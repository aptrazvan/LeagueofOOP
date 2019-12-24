package game.elements;

public class KnightGainDamage implements Strategy {
    @Override
    public void setStats(Player player) {
        player.takeDamage(Math.round((float)1 / 5 * player.getHP()));
        player.addDamageModifier(0.5f);
    }
}
