package game.elements;

public class RogueGainDamage implements Strategy {
    @Override
    public void setStats(Player player) {
        player.takeDamage(Math.round((float)1/7 * player.getHP()));
        player.setDamageModifier(1.4f);
    }
}
