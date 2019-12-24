package game.elements;

public class WizardGainDamage implements Strategy {
    @Override
    public void setStats(Player player) {
        player.takeDamage(Math.round((float)1/10 * player.getHP()));
        player.addDamageModifier(0.6f);
    }
}
