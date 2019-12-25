package game.elements;

import static game.elements.Constants.ANGEL_HELP_STATE;
import static game.elements.Constants.ANGEL_SPAWNER_STATE;
import static game.elements.Constants.SPAWNER_KNIGHT_MODIFIER;
import static game.elements.Constants.SPAWNER_PYROMANCER_MODIFIER;
import static game.elements.Constants.SPAWNER_ROGUE_MODIFIER;
import static game.elements.Constants.SPAWNER_WIZARD_MODIFIER;

public class Spawner extends Angel {
    public Spawner(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "Spawner";
    }

    @Override
    public final void interact(final Player player) {
        int modifier = 0;

        switch (player.getHeroClass()) {
            case "Knight":
                modifier = SPAWNER_KNIGHT_MODIFIER;
                break;
            case "Pyromancer":
                modifier = SPAWNER_PYROMANCER_MODIFIER;
                break;
            case "Rogue":
                modifier = SPAWNER_ROGUE_MODIFIER;
                break;
            case "Wizard":
                modifier = SPAWNER_WIZARD_MODIFIER;
                break;
            default:
                break;
        }

        player.setHP(modifier);
        Subject.getInstance().setState(ANGEL_HELP_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
        Subject.getInstance().setState(ANGEL_SPAWNER_STATE, player.getHeroClass(), null,
                player.getId(), 0);
    }
}
