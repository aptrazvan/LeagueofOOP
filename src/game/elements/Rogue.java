package game.elements;

import static game.elements.Constants.ROGUE_HIGHER_HP_STRATEGY;
import static game.elements.Constants.ROGUE_LEVEL_HP_BONUS;
import static game.elements.Constants.ROGUE_LOWER_HP_STRATEGY;
import static game.elements.Constants.ROGUE_MAX_HP;

public final class Rogue extends Player {
    public Rogue(final int positionX, final int positionY) {
        super(positionX, positionY);
        heroClass = "Rogue";
        resetHP();
        abilities.add(new Backstab());
        abilities.add(new Paralysis());
    }

    public void accept(final Ability ability) {
        ability.target(this);
    }

    public int getMaxHP() {
        return ROGUE_MAX_HP + ROGUE_LEVEL_HP_BONUS * level;
    }

    public Context getContext() {
        Context context = null;
        if (ROGUE_LOWER_HP_STRATEGY * getMaxHP() < getHP()
                && getHP() < ROGUE_HIGHER_HP_STRATEGY * getMaxHP()) {
            context = new Context(new RogueGainDamage());
        } else if (getHP() < ROGUE_LOWER_HP_STRATEGY * getMaxHP()) {
            context = new Context(new RogueGainHP());
        }

        return context;

    }
}
