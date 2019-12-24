package game.elements;

import static game.elements.Constants.WIZARD_LEVEL_HP_BONUS;
import static game.elements.Constants.WIZARD_MAX_HP;

public final class Wizard extends Player {
    private int damageReceived;

    public Wizard(final int positionX, final int positionY) {
        super(positionX, positionY);
        heroClass = "Wizard";
        resetHP();
        abilities.add(new Drain());
        abilities.add(new Deflect());
        damageReceived = 0;
    }

    public void accept(final Ability ability) {
        ability.target(this);
    }

    public int getMaxHP() {
        return WIZARD_MAX_HP + WIZARD_LEVEL_HP_BONUS * level;
    }

    public int getDamageReceived() {
        return damageReceived;
    }

    public void setDamageReceived(final int damage) {
        damageReceived = damage;
    }

    public void addDamageReceived(final int damage) {
        damageReceived += damage;
    }

    public Context getContext() {
        Context context = null;
        if ((float) 1 / 4 * getMaxHP() < getHP() && getHP() < (float) 1 / 2 * getMaxHP()) {
            context = new Context(new WizardGainDamage());
        } else if (getHP() < (float) 1 / 4 * getMaxHP()) {
            context = new Context(new WizardGainHP());
        }

        return context;

    }
}
