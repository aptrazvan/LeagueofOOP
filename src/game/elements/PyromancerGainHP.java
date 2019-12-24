package game.elements;

public class PyromancerGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1/3 * player.getHP()));
        player.addDamageModifier(-0.3f);
    }
}
