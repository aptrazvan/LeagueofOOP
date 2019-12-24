package game.elements;

public class KnightGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1 / 4 * player.getHP()));
        player.addDamageModifier(-0.2f);
    }
}
