package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.LIFE_GIVER_KNIGHT_MODIFIER;
import static game.elements.Constants.LIFE_GIVER_PYROMANCER_MODIFIER;
import static game.elements.Constants.LIFE_GIVER_ROGUE_MODIFIER;
import static game.elements.Constants.LIFE_GIVER_WIZARD_MODIFIER;

public class LifeGiver extends Angel {
    public LifeGiver(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "LifeGiver";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = LIFE_GIVER_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = LIFE_GIVER_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = LIFE_GIVER_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = LIFE_GIVER_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        int maxHP = HPTable.getInstance().getTable().get(player.getHeroClass()
                + "Start") + player.getLevel()
                * HPTable.getInstance().getTable().get(player.getHeroClass() + "Level");

        player.gainHP(modifier);

        if (player.getHP() > maxHP) {
            player.resetHP();
        }

        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
    }
}
