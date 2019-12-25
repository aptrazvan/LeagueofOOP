package game.elements;

import static game.elements.Constants.ANGEL_HIT_STATE;
import static game.elements.Constants.DAEK_ANGEL_WIZARD_MODIFIER;
import static game.elements.Constants.DARK_ANGEL_KNIGHT_MODIFIER;
import static game.elements.Constants.DARK_ANGEL_PYROMANCER_MODIFIER;
import static game.elements.Constants.DARK_ANGEL_ROGUE_MODIFIER;

public class DarkAngel extends Angel {
    public DarkAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "DarkAngel";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = DARK_ANGEL_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = DARK_ANGEL_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = DARK_ANGEL_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = DAEK_ANGEL_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        player.takeDamage(modifier);
        Subject.getInstance().setState(ANGEL_HIT_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
