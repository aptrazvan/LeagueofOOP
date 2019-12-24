package game.elements;

public class WizardGainHP implements Strategy {
    @Override
    public void setStats(Player player) {
        player.gainHP(Math.round((float)1/5 * player.getHP()));
        player.addDamageModifier(-0.2f);
    }
}
