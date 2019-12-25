package game.elements;

import static game.elements.Constants.ANGEL_HIT_STATE;
import static game.elements.Constants.ANGEL_KILL_STATE;

public class TheDoomer extends Angel {
    public TheDoomer(final int round, final int positionX, final int positionY) {
        super(round, positionX, positionY);
        angelClass = "TheDoomer";
    }

    @Override
    public final void interact(final Player player) {
        player.setHP(0);
        Subject.getInstance().setState(ANGEL_HIT_STATE, angelClass, player.getHeroClass(),
                0, player.getId());
        Subject.getInstance().setState(ANGEL_KILL_STATE, player.getHeroClass(), null,
                player.getId(), 0);
    }
}
