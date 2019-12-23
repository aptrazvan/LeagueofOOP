package game.elements;

public class PyromancerGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1/3 * player.getHP()));
        player.setDamageModifier(0.7f);
    }
}
