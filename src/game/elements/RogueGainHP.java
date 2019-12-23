package game.elements;

public class RogueGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1/2 * player.getHP()));
        player.setDamageModifier(0.9f);
    }
}
