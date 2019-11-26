package game.elements;

import static game.elements.Constants.KNIGHT_LEVEL_HP_BONUS;
import static game.elements.Constants.KNIGHT_MAX_HP;

public final class Knight extends Player {
    public Knight(final int positionX, final int positionY) {
        super(positionX, positionY);
        heroClass = "Knight";
        resetHP();
        abilities.add(new Execute());
        abilities.add(new Slam());
    }

    public void accept(final Ability ability) {
        ability.target(this);
    }

    public int getMaxHP() {
        return KNIGHT_MAX_HP + KNIGHT_LEVEL_HP_BONUS * level;
    }
}
