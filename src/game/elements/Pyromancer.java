package game.elements;

import static game.elements.Constants.PYROMANCER_LEVEL_HP_BONUS;
import static game.elements.Constants.PYROMANCER_MAX_HP;

public final class Pyromancer extends Player {
    public Pyromancer(final int positionX, final int positionY) {
        super(positionX, positionY);
        heroClass = "Pyromancer";
        resetHP();
        abilities.add(new Fireblast());
        abilities.add(new Ignite());
    }

    public void accept(final Ability ability) {
        ability.target(this);
    }

    public int getMaxHP() {
        return PYROMANCER_MAX_HP + PYROMANCER_LEVEL_HP_BONUS * level;
    }
}
