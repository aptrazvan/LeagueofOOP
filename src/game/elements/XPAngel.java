package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.XP_ANGEL_KNIGHT_MODIFIER;
import static game.elements.Constants.XP_ANGEL_PYROMANCER_MODIFIER;
import static game.elements.Constants.XP_ANGEL_ROGUE_MODIFIER;
import static game.elements.Constants.XP_ANGEL_WIZARD_MODIFIER;

public class XPAngel extends Angel {
    public XPAngel(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "XPAngel";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = XP_ANGEL_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = XP_ANGEL_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = XP_ANGEL_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = XP_ANGEL_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
        player.gainXP(modifier);
        player.levelUp();
    }
}
