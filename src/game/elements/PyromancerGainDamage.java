package game.elements;

public class PyromancerGainDamage implements Strategy {
    @Override
    public void setStats(Player player) {
        player.takeDamage(Math.round((float)1/4 * player.getHP()));
        player.setDamageModifier(1.7f);
    }
}
