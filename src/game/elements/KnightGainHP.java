package game.elements;

public class KnightGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1 / 4 * player.getHP()));
        player.setDamageModifier(0.8f);
    }
}
